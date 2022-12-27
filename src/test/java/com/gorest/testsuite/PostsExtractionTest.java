package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {

    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        // RestAssured.port = 8080;
        response = given()
                .when()
                .get("/posts")
                .then().statusCode(200);
    }

    //1. Extract the title
    @Test
    public void test001() {
        List<String> title = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The title is : " + title);
        System.out.println("------------------End of Test---------------------------");

    }
    //2. Extract the total number of record
    @Test
    public void test002() {
        List<Integer> total = response.extract().path("id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of record is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

        //3. Extract the body of 15th record
    @Test
                public void test003() {
        String body = response.extract().path("[15].body");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("body of 15th record : " + body);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the user_id of all the records

    @Test
    public void test004() {
        List<Integer> userIds =response.extract().path("user_id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("userIds : " + userIds);
        System.out.println("------------------End of Test---------------------------");

    }

    //5. Extract the title of all the records
    @Test
    public void test005() {
        List<String> titles =response.extract().path("title");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("titles : " + titles);
        System.out.println("------------------End of Test---------------------------");

    }

    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void test006() {
        List<String> titles =response.extract().path("findAll{it.user_id= 5456}.title");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("title : " + titles);
        System.out.println("------------------End of Test---------------------------");

    }
    //7. Extract the body of all records whose id = 2671
    @Test
    public void test007() {
        List<String> titles =response.extract().path("findAll{it.id=2671}.body");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("title : " + titles);
        System.out.println("------------------End of Test---------------------------");

    }


}