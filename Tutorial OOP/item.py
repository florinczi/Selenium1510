import csv

class Item:
    pay_rate = 0.8 # Pay rate after 20% discount
    all = []
    def __init__(self, name: str, price: float, quantity=0) -> None:
        # Run Validations to the received arguments
        assert price >= 0, f"price {price} is not greater than 0!"
        assert quantity >= 0, f"quantity {quantity} is not greater than 0!"

        #Assign to self object
        self.__name = name
        self.__price = price
        self.quantity = quantity

        # Actions to execute
        Item.all.append(self)

    @property
    def price(self):
        return self.__price
    
    @property
    #Property decorator - this is read only
    def name (self):
        return self.__name
     
    @name.setter
    def name (self, value):
        self.__name = value

    def __repr__(self):
        return f"{self.__class__.__name__}('{self.name}', {self.__price}, {self.quantity})"
    
    @classmethod
    def instantiate_from_csv(cls):
        with open('items.csv', 'r') as f:
            reader = csv.DictReader(f)
            items = list(reader)

        for item in items:
            # print (item)
            Item(
                name = item.get('name'),
                price =  float(item.get('price')),
                quantity = int(item.get('quantity')),
            )

    @staticmethod
    def is_integer(num):
        # We will count out the floats that are point zero
        # For i.e: 5.0, 10.0
        if isinstance(num, float):
            return num.is_integer()
        elif isinstance(num, int):
            return True
        else:
            return False    

    def calculate_total_price(self):
        return self.__price * self.quantity
    
    def apply_discount (self):
        self.__price = self.__price * self.pay_rate

    def apply_increment(self, increment_value):
        self.__price = self.__price + self.__price * increment_value