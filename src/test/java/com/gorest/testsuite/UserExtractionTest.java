package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {

    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        // RestAssured.port = 8080;
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);

    }

    //1. Extract the All Ids
    @Test
    public void test001(){
        List<Integer> listOfIds = response.extract().path("id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");


    }
    //2. Extract the all Names
    @Test
    public void test002(){
        List<Integer> listOfName = response.extract().path("name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfName);
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the name of 5th object
    @Test
    public void test003(){
        String name = response.extract().path("[5].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("5th name  : " + name);
        System.out.println("------------------End of Test---------------------------");


    }
    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004(){
        List<?> status = response.extract().path("findAll{it.status =='active'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("status  : " + status);
        System.out.println("------------------End of Test---------------------------");

    }
    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005(){
        List<String> gender = response.extract().path("findAll{it.status == 'active'}.status");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("status  : " + gender);
        System.out.println("------------------End of Test---------------------------");

    }
    //6. Print the names of the object whose gender = female
    @Test
    public void test006(){
        List<HashMap<String,?>> status = response.extract().path("findAll{it.gender=='female'}.name");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("status  : " + status);
        System.out.println("------------------End of Test---------------------------");

    }
    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007(){
        List<HashMap<String,?>> status = response.extract().path("findAll{it.status=='inactive'}.email");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("status  : " + status);
        System.out.println("------------------End of Test---------------------------");

    }
    //8. Get the ids of the object where gender = male
    @Test
    public void test008(){
        List<String> id = response.extract().path("findAll{it.gender=='male'}.id");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all ids  : " + id);
        System.out.println("------------------End of Test---------------------------");


    }
    //9. Get all the status
    @Test
    public void test009(){
        List<String> status = response.extract().path("status");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all status  : " + status);
        System.out.println("------------------End of Test---------------------------");


    }
    //10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test010(){
        List<HashMap<?, ?>> email = response.extract().path("findAll{it.name == 'Aryan Panicker'}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Email of Aryan Panicker is : " + email);
        System.out.println("------------------End of Test---------------------------");

    }
    //11. Get gender of id = 5471
    @Test
    public void test011(){
        List<Integer> gender = response.extract().path("findAll{it.id =5335}.");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all gender  : " + gender);
        System.out.println("------------------End of Test---------------------------");


    }
}
