package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class PostsAssertionTest {
    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        // RestAssured.port = 8080;
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "25")
                .get("/posts")
                .then().statusCode(200);

    }


    //    1. Verify the if the total record is 25
    @Test
    public void test001() {
        response.body("total.size().toString()", equalTo("25"));
    }


    //    2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demittocentum.”
    @Test
    public void test002() {
        response.body("[2].title", equalTo("Ad ipsa coruscus ipsam eos demitto centum."));

    }

    //    3. Check the single user_id in the Array list (5522)
    @Test
    public void test003() {
        response.body("[4].user_id", equalTo(5522));

    }


    //    4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test004() {
        response.body("id", hasItems(2693,2674,2714));

    }


    //    5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcarspectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem. Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter. Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco etantiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequuscuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique adflicto. Assentator umquam pel."

    @Test
    public void test005() {
        response.body("[10].body", equalTo("Amicitia aedificium cupiditate. Ubi earum absconditus. Conventus suadeo totus. Despecto suppono suadeo. Adstringo sollicito tener. Tamen valens vulnus. Custodia umquam cuppedia. Campana cura eveniet. Non temptatio officia. Desparatus traho appello. Depulso error id. Vulariter non arbustum. Comedo patria tracto. Hic venustas nihil. Acerbitas rem earum. Admoneo theologus voluptatem. Alioqui tribuo viduo."));
    }
}
