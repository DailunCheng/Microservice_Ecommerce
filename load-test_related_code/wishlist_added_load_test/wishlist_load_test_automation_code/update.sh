#payment
sudo docker update --cpuset-cpus="1-1" dockercompose_payment_1
#shipping
sudo docker update --cpuset-cpus="1-1" dockercompose_shipping_1
#catalogue
sudo docker update --cpuset-cpus="1-1" dockercompose_catalogue_1
#rabbitmq
sudo docker update --cpuset-cpus="1-1" dockercompose_rabbitmq_1
#orders 
sudo docker update --cpuset-cpus="1-1" dockercompose_orders_1
#orders_db
sudo docker update --cpuset-cpus="1-1" dockercompose_orders-db_1
#cart_db
sudo docker update --cpuset-cpus="1-1" dockercompose_carts-db_1
#user db
sudo docker update --cpuset-cpus="2-2" dockercompose_user-db_1
#user
sudo docker update --cpuset-cpus="2-2" dockercompose_user_1
#queue master
sudo docker update --cpuset-cpus="2-2" dockercompose_queue-master_1
#catalogue db
sudo docker update --cpuset-cpus="2-2" dockercompose_catalogue-db_1
#edge router
sudo docker update --cpuset-cpus="2-2" dockercompose_edge-router_1
#front end
sudo docker update --cpuset-cpus="2-2" dockercompose_front-end_1
#carts
sudo docker update --cpuset-cpus="2-2" dockercompose_carts_1
#wishlist
sudo docker update --cpuset-cpus="3-3" dockercompose_wishlists_1
#wishlistdb
sudo docker update --cpuset-cpus="3-3" dockercompose_wishlists-db_1


