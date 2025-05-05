from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def test_login():
    driver = webdriver.Chrome()

    driver.get("www.example.com/login")

    time.sleep(4)

    username = driver.find_element(By.ID, "usename")
    password = driver.find_element(By.ID, "password")
    login_btn = driver.find_element(By.ID, "loginButton")

    username.write("admin")
    password.write("password123")
    login_btn.click()

    WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.ID, "dashbord"))
    )

    driver.quit()
