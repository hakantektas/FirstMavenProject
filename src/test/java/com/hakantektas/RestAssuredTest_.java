package com.hakantektas;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RestAssuredTest_ {

    private static String token;
    @Test(priority=1)
    public void bearerTokenAuthenticationLogin(){
        RequestSpecification request = given();
        String postData = "{\n" +
                "  \"username\": \"hakan.tektas@mobven.com\",\n" +
                "  \"password\": \"571632gS.\"\n" +
                "}";
        request.header("Content-Type","application/json");
        Response responseFromGenerateToken=  request.body(postData).post("https://api.momentumsuite.com/api/auth/");
        responseFromGenerateToken.prettyPrint();
        String jsonString = responseFromGenerateToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("result.accessToken");
        token= tokenGenerated;
    }
    @Test(priority=2)
    public void changeStatusOnline() {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params =new JSONObject();
        int [] myArray = {9914,9916,9917,9918,9919,125,5306};

        params.put("deviceId","145");
        params.put("status","1");

        httpRequest.body(params.toJSONString());
        Response response = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
        response.prettyPrint();

    }
    @Test(priority=3)
    public void changeStatusOnline2() {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params =new JSONObject();
        int [] myArray = {9914,9916,9917,9918,9919,125,5306};

        params.put("deviceId","155");
        params.put("status","1");

        httpRequest.body(params.toJSONString());
        Response response = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
        response.prettyPrint();

    }
    @Test(priority=4)
    public void changeStatusOnline3() {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params =new JSONObject();
        int [] myArray = {9914,9916,9917,9918,9919,125,5306};

        params.put("deviceId","165");
        params.put("status","1");

        httpRequest.body(params.toJSONString());
        Response response = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
        response.prettyPrint();

    }
    @Test(priority=5)
    public void changeStatusOnline4() {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params =new JSONObject();
        int [] myArray = {9914,9916,9917,9918,9919,125,5306};

        params.put("deviceId","174");
        params.put("status","1");

        httpRequest.body(params.toJSONString());
        Response response = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
        response.prettyPrint();

    }
    @Test(priority=6)
    public void changeStatusOnline5() {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params =new JSONObject();
        int [] myArray = {9914,9916,9917,9918,9919,125,5306};

        params.put("deviceId","5565");
        params.put("status","1");

        httpRequest.body(params.toJSONString());
        Response response = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
        response.prettyPrint();

    }
    @Test(priority=7)
    public void changeStatusOnline6() {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params =new JSONObject();
        int [] myArray = {9914,9916,9917,9918,9919,125,5306};

        params.put("deviceId","9939");
        params.put("status","1");

        httpRequest.body(params.toJSONString());
        Response response = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
        response.prettyPrint();

    }
    @Test(priority=8)
    public void changeStatusOnline7() {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params =new JSONObject();
        int [] myArray = {9914,9916,9917,9918,9919,125,5306};

        params.put("deviceId","9950");
        params.put("status","1");

        httpRequest.body(params.toJSONString());
        Response response = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
        response.prettyPrint();

    }
}

