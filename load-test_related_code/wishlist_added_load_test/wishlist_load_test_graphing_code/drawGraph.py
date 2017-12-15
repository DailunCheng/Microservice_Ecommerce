__author__ = 'cdl1995'

# wishlist memory tuning
import matplotlib.pyplot as plt
plt.plot([400,450,500,550,600], [1000/95.01,1000/98.39,1000/97.81,1000/101.57,1000/95.70], marker='o',color='r',linestyle='-')
plt.axis([400, 600, 9, 11])
plt.title('Wishlist Memory Tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()

# wishlist-db memory tuning
import matplotlib.pyplot as plt
plt.plot([50,65,75,100,125,150,175,200,225,300], [1000/96.76,1000/97.86,1000/97.56,1000/97.88,1000/99.38,1000/101.05,1000/98.69,1000/99,1000/98.12,1000/100.81], marker='o',color='r',linestyle='-')
plt.axis([50, 300, 9, 11])
plt.title('Wishlist-db Memory Tuning')
plt.ylabel('latency (sec)')
plt.xlabel('memory(MB)')
plt.show()




###### all test
import matplotlib.pyplot as plt
allNo, = plt.plot([500,1000,1500,2000,5000], [76.55,101.49,105.37,106.53,106.03], marker='o', color="blue", label="All test no tuning")
allYes, = plt.plot([500,1000,1500,2000,5000], [92.78,98.81,110.97,109.87,111.83], marker='o', color="green", label="All test with tuning" )
nowishNo, = plt.plot([500,1000,1500,2000,5000], [84.22,84.70,95.13,93.2,99.93], marker='o', color="red", label="Test without wishlist no tuning")
nowishYes, = plt.plot([500,1000,1500,2000,5000], [85.22,88.81,96.63,96.87,97.77], marker='o', color="cyan", label="Test without wishlist with tuning" )
cataItemNo, = plt.plot([500,1000,1500,2000,5000], [0,161.33,251.28,257.85,290.57], marker='o', color="magenta", label="Catalogue and browse item test no tuning")
cataItemYes, = plt.plot([500,1000,1500,2000,5000], [0,175,244.22,275.38,299.67], marker='o', color="yellow", label="Catalogue and browse item test with tuning" )
cataNo, = plt.plot([500,1000,1500,2000,5000], [0,182.5,252.44,257.8,292.37], marker='o', color="black", label="Only catalogue test no tuning")
cataYes, = plt.plot([500,1000,1500,2000,5000], [0,187.67,252.78,242.67,280.47], marker='o', color="white", label="Only catalogue test with tuning" )
# Create a legend for the first line.
first_legend = plt.legend(handles=[cataYes,cataNo,cataItemYes,cataItemNo,nowishYes,nowishNo,allYes,allNo], loc=0)
# Add the legend manually to the current Axes.
ax = plt.gca().add_artist(first_legend)
plt.title('All test')
plt.ylabel('qps (sec)')
plt.xlabel('number of requests')
plt.show()

###### all test vs only cata
import matplotlib.pyplot as plt
allNo, = plt.plot([500,1000,1500,2000,5000], [76.55,101.49,105.37,106.53,106.03], marker='o', color="blue", label="All test no tuning")
allYes, = plt.plot([500,1000,1500,2000,5000], [92.78,98.81,110.97,109.87,111.83], marker='o', color="green", label="All test with tuning" )
cataNo, = plt.plot([500,1000,1500,2000,5000], [0,182.5,252.44,257.8,292.37], marker='o', color="black", label="Only catalogue test no tuning")
cataYes, = plt.plot([500,1000,1500,2000,5000], [0,187.67,252.78,242.67,280.47], marker='o', color="red", label="Only catalogue test with tuning" )
# Create a legend for the first line.
first_legend = plt.legend(handles=[cataYes,cataNo,allYes,allNo], loc=0)
# Add the legend manually to the current Axes.
ax = plt.gca().add_artist(first_legend)
plt.title('All test vs Only catalogue test')
plt.ylabel('qps (sec)')
plt.xlabel('number of requests')
plt.show()

###### all test vs Catalogue and item test
import matplotlib.pyplot as plt
allNo, = plt.plot([500,1000,1500,2000,5000], [76.55,101.49,105.37,106.53,106.03], marker='o', color="blue", label="All test no tuning")
allYes, = plt.plot([500,1000,1500,2000,5000], [92.78,98.81,110.97,109.87,111.83], marker='o', color="green", label="All test with tuning" )
cataItemNo, = plt.plot([500,1000,1500,2000,5000], [0,161.33,251.28,257.85,290.57], marker='o', color="magenta", label="Catalogue and browse item test no tuning")
cataItemYes, = plt.plot([500,1000,1500,2000,5000], [0,175,244.22,275.38,299.67], marker='o', color="yellow", label="Catalogue and browse item test with tuning" )
# Create a legend for the first line.
first_legend = plt.legend(handles=[cataItemYes,cataItemNo,allYes,allNo], loc=0)
# Add the legend manually to the current Axes.
ax = plt.gca().add_artist(first_legend)
plt.title('All test vs Catalogue and item test')
plt.ylabel('qps (sec)')
plt.xlabel('number of requests')
plt.show()

###### all test vs all but wishlist
import matplotlib.pyplot as plt
allNo, = plt.plot([500,1000,1500,2000,5000], [76.55,101.49,105.37,106.53,106.03], marker='o', color="blue", label="All test no tuning")
allYes, = plt.plot([500,1000,1500,2000,5000], [92.78,98.81,110.97,109.87,111.83], marker='o', color="green", label="All test with tuning" )
nowishNo, = plt.plot([500,1000,1500,2000,5000], [84.22,84.70,95.13,93.2,99.93], marker='o', color="red", label="Test without wishlist no tuning")
nowishYes, = plt.plot([500,1000,1500,2000,5000], [85.22,88.81,96.63,96.87,97.77], marker='o', color="cyan", label="Test without wishlist with tuning" )

# Create a legend for the first line.
first_legend = plt.legend(handles=[nowishYes,nowishNo,allYes,allNo], loc=0)
# Add the legend manually to the current Axes.
ax = plt.gca().add_artist(first_legend)
plt.title('All test vs all but wishlist test')
plt.ylabel('qps (sec)')
plt.xlabel('number of requests')
plt.show()

# cpu tuning
import matplotlib.pyplot as plt
# plt.plot([50,80,90,100], [78,86.33,87,78.4], marker='o',color='r',linestyle='-')
plt.plot([0,1,2,3,6,7], [88.59,80.54,77.73,77.67,86.43,94.04], marker='o', color="blue",linestyle='-')
plt.axis([0, 7, 70, 95])
plt.title('All test CPU tuning')
# plt.ylabel('qps(req/sec)')
plt.ylabel('qps (sec)')
plt.xlabel('No. of microservices running on one core')
plt.show()


