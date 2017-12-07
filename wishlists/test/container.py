import argparse
import sys
import unittest
import os
from util.Api import Api
from time import sleep

from util.Docker import Docker
from util.Dredd import Dredd

class WishlistContainerTest(unittest.TestCase):
    TAG = "latest"
    COMMIT = ""
    container_name = Docker().random_container_name('wishlists')
    mongo_container_name = Docker().random_container_name('wishlists-db')
    def __init__(self, methodName='runTest'):
        super(WishlistContainerTest, self).__init__(methodName)
        self.ip = ""
        
    def setUp(self):
        Docker().start_container(container_name=self.mongo_container_name, image="mongo", host="wishlists-db")
        command = ['docker', 'run',
                   '-d',
                   '--name', WishlistContainerTest.container_name,
                   '-h', 'wishlists',
                   '--link',
                   WishlistContainerTest.mongo_container_name,
                   'weaveworksdemos/wishlists:' + self.COMMIT]
        Docker().execute(command)
        self.ip = Docker().get_container_ip(WishlistContainerTest.container_name)

    def tearDown(self):
        Docker().kill_and_remove(WishlistContainerTest.container_name)
        Docker().kill_and_remove(WishlistContainerTest.mongo_container_name)

    def test_api_validated(self):
        limit = 30
        while Api().noResponse('http://' + self.ip + ':80/wishlists/'):
            if limit == 0:
                self.fail("Couldn't get the API running")
            limit = limit - 1
            sleep(1)
        
        out = Dredd().test_against_endpoint(
            "wishlists", "http://wishlists/",
            links=[self.mongo_container_name, self.container_name],
            env=[("MONGO_ENDPOINT", "mongodb://wishlists-db:27017/data")],
            dump_streams=True)
        self.assertGreater(out.find("0 failing"), -1)
        self.assertGreater(out.find("0 errors"), -1)
        print(out)

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    default_tag = "latest"
    parser.add_argument('--tag', default=default_tag, help='The tag of the image to use. (default: latest)')
    parser.add_argument('unittest_args', nargs='*')
    args = parser.parse_args()
    WishlistContainerTest.TAG = args.tag

    if WishlistContainerTest.TAG == "":
        WishlistContainerTest.TAG = default_tag

    WishlistContainerTest.COMMIT = os.environ["COMMIT"]   
    # Now set the sys.argv to the unittest_args (leaving sys.argv[0] alone)
    sys.argv[1:] = args.unittest_args
    unittest.main()
