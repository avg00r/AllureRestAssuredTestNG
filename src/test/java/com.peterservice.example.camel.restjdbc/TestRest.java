package com.peterservice.example.camel.restjdbc;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.peterservice.example.camel.restjdbc.HeaderMovingProcessor.*;

public class TestRest {

    private String baseURI;
    private String TEST_USER_ID = "1";
    private String TEST_USER_FIRST_NAME = "Ivan";
    private String TEST_USER_LAST_NAME = "Ivanov";

    @BeforeTest
    private void setUp() {
         baseURI="http://localhost:28080/rs/users/";
    }

    @Test
    public void testGetUsers(){
        RestAssured.
                given().baseUri(baseURI).
                when().get().
                then().extract().response().prettyPrint();
    }

    /**
     * Test the Create operation in CRUD.
     * Test inserts the User into database.
     */
    @Test
    public void testCreateUser(){
        RestAssured.
                given().
                    baseUri(baseURI).
                    header(FIRST_NAME, TEST_USER_FIRST_NAME).
                    header(LAST_NAME, TEST_USER_LAST_NAME).
                    header("Content-Type", "application/json").
                when().post("/").
                then().assertThat().statusCode(200).
                extract().response().prettyPrint()
                ;//.and().
    }

    @Test
    public void testRetrieveUser(){
        RestAssured.
                given().
                baseUri(baseURI).
                //header(USER_ID, "1").
                        header(FIRST_NAME, "Test First Name").
                header(LAST_NAME, "Test Last Name").
                header("Content-Type", "application/json").
                when().post("/").
                then().assertThat().statusCode(200);//.and().
    }

    @Test
    public void testUpdateUser(){
        RestAssured.
                given().
                baseUri(baseURI).
                //header(USER_ID, "1").
                        header(FIRST_NAME, "Test First Name").
                header(LAST_NAME, "Test Last Name").
                header("Content-Type", "application/json").
                when().post("/").
                then().assertThat().statusCode(200);//.and().
    }

    @Test
    public void testDeleteUser() {
        RestAssured.
                given().
                    baseUri(baseURI+TEST_USER_ID).
                    header("CamelHttpMethod", "DELETE").
                    header("userId", "1").
                when().delete().
                then().extract().response().prettyPrint();//.assertThat().statusCode(200);
    }

    @Test
    private void deleteTestUser() {
        TEST_USER_ID = "9";
        deleteUserByID(Integer.parseInt(TEST_USER_ID));
    }

    private void deleteUserByID(Integer UserID) {
        RestAssured.
                given().
                baseUri(baseURI+UserID).
                header("CamelHttpMethod", "DELETE").
                when().delete().
                then().extract().response().prettyPrint();
    }
}
