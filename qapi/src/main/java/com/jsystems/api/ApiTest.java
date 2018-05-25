package com.jsystems.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsystems.api.models.Person;
import com.jsystems.api.models.TestuserGeneric;
import com.jsystems.api.models.UserDevice;
import com.jsystems.api.models.errorModels.ErrorResponse;
import com.jsystems.api.response.TestResponse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest {

    @Test
    @DisplayName("First api rest test")
    public void apiFirstTest() {

        RestAssured.given()
                .when()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));


    }

    @Test
    @DisplayName("Second api rest test")
    public void apiSecondTest() {

        RestAssured.given()
                .when()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("[0].imie", is("Piotr"))
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"))
                .body("[0].device[0].device.model[0].produce", equalTo("dell"));

    }

    @Test
    @DisplayName("First test with mapped object")
    public void firstMappedObjectTest() {
        JsonPath jsonPath = RestAssured.given()
                .spec(Specyficator.requestSpecyfication)
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        Person person = jsonPath.getObject("", Person.class);
        System.out.println(person);

        assertTrue(person.name.equals("Piotr"));
        assertTrue(person.surname.equals("Kowalski"));

    }

    @Test
    @DisplayName("Second test with mapped object")
    public void secondMappedObjectTest() {
        JsonPath jsonPath = RestAssured.given()
                .spec(Specyficator.requestSpecyfication)
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        jsonPath.prettyPrint();
        List<UserDevice> userDeviceList = jsonPath.getList("",UserDevice.class);
        assertTrue(userDeviceList.get(0).imie.equals("Piotr"));
        assertTrue(userDeviceList.get(0).nazwisko.equals("Kowalski"));
        assertTrue(userDeviceList.get(0).device.get(0).type.equals("computer"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.get(0).produce.equals("dell"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.get(0).screenSize == 17);
    }

    @Test
    @DisplayName("Maped to Response")

   public void responseTest() {
        Response response = RestAssured
                .given()
                .spec(Specyficator.requestSpecyfication)
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

               Person person = response
                .then()
                .extract()
                .body()
                .as(Person.class);

               assertTrue(person.name.equals("Piotr"));
               assertTrue(person.surname.equals("Kowalski"));
               assertTrue(response.contentType().equals("application/json"));


    }
    @Test
    @DisplayName("Maped list to Response")

    public void responseToList() {
        Response response = RestAssured
                .given()
                .spec(Specyficator.requestSpecyfication)
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

        UserDevice[] userDevices = response
                .then()
                .extract()
                .body()
                .as(UserDevice[].class);

        List<UserDevice> userDeviceList = Arrays.asList(userDevices);
        assertTrue(userDeviceList.get(0).imie.equals("Piotr"));
        assertTrue(userDeviceList.get(0).nazwisko.equals("Kowalski"));
        assertTrue(userDeviceList.get(0).device.get(0).type.equals("computer"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.get(0).produce.equals("dell"));
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.get(0).screenSize == 17);
        assertTrue(userDeviceList.get(0).device.get(0).deviceModel.size() == 2);
        assertTrue(response.contentType().equals("application/json"));


    }

    @Test
    @DisplayName("Test for error")
    public void errorTest (){
        Response response = TestResponse.responseWithlistByUrl("5a690b452e000054007a73cd");

        ErrorResponse errorResponse = response
        .then()
        .extract()
        .body()
        .as(ErrorResponse.class);

        assertTrue(errorResponse.Error.errorCode == 400);
        assertTrue(errorResponse.Error.message.equals("your email is invalid"));

    }


    @Test
    @DisplayName("Post test")
    public void postTest () {

        Person person = new Person ("Rafal", "Wrobel");

        Response response = TestResponse.responseWithlistByUrl("5b05bf3f3200007100ebfa04, person");

        String responsePost = Arrays.asList(response
                .then()
                .extract()
                .body()
                .as(String[].class)).toString();

        assertTrue(responsePost.equals("[]"));
        assertTrue(response.getStatusCode() == 201);
        assertTrue(response.getHeader("content-type").equals("application/json"));


    }

    @Test
    @DisplayName("Test of generic type")
    public void genericTypeTest() throws IOException {

        Response response = TestResponse.responseWithlistByUrl("5b05bf3f3200007100ebfa04");

        ObjectMapper objectMapper = new ObjectMapper();

        TestuserGeneric<Integer> testuserGeneric = objectMapper.readValue(
                response
                        .then()
                        .extract()
                        .body()
                        .asInputStream(), new TypeReference<TestuserGeneric<Integer>>(){}
                        );


                    System.out.println(testuserGeneric.toString());
                    assertTrue(testuserGeneric.id == 1);



    }

    @Test
    @DisplayName("Test of generic type String")
    public void genericTypeTestWiyhString() throws IOException {

        Response response = TestResponse.responseWithlistByUrl("5b05c83e3200009700ebfa2b");

        ObjectMapper objectMapper = new ObjectMapper();

        TestuserGeneric<String> testuserGeneric = objectMapper.readValue(
                response
                        .then()
                        .extract()
                        .body()
                        .asInputStream(), new TypeReference<TestuserGeneric<String>>(){}
        );


        System.out.println(testuserGeneric.toString());
        assertTrue(testuserGeneric.id.equals("1a"));



    }

    @Test
    @DisplayName("GET: /api/Books - Tests of Books")

    public void fakeBookTest() {


        Response response = TestResponse.responseFakerestApiBook("api/Booka/{id}, 1");

        Fakebook book = response
                .then()
                .extract()
                .body()
                .as(FakeBook.class);


    }
}


