package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestUtils {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
        response = given()
                .when()
                .get("")
                .then().statusCode(200); //method type of this is validatable response
    }

    @Test
    public void verifyUserCreatedSuccessfully() {

        UserPojo userPojo = new UserPojo();

        userPojo.setName("Harry Potter");
        userPojo.setEmail("HPotter" + getRandomValue() + "@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 8d9f4a0df6907aecfdc0b585fdfbac824fbbbf6ed9bed0bb01f6c15cd9ef79ea")// add the token here from postman
                .when()
                .body(userPojo)
                .post();//change here
        response.prettyPrint();
        response.then().log().all().statusCode(201);

    }

    @Test
    public void verifyUserUpdateSuccessfully() {
        UserPojo userPojo = new UserPojo();

        userPojo.setName("Harry Potter1");
        userPojo.setEmail("HPotter" + getRandomValue() + "@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");

        Response response = given()

                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 8d9f4a0df6907aecfdc0b585fdfbac824fbbbf6ed9bed0bb01f6c15cd9ef79ea")
                .body(userPojo)
                .pathParam("id", "11690") //passing parameter to .get()
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void verifyUserDeleteSuccessfully() {


        Response response = given()

                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 8d9f4a0df6907aecfdc0b585fdfbac824fbbbf6ed9bed0bb01f6c15cd9ef79ea")

                .pathParam("id", "11690") //passing parameter to .get()
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }


}