from playwright.sync_api import sync_playwright

def run():
    with sync_playwright() as p:
        browser = p.chromium.launch()
        page = browser.new_page()

        page.goto("https://www.example.com/login")

        page.get_by_role((textbox), name="Username").write("admin")
        page.get_by_role((textbox), name="Password").write("password123")
        page.get_by_role((button), name="Login").click()

        page.wait_for_selector("dashboard")

        browser.close()

run()
