package AutomationSample;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class GoRest {

    public static void main(String[] args) {

        Response response;

        Faker faker = new Faker();

        int actualUserId;

        // Sending post request to get single user
        response = RestAssured
                .given()
                // header is smiler where in the postman
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer bf5065bb8a90de145d38ecbc2aec4744a1ca2c57f83b7a5be93061df4376911c")
                .body("{\n" +
                        "    \"name\": \"Tech Global V\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"" + faker.internet().emailAddress() + "\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                // sending the post URL
                .when().post("https://gorest.co.in/public/v2/users")
                // extracting the response
                .then().extract().response();

        String postResponseBody = response.getBody().asString();
        System.out.println("POST Response body is: " + postResponseBody);

        actualUserId = response.jsonPath().getInt("id");
        System.out.println("Getting the actual User Id: " + actualUserId);
        String actualEmail = response.jsonPath().getString("email");

        // Sending get request to get single user
        response = RestAssured
                .given()
                // header is smiler where in the postman
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer bf5065bb8a90de145d38ecbc2aec4744a1ca2c57f83b7a5be93061df4376911c")
                // sending the url with the user id
                .when().get("https://gorest.co.in/public/v2/users/" + actualUserId)
                // extracting the response
                .then().extract().response();

        // Getting the whole response body
        String getResponseBody = response.getBody().asString();
        System.out.println("GET Response body is: " + getResponseBody);

        // Getting response code
        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        // Getting the username
        String actualUsername = response.jsonPath().getString("name");
        System.out.println("Actual user name is: " + actualUsername);

        // Getting the user id
        int responseId = response.jsonPath().getInt("id");
        System.out.println("User id from the GET call response: " + responseId);
        Assert.assertEquals(actualUserId, responseId, "UserId is");

        // Updating the user with the PUT method
        response = RestAssured.given()
                // header is smiler where in the postman
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer bf5065bb8a90de145d38ecbc2aec4744a1ca2c57f83b7a5be93061df4376911c")
                .body("{\n" +
                        "    \"name\": \"" + faker.name().fullName() + "\",\n" +
                        "    \"email\": \"" + actualEmail + "\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when().put("https://gorest.co.in/public/v2/users/" + actualUserId)
                .then().extract().response();

        // Getting the whole response body
        String updatedResponseBody = response.getBody().asString();
        System.out.println("PUT Response body is: " + updatedResponseBody);

        // Deleting user with DELETE method

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer bf5065bb8a90de145d38ecbc2aec4744a1ca2c57f83b7a5be93061df4376911c")
                .when().delete("https://gorest.co.in/public/v2/users/" + actualUserId)
                .then().extract().response();

        int deleteResponseStatusCode = response.statusCode();
        System.out.println("Status code after deleting should be: " + deleteResponseStatusCode);

        Assert.assertEquals(deleteResponseStatusCode, 204, "Status code after the delete is: ");
    }
}
