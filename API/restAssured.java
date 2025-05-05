import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class restAssured {

    @Test
    public void testCreateUser() {
        RestAssured.baseURI = "https://api.example.com";

        String requestBody = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"password\": \"SecurePass123\"\n" +
                "}";

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .get("/createUser")
                .then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("User created successfully"))
                .body("userId", notNullValue())
                .extract()
                .response();

        String userId = response.jsonPath().getString("userId");
        assert userId != null && !userId.isEmpty();
    }
}
