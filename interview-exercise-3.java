import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationAutomationTest {

    public static void main(String[] args) {
        
        
        System.setProperty("webdriver.chrome.driver", "path/to/driver"); 
        WebDriver driver = new ChromeDriver();
        driver.get("example.com/register"); 
        WebElement firstNameField = driver.findElement(By.id("first_name"));
        WebElement lastNameField = driver.findElement(By.id("last_name"));
        WebElement emailField = driver.findElement(By.id("mail")); 
        
        firstNameField.sendKeys("John");  
        lastNameField.sendKeys("Doe");
        emailField.sendKeys("john.doe@example.com");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click(); 

       
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_msg")));

        if (successMessage.isDisplayed()) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed!");
        }
        
        driver.quit(); 
    }
}
