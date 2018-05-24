package com.jsystems.api;

import com.jsystems.api.models.Person;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest {

    @Test
    @DisplayName("First api rest test")
    public void apiFirstTest(){

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
    public void apiSecondTest(){

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
    public void firstMappedObjectTest(){
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

                Person person = jsonPath.getObject("",Person.class);
                System.out.println(person);

                assertTrue(person.name.equals("Piotr"));
                assertTrue(person.surname.equals("Kowalski"));

    }
}
