from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

from selenium.webdriver.support import expected_conditions as EC




driver = webdriver.Firefox(service=FirefoxService(GeckoDriverManager().install()))


driver.get('https://www.saucedemo.com')
driver.implicitly_wait(8)
usr = driver.find_element(By.ID, 'user-name')
pwd = driver.find_element(By.ID, 'password')
loginButton = driver.find_element(By.ID, 'login-button')

usr.send_keys("standard_user")
pwd.send_keys("secret_sauce")
loginButton.click()

# print (WebDriverWait(driver, 30).until(
#         EC.text_to_be_present_in_element(
#         (By.CLASS_NAME, 'title'), #Szukanie elementu
#         'Complete!'
#     )
# ))


loginConfirmedElement = driver.find_element(By.CLASS_NAME, 'title')
if loginConfirmedElement.text == 'Products':
    print ("Test successful.")


