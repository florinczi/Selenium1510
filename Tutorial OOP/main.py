from item import Item

item1 = Item("My Item", 750)

item1.apply_increment(0.2)
print (item1.price)
item1.price = item1.price * 0,2
print (item1.price)