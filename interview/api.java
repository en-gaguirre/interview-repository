import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class PostRequestTest {

    @Test
    public void testCreateUser() {
        // Base URI
        RestAssured.baseURI = "https://api.example.com";

        // JSON payload for the request
        String requestBody = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"password\": \"SecurePass123\"\n" +
                "}";

        // Sending the request
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .get("/createUser")
                .then()
                .log().all() // Log the response for debugging
                .statusCode(200)
                .body("message", equalTo("User created successfully"))
                .body("userId", notNullValue()) // Ensure userId is present in the response
                .extract()
                .response();

        // Extract specific fields from the response for further validation
        String userId = response.jsonPath().getString("userId");
        assert userId != null && !userId.isEmpty();
    }
}
