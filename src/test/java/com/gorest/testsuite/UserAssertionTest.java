package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://gorest.co.in/public/v2";
        //RestAssured.port = 3030;
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Verify the if the total record is 20
    @Test
    public void test001() {
        //response.body("id", equalTo(10));
        response.body("total.size().toString()", equalTo("10"));


    }
    // 2. Verify the if the name of id = 5344 is equal to ”Amish Mehrotra I”
        @Test
        public void test002() {
        response.body("[4].name", equalTo("Amish Mehrotra I"));



        }
    // 3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void test003() {
        response.body("[1].name", equalTo("Rep. Baalagopaal Kaul"));


    }

    // 4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. BodhanGuha, Karthik Dubashi IV)
    @Test
    public void test004() {
       // response.body(".name", hasItems("Sen. Menaka Devar","Jyotsana Shah","Esha Pothuvaal"));
        //response.body("name", hasItems("Rameshwar Varman","Raj Patil","Aashritha Bhattathiri"));
        response.body("name",hasItems("Chitraksh Devar","Aanjaneya Banerjee","Sen. Ghanaanand Bhat"));

    }
    //5. Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005() {
        response.body("[2].id", equalTo(5346));

    }
    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test006() {
        response.body("[7].status", equalTo("active"));



    }
    //7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test007() {
        response.body("[7].gender", equalTo("male"));

        
    }
}