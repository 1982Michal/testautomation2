package com.jsystems.api.response;

import com.jsystems.api.Specyficator;
import com.jsystems.api.models.Person;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestResponse {
    public static Response responseWithlist()
    {
        return RestAssured
                .given()
                .spec(Specyficator.requestSpecyfication)
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();
    }

    public static Response responseWithlistByUrl(String url){
        return RestAssured
                .given()
                .spec(Specyficator.requestSpecyfication)
                .when()
                .get(url)
                .andReturn();
    }

    public static Response responsePost(String url, Person body){
        return RestAssured
                .given()
                .spec(Specyficator.requestSpecyfication)
                .when()
                .body(body)
                .get(url)
                .andReturn();
    }

    public static Response responseFakerestApiBook(String url, int id){
        return RestAssured
                .given()
                .spec(Specyficator.requestSpecyficationFaker)
                .when()
                .get(url,id)
                .andReturn();

    }

}


//tutaj logika
