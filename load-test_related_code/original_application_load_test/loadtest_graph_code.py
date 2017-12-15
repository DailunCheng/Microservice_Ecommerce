
# coding: utf-8

# In[88]:

import matplotlib.pyplot as plt
# plt.plot([50,80,90,100], [78,86.33,87,78.4], marker='o',color='r',linestyle='-')
plt.plot([50,80,90,100], [1000/78,1000/86.33,1000/87,1000/78.4], marker='o',color='r',linestyle='-')
plt.axis([40, 110, 10, 15])
plt.title('Front-end Memory Tuning')
# plt.ylabel('qps(req/sec)')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[2]:

import matplotlib.pyplot as plt


# In[93]:

# plt.plot([200,250,300,350,400,500], [85,84.67,87.89,85.22,80,79], marker='o',color='r',linestyle='-')
# plt.axis([100, 600, 70, 100])
# plt.title('Orders Memory tuning')
# plt.ylabel('qps(req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()

plt.plot([200,250,300,350,400,500], [1000/85,1000/84.67,1000/87.89,1000/85.22,1000/80,1000/79], marker='o',color='r',linestyle='-')
plt.axis([100, 600, 10, 17])
plt.title('Orders Memory tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[3]:

# plt.plot([300,325,350,400,450,500,600,700], [81.78,84.11,95.25,92,87.11,91.25,83.66,89.33], marker='o',color='r',linestyle='-')
# plt.axis([200, 800, 70, 100])
# plt.title('Users Memory tuning ')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()

plt.plot([300,325,350,400,450,500,600,700], [1000/81.78,1000/84.11,1000/95.25,1000/92,1000/87.11,1000/91.25,1000/83.66,1000/89.33], marker='o',color='r',linestyle='-')
plt.axis([200, 800, 10, 17])
plt.title('Users Memory tuning ')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[4]:

# plt.plot([400,900,1000,1100,1200,1500,3000], [76.8,79.7,87.78,92.25,81.89,83.67,82.22], marker='o',color='r',linestyle='-')
# plt.axis([200, 3500, 70, 100])
# plt.title('Catalog-DB Memory tuning')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()

plt.plot([400,900,1000,1100,1200,1500,3000], [1000/76.8,1000/79.7,1000/87.78,1000/92.25,1000/81.89,1000/83.67,1000/82.22], marker='o',color='r',linestyle='-')
plt.axis([200, 3500, 10, 17])
plt.title('Catalog-DB Memory tuning')
plt.ylabel('latency(sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[6]:

# plt.plot([30,40,45,50,80,90,95,100,200], [83.33,84.67,82.67,80.56,84.67,87.22,91.62,84.22,77.2], marker='o',color='r',linestyle='-')
# plt.axis([10, 250, 60, 100])
# plt.title('Orders-DB Memory tuning')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()

plt.plot([30,40,45,50,80,90,95,100,200], [1000/83.33,1000/84.67,1000/82.67,1000/80.56,1000/84.67,1000/87.22,1000/91.62,1000/84.22,1000/77.2], marker='o',color='r',linestyle='-')
plt.axis([10, 250, 10, 17])
plt.title('Orders-DB Memory tuning')
plt.ylabel('latency(sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[7]:

# plt.plot([35,50,55,60,65,70], [81,84.33,84.89,87.5,82.11,76.2], marker='o',color='r',linestyle='-')
# plt.axis([20, 80, 70, 90])
# plt.title('Users-DB Memory tuning')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()

plt.plot([35,50,55,60,65,70], [1000/81,1000/84.33,1000/84.89,1000/87.5,1000/82.11,1000/76.2], marker='o',color='r',linestyle='-')
plt.axis([20, 80, 10, 17])
plt.title('Users-DB Memory tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[8]:

# plt.plot([400,500,550,600,650,700], [85.67,87.67,90.12,87.78,82.57,83], marker='o',color='r',linestyle='-')
# plt.axis([300, 800, 80, 100])
# plt.title('Shipping Memory tuning')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()

plt.plot([400,500,550,600,650,700], [1000/85.67,1000/87.67,1000/90.12,1000/87.78,1000/82.57,1000/83], marker='o',color='r',linestyle='-')
plt.axis([300, 800, 10, 17])
plt.title('Shipping Memory tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[9]:

# plt.plot([50,60,75,80,90,93,94,95,98,100,125], [83.44,82.44,89.38,81.11,87.89,92,96,86,91.62,88,86.89], marker='o',color='r',linestyle='-')
# plt.axis([40,140,80,100])
# plt.title('QueueMaster Memory tuning')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(GB)')
# plt.show()

plt.plot([50,60,75,80,90,93,94,95,98,100,125], [1000/83.44,1000/82.44,1000/89.38,1000/81.11,1000/87.89,1000/92,1000/96,1000/86,1000/91.62,1000/88,1000/86.89], marker='o',color='r',linestyle='-')
plt.axis([40,140,10,17])
plt.title('QueueMaster Memory tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(GB)')
plt.show()


# In[10]:

# plt.plot([4,10,15,20], [80.5, 85.56, 89, 84], marker='o',color='r',linestyle='-')
# plt.axis([1,30,75,100])
# plt.title('Payment Memory tuning')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()

plt.plot([4,10,15,20], [1000/80.5, 1000/85.56, 1000/89, 1000/84], marker='o',color='r',linestyle='-')
plt.axis([1,30,10,17])
plt.title('Payment Memory tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[11]:

# plt.plot([110,200,300,400, 450, 500, 550, 600], [72.50,81.89,82.11,87,94.88, 86.11,80.33,85.44], marker='o',color='r',linestyle='-')
# plt.axis([100,700,70,100])
# plt.title('RabbitMq Memory tuning')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()

plt.plot([110,200,300,400, 450, 500, 550, 600], [1000/72.50,1000/81.89,1000/82.11,1000/87,1000/94.88, 1000/86.11,1000/80.33,1000/85.44], marker='o',color='r',linestyle='-')
plt.axis([100,700,10,17])
plt.title('RabbitMq Memory tuning')
plt.ylabel('latency(sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[12]:

plt.plot([250,300,350,400,450,500,550,600,650,700,800], [1000/78.67,1000/80.67,1000/79.3,1000/75.3,1000/83.89,1000/85.89,1000/90.38,1000/93.13,1000/81.22,1000/88.22,1000/88.22], marker='o',color='r',linestyle='-')
plt.axis([200,900,10,17])
plt.title('Carts Memory tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[13]:

plt.plot([50,60,100,200,300,500], [1000/80.7,1000/81.3, 1000/84.78,1000/88.89,1000/82.11,1000/84.78], marker='o',color='r',linestyle='-')
plt.axis([30,600,10,17])
plt.title('Carts DB Memory tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[15]:



# plt.plot([4, 100,150,200,300], [81.67,89.22,78.7,84.33,82], marker='o',color='r',linestyle='-')
# plt.axis([0,400,70,100])
# plt.title('Catalogue Memory tuning')
# plt.ylabel('qps (req/sec)')
# plt.xlabel('memory(MB)')
# plt.show()


plt.plot([4, 100,150,200,300], [1000/81.67,1000/89.22,1000/78.7,1000/84.33,1000/82], marker='o',color='r',linestyle='-')
plt.axis([0,400,10,17])
plt.title('Catalogue Memory tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[81]:

#all
#front-end
plt.plot([50,80,90,100], [78,86.33,87,78.4], marker='o',color='r',linestyle='-')
plt.plot([200,250,300,350,400,500], [85,84.67,87.89,85.22,80,79], marker='o',color='b',linestyle='-')

# plt.title('Front-end Memory Tuning')
# plt.ylabel('latency')
# plt.xlabel('memory(MB)')
# plt.show()
#orders

# plt.axis([100, 600, 70, 100])
# plt.title('Orders Memory tuning')

#users
plt.plot([300,325,350,400,450,500,600,700], [81.78,84.11,95.25,92,87.11,91.25,83.66,89.33], marker='o',color='g',linestyle='-')
# plt.axis([200, 800, 70, 100])

#catalogue db
plt.plot([400,900,1000,1100,1200,1500,3000], [76.8,79.7,87.78,92.25,81.89,83.67,82.22], marker='o',color='y',linestyle='-')
# plt.axis([200, 3500, 70, 100])
# plt.title('Catalog-DB Memory tuning')
# plt.ylabel('latency')
# plt.xlabel('memory(MB)')
# plt.show()

plt.axis([40, 3500, 70, 100])
plt.ylabel('qps (req/sec)')
plt.xlabel('memory(MB)')
plt.show()


# In[82]:

plt.plot([0,1,2,3,6,7], [83.78,76.3, 69.1, 67.1, 54.4, 53], marker='o',color='r',linestyle='-')
plt.axis([0,10,50,100])
plt.title('CPU Tuning')
plt.ylabel('qps (req/sec)')
plt.xlabel('No. of Microservices running on a core')
plt.show()

