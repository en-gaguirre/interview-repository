import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginAutomationTest {
    WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver (assume ChromeDriver path is set in system variables)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login");
    }

    @Test
    public void testLogin() {
        try {
            // Locate username field and enter text
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("testuser");

            // Locate password field and enter text
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("password123");

            // Locate login button and click
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Wait for page to load and check for logout button
            WebElement logoutButton = driver.findElement(By.id("logoutButton"));
            assertTrue(logoutButton.isDisplayed());

        } catch (NoSuchElementException e) {
            fail("Element not found: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
