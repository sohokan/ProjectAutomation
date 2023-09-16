package com.ti.restapi;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.gson.GsonBuilder;
import com.ti.dao.Root;
import com.ti.dao.UserGoRest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.mapper.factory.GsonObjectMapperFactory;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;


public class HttpMethodsExample {
    private static final String BASE_URL = "https://automationexercise.com/api/getUserDetailByEmail";


    String res;
    JsonPath js;

    JsonPath jsn;

    ObjectMapper objectMapper= new ObjectMapper() ;


    @Test (priority = 1)
    void getExample() {


         res = given().contentType(ContentType.HTML)
                .queryParam("email", "za_kvirgoe@testdata.com")
                .get(BASE_URL).then().noRootPath().extract().asString();




     System.out.println(res);


    }


    @Test (dependsOnMethods = "getExample")
    void givenJsonString_whenDeserializingWithConvertValueAndTypeReference_thenGetExpectedList()
            throws JsonProcessingException {




        JsonNode linkData = objectMapper.readTree(res);
        ArrayNode linkDataArray = (ArrayNode)linkData.get("user");


//        while(linkDataArray.elements().hasNext()){
//            users.add(objectMapper.readValue(linkDataArray.elements().next().toString(),UserGoRest.class));
//        }

    }

    @Test (priority = 3,enabled = true)

        void getUsers() {
//        users = RestAssured
//                    .given().
//                 contentType(ContentType.JSON)
//                    .when().queryParam("email", "za_kvirgoe@testdata.com")
//                    .get(BASE_URL)
//
//                    .then()
//                    .extract()
//                    .body()
//                    .jsonPath()
//                    .getList("id", UserGoRest.class);
//
//        System.out.println(users.get(0).getName());


    }

    @Test
    public void apiTest(){
//        users = given()
//                .contentType(ContentType.HTML)
//                .when().queryParam("email", "za_kvirgoe@testdata.com")
//                .get(BASE_URL)
//                .then().log().all()
//                .extract().jsonPath().using((GsonObjectMapperFactory) (aClass, s) -> new GsonBuilder().setPrettyPrinting().create())
//                .getList("id", UserGoRest.class);
//        System.out.println(users.size());
    }


    @Test (dependsOnMethods = "getExample")
    void givenDeserializing()
            throws JsonProcessingException {
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

     Root usersgo = objectMapper.readValue(res, Root.class);
        System.out.println(usersgo.users.firstName);
    }



}