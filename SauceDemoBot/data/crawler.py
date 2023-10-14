import types
import typing
from selenium import common
from selenium import webdriver
from selenium.webdriver.support import expected_conditions as EC
#from data.driver_manager import driver_manager
import data.constants as const
from selenium.webdriver.common.by import By
#from selenium.webdriver.chrome.service import Service
#from webdriver_manager.chrome import ChromeDriverManager


class Crawler (webdriver.Chrome):
    def __init__(self):

        super(Crawler, self).__init__()
        self.implicitly_wait(15)
        self.maximize_window()
        self._list_of_products = None #This will list all items from the storepage
        self._list_of_cart = None
        self._tested_product = None #This is a particular item selected for further testing
        self._tested_cart_product = None

    def goto_login_page(self):
        self.get(const.FRONTPAGE_URL)
             

    

    def login(self, user: str = const.USER, password: str = const.PASSWORD): #remember about restricting types when defining functions
        # This method uses standard credentials from constants.py by default
        usr = self.find_element(By.ID, 'user-name')
        pwd = self.find_element(By.ID, 'password')
        loginButton = self.find_element(By.ID, 'login-button')
        usr.clear();
        usr.send_keys(user)
        pwd.clear()
        pwd.send_keys(password)
        loginButton.click()
        try:
            assert self.current_url == const.INVENTORY_URL
            #Checks if the inventory page is accessible.
        except AssertionError as e:
            print (f"{e}, \n\n****** Login failed.****** \nUser used: {user}\nPassword used: {password}")
        else:
            print (f"Logged in successfully with user: {user} and password {password}")

    def goto_inventory(self):
        self.get(const.INVENTORY_URL)

    def check_for_error_message(self):
        try:
            element = self.find_element(By.CLASS_NAME, "error-message-container")
        except common.exceptions.NoSuchElementException as e:
            print (f"{e}, \n\n*****Failed to locate an error message.*****")
        else:
            print (f"Error message:\n\n {element.text} \n\nlocated successfully")

    def update_products(self):
        try:
            self._list_of_products = self.find_elements(By.CLASS_NAME, "inventory_item")
        except common.exceptions.NoSuchElementException as e:
            print (f"{e}, \n\n*****Failed to locate any product.*****")
        else:
            print ("List of products updated successfully.")

    def select_product(self, name):
        if self._list_of_products == None:
            self.update_products()

        for e in self._list_of_products:
           
            success = False 
            element = e.find_element(By.CSS_SELECTOR, "div.inventory_item_name")
            #element is an Item Name Field found in each Item from the list
            if element.text == name:
            
                self._tested_product = e
                print (f"The product {name} has been found")
                success = True
                break
            else: print (f"Searching...")
        if success == False:
            print (f"The product {name} hasn't been found")

        self._list_of_products = None

    def add_to_cart(self):
        self._tested_product.find_element(By.CLASS_NAME, "btn").click()
  
    def goto_cart(self):
        self.find_element(By.CLASS_NAME, "shopping_cart_link").click()
        print("Navigating to cart...")

    def update_cart(self):
        try:
            self._list_of_cart = self.find_elements(By.CLASS_NAME, "cart_item")
        except common.exceptions.NoSuchElementException as e:
            print (f"{e}, \n\n*****Failed to locate any product.*****")
        else:
            print ("List of cart products updated successfully.")

    def select_in_cart (self, name):
        if self._list_of_cart == None:
            self.update_cart()

        for e in self._list_of_cart:
           
            success = False 
            element = e.find_element(By.CLASS_NAME, "inventory_item_name")
            #element is an Item Name Field found in each Item from the list
            if element.text == name:
            
                self._tested_cart_product = e
                print (f"The product {name} has been found")
                success = True
                break
            else: print (f"Searching...")
        if success == False:
            print (f"The product {name} hasn't been found")

    def check_price (self, price = 0,):
        check = self._tested_cart_product.find_element(By.CLASS_NAME, "inventory_item_price").text
        try:
            assert check == price
        except AssertionError as e:
            print (f"{e}\n\n Prices don't match. Expected {price}, found {check}")
        else: 
            print (f"Prices match, it costs {check} as expected")

    def goto_checkout (self):
        self.find_element(By.ID, "checkout").click()    
        print ("Going to checkout...")    

    def enter_name (self, name = "Adam", surname = "Smith", zip = "666"):
        name_element = self.find_element(By.ID, 'first-name')
        surname_element = self.find_element(By.ID, 'last-name')
        zip_element = self.find_element(By.ID, 'postal-code')
        name_element.send_keys(name)
        surname_element.send_keys(surname)
        zip_element.send_keys(zip)
        self.find_element(By.ID, "continue").click()
        print ("Shopping details entered, proceeding...")

    def check_total_price(self, price):
        print (self.find_element(By.CLASS_NAME, "summary_total_label").text)
        check = self.find_element(By.CLASS_NAME, "summary_total_label").text
        try:
            assert check == price
        except AssertionError as e:
            print (f"{e}\n\n Prices don't match. Expected {price}, found {check}")
        else: 
            print (f"Prices match, it costs {check} as expected")

        self.find_element(By.ID, "finish").click()
        print (f"\n\n\n ******TEST COMPLETED NOICELY******")
    
            
        