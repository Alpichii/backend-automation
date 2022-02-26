package API_TDD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo_classes.pets.Category;
import pojo_classes.pets.CreatePet;
import pojo_classes.pets.Tags;

import java.util.Collections;

public class PetsAPIWithLombok {

    Faker faker = new Faker();
    Response response;
    ObjectMapper objectMapper = new ObjectMapper();

    int actualPetId;
    String actualPetName;
    String actualPetStatus;
    int actualCategoryId;
    String actualCategoryName;
    int actualTagsId;
    String actualTagsName;
    String actualPhotoUrl;

    @BeforeSuite
    public void testingStarts() {
        System.out.println("API Automation starts");
    }

    @BeforeTest
    public void beforeTesting() {
        RestAssured.baseURI = utils.ConfigReader.getProperty("PetsURL");
    }

    @Test
    public void petsCRUD() throws JsonProcessingException {

//        Category buildCategory = Category.builder().build();
//        Tags buildTags = Tags.builder().build();
//
//        CreatePet createPet = CreatePet.builder()
//                .category(buildCategory)
//                .photoUrls(Collections.singletonList(("My Dog URL")))
//                .tags(Collections.singletonList(buildTags))
//                .build();

        Category buildCategory = Category.builder().build();
        Tags buildTags = Tags.builder().build();

        CreatePet createPet = CreatePet.builder().id(3).name("Marco")
                .category(buildCategory)
                .photoUrls(Collections.singletonList(("My Dog URL")))
                .tags(Collections.singletonList(buildTags))
                .build();

        response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createPet))
                .post("/v2/pet")
                .then().log().all().assertThat().statusCode(200)
                .extract().response();

/**
 * Getting the actuall attributes' values from response body
 */

        actualPetId = JsonPath.read(response.asString(), "id");
        System.out.println("Actual PetId from the response body: " + actualPetId);


//        Assert.assertEquals();
    }
}
