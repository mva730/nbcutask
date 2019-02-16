package com.nbc.api.apiobjects;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class SwapiAPIObject {
    private static final String SWAPI_BASE_URL = "http://swapi.co/api/planets/";

    public Response findAll(){
        return RestAssured.get(SWAPI_BASE_URL);
    }

    public Response findById(Integer id){
        return RestAssured.get(SWAPI_BASE_URL + id);
    }
}
