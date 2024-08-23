package com.smartwyre.api;

import com.google.gson.reflect.TypeToken;
import com.smartwyre.utils.dto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.mapper.ObjectMapperType.GSON;

public class apiSetUp {
    private static final String BASE_URL = "https://api.restful-api.dev";
    public String postProduct(dto.ProductRequest productRequest) {
        RequestSpecification request = RestAssured.given()
                .baseUri(BASE_URL)
                .basePath("/objects")
                .contentType(ContentType.JSON)
                .body(productRequest, GSON);

        Response postResponse = request.post();
        System.out.println("POST Response:");
        System.out.println(postResponse.asString());

        String objectId = postResponse.jsonPath().getString("id");
        return objectId;
    }

    public dto.ProductResponse getProductById(String id) { // Use String for ID
        RequestSpecification request = RestAssured.given()
                .baseUri(BASE_URL)
                .basePath("/objects")
                .queryParam("id", id);
        Response getResponse = request.get();
        System.out.println("GET Response:");
        System.out.println(getResponse.asString());
        List<dto.ProductResponse> products = getResponse.as(new TypeToken<List<dto.ProductResponse>>() {}.getType(), GSON);
        dto.ProductResponse retrievedProduct = products.get(0);
        return retrievedProduct;
    }

}

