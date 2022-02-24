package API_TDD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo_classes.users.CreateUser;

import static org.hamcrest.Matchers.equalTo;

public class GoRest {

    Faker faker = new Faker();

    Response response;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeSuite
    public void testingStarts() {
        System.out.println("API Automation starts");
    }

    @BeforeTest
    public void beforeTesting() {
        RestAssured.baseURI = utils.ConfigReader.getProperty("GoRestURL");
    }


    @Test
    public void CRUD() throws JsonProcessingException {

        CreateUser createUser = new CreateUser();

        createUser.setName("Tech Global");
        createUser.setEmail(faker.internet().emailAddress());
        createUser.setGender("female");
        createUser.setStatus("active");

        response = RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", utils.ConfigReader.getProperty("Token"))
                .body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createUser))
                .when().post("/public/v2/users")
                .then().log().all()
                .assertThat().statusCode(201)
                .body("name", equalTo("Tech Global")).extract().response();

//        String postResponseBody = response.getBody().asString();
//        System.out.println("POST Response body is: " + postResponseBody);

    }
}
