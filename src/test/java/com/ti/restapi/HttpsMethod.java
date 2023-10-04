package com.ti.restapi;

import com.ti.dao.UserGoRoot;
import static com.ti.tests.Base.inputemail;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.given;


public class HttpsMethod {

    private static final String BASE_URL = "https://automationexercise.com/api/";

    public static UserGoRoot usersgo= new UserGoRoot();


//    String res;
    JsonPath js;

    JsonPath jsn;

    ObjectMapper objectMapper= new ObjectMapper() ;





    public String getUserDetailByEmail() {

        String res = given().contentType(ContentType.HTML)
                .queryParam("email", inputemail)
                .get(BASE_URL+"getUserDetailByEmail").then().noRootPath().extract().asString();
    return res;
    }


   public  void givenDeserializing()
            throws JsonProcessingException {
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

         usersgo = objectMapper.readValue(getUserDetailByEmail()  , UserGoRoot.class);
//        System.out.println(usersgo.users.firstName);
    }

     public void removehttpObject()
    {
        usersgo.users=null;

    }

}
