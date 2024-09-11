import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

// User class for API request payload
class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
}

public class APITestAndUITest {
    WebDriver driver;
    String baseUrl = "https://example.com";
    String apiEndpoint = baseUrl + "/api/users";
    String createdUsername = "newuser";
    String createdPassword = "password123";

    @Before
    public void setUp() {
        // Set up ChromeDriver (assume ChromeDriver path is set in system variables)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl + "/login");
    }

    @Test
    public void testCreateUserAndLogin() {
        // Step 1: API Request - Create a New User
        User newUser = new User(createdUsername, createdPassword, "newuser@example.com");

        Response response = given()
            .contentType(ContentType.JSON)
            .body(newUser)
            .when()
            .post(apiEndpoint);

        // Step 2: Verify API Response
        assertEquals(201, response.getStatusCode()); // Check if user was created (HTTP 201)
        String responseUsername = response.jsonPath().getString("username");
        assertEquals(createdUsername, responseUsername); // Verify username in response

        // Step 3: UI Test - Log in as the New User
        // Locate username field and enter the created username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(createdUsername);

        // Locate password field and enter the created password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(createdPassword);

        // Locate login button and click
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Step 4: Verify Login Success
        WebElement logoutButton = driver.findElement(By.id("logoutButton"));
        assertTrue(logoutButton.isDisplayed()); // Confirm that the user is logged in by checking logout button visibility
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
