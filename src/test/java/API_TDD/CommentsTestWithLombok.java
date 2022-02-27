package API_TDD;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojo_classes.go_rest_comments.Comments;
import pojo_classes.go_rest_comments.Datum;
import pojo_classes.go_rest_comments.Meta;
import pojo_classes.go_rest_comments.Pagination;

import java.util.Collections;

public class CommentsTestWithLombok {

    Faker faker = new Faker();

    Response response;

    ObjectMapper objectMapper = new ObjectMapper();

    String actualName;
    int actualUserId;
    String actualEmail;
    String actualStatus;
    String actualGender;

    @BeforeSuite
    public void testingStarts() {
        System.out.println("API Automation starts");
    }

    @BeforeTest
    public void beforeTesting() {
        RestAssured.baseURI = utils.ConfigReader.getProperty("GoRestURL");
    }

    @Test
    public void testingGoRestComment() throws JsonProcessingException {

        Pagination pagination = Pagination.builder().total(1).pages(2).page(6).limit(200).build();
        Meta meta = Meta.builder().pagination(pagination).build();
        Datum datum = Datum.builder().post_id(4).id(6).name("Khalid").email("Jafeth").body("Seda").build();
        Comments comments = Comments.builder().meta(meta).datum(Collections.singletonList(datum)).build();


        response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", utils.ConfigReader.getProperty("Token"))
                .body(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(comments))
                .post("/public-api/comments")
                .then().log().all().assertThat().statusCode(200)
                .extract().response();

        int statusCode = response.getStatusCode();
        System.out.println("My status code from the comments response: " + statusCode);


    }
}