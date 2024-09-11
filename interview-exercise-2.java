import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.Duration;

// Page Object Class for the Search Page
class SearchPage {
    WebDriver driver;
    
    By searchBox = By.name("q");
    By searchButton = By.name("btnK");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchQuery(String query) {
        driver.findElement(searchBox).sendKeys(query);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).submit();
    }
}

// Test Class for Testing Search Functionality
public class SearchAutomationTest {
    WebDriver driver;
    SearchPage searchPage;

    @Before
    public void setUp() {
        // Set up ChromeDriver (assume ChromeDriver path is set in system variables)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchFunctionality() {
        String searchQuery = "Selenium WebDriver";

        // Perform search
        searchPage.enterSearchQuery(searchQuery);
        searchPage.clickSearchButton();

        // Wait for results to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstResult = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Selenium WebDriver')]"))
        );

        // Validate that the result contains expected text
        assertNotNull(firstResult);
        assertTrue(firstResult.getText().contains("Selenium WebDriver"));
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
