import base64

from locust import HttpLocust, TaskSet, task
from random import randint, choice


class WebTasks(TaskSet):

    @task
    def load(self):
        base64string = base64.encodestring('%s:%s' % ('user', 'password')).replace('\n', '')

        catalogue = self.client.get("/catalogue").json()
        category_item = choice(catalogue)
        item_id = category_item["id"]
        # go to homepage, login, browse categroy and check each item
        self.client.get("/")
        self.client.get("/login", headers={"Authorization":"Basic %s" % base64string})

        self.client.get("/category.html")

        self.client.get("/detail.html?id={}".format(item_id))

        # empty carts?
        self.client.delete("/cart")
        # add item into wishlist
        self.client.delete("/wishlist")
        self.client.post("/wishlist", json={"id": item_id, "quantity": 1})
        # put everything from wishlist to cart
        self.client.post("/cart", json={"id": item_id, "quantity": 1})
        self.client.delete("/wishlist")
        # add everything to cart, go to basket, check out
        self.client.post("/cart", json={"id": item_id, "quantity": 1})
        self.client.get("/basket.html")
        self.client.post("/orders")


class Web(HttpLocust):
    task_set = WebTasks
    min_wait = 0
    max_wait = 0
