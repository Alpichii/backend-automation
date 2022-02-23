package AutomationSample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class GoRest {

    public static void main(String[] args) {

        // Sending get request to get single user
        Response response = RestAssured
                .given()
                // header is smiler where in the postman
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer bf5065bb8a90de145d38ecbc2aec4744a1ca2c57f83b7a5be93061df4376911c")
                // sending the url with the user id
                .when().get("https://gorest.co.in/public/v2/users/3482")
                // extracting the response
                .then().extract().response();

        // Getting the whole response body
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        // Getting response code
        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        // Getting the username
        String actualUsername = response.jsonPath().getString("name");
        System.out.println("Actual user name is: " + actualUsername);

        // Getting the user id
        int actualId = response.jsonPath().getInt("id");
        System.out.println("Actual user id is: " + actualId);
        Assert.assertEquals(actualId, 348, "UserId is");

    }
}
