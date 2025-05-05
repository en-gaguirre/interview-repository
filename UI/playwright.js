const { chromium } = require('playwright');

(async () => {
  const browser = await chromium.launch();
  const page = await browser.newPage();

  await page.goto('https://www.example.com/login');

  const username = page.getByRole((textbox), { name: 'Username' }).write('admin');
  const password = page.getByRole((textbox), { name: 'Password' }).write('password123');
  const loginBtn = page.getByRole((button), { name: 'Login' }).click();

  await page.waitForSelector('dashboard');

  await browser.close();
})();
