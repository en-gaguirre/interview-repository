eimport org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class CheckoutAutomationTest {

    public static void main(String[] args) {       
        
        WebDriver driver = new ChromeDiver();
        driver.get("example.com/checkout");  

        // Find the product to purchase
        WebElement product = driver.findElement(By.id("produt_item_123"));

        // Add product to cart
        product.click();

        
        WebElement cartIcon = driver.findElement(By.id("cart_icon"));
        cartIcon.click();  

        // Apply coupon code
        WebElement couponField = driver.findElement(By.id("coupon_code"));
        couponField.sendKeys("DISCOUNT10"); 
        WebElement applyCouponButton = driver.findElement(By.id("apply_coupon"));
        applyCouponButton.click();
        
        
        // Proceed to checkout
        WebElement checkoutButton = driver.findElement(By.id("checkout_button"));
        checkoutButton.click();
        
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement paymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_form"))); 

        // Fill in payment details
        WebElement cardNumberField = driver.findElement(By.id("card_number"));
        cardNumberField.sendKeys("4111111111111111");

        WebElement expiryField = driver.findElement(By.id("expiry_date"));
        expiryField.sendKeys("12/24");

        WebElement cvvField = driver.findElement(By.id("cvv"));
        cvvField.sendKeys("123");

        WebElement payButton = driver.findElement(By.id("pay_button"));
        payButton.click(); 

        // Handle dynamic loading of payment confirmation
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#loading').style.display='none';");

        WebElement confirmationMessage = driver.findElement(By.id("confirmation_message"));
        if (confirmationMessage.isDisplayed()) {
            System.out.println("Checkout completed successfully!");
        } else {
            System.out.println("Checkout failed!");
        }

        driver.quit();
    }
}
