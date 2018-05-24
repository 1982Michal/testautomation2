package com.jsystems.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specyficator {
    public static RequestSpecification requestSpecyfication = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri("http://www.mocky.io/")
            .setBasePath("v2")
            .build();



}
