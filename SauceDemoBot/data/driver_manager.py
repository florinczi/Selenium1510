from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

# This class is responsible for choosing, installing and initializing the correct webdriver from repo
# If needed can be expanded for drivers other then chrome

class DriverManager(webdriver.Chrome(service=Service(ChromeDriverManager().install()))):
    def __init__(self):
        #self.driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
        super().__init__()
        
        
    def get_driver(self):
        return(self.driver)


driver_manager = DriverManager()
