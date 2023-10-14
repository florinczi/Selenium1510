from item import Item

class Phone(Item):
    all = []
    def __init__(self, name: str, price: float, quantity=0, broken_phones=0) -> None:
       #Call to super function to have access to all attributes/functions
        super().__init__(
            name,
            price,
            quantity
        )
       
       # Run Validations to the received arguments
        assert price >= 0, f"price {price} is not greater than 0!"
        assert quantity >= 0, f"quantity {quantity} is not greater than 0!"
        assert broken_phones >= 0, f"{broken_phones} is lower than 0"

        #Assign to self object
        # self.name = name
        # self.price = price
        # self.quantity = quantity

        # Actions to execute
        Phone.all.append(self)