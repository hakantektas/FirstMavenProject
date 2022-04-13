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
    public static  List<BusyDeviceList> _devices;
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
   /* @Test(priority=2)
    public void changeStatusOnline() {

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params =new JSONObject();

        int [] _devices = {9914,9916,9917,9918,9919,125,5306};

        params.put("deviceId","145");
        params.put("status","1");

        httpRequest.body(params.toJSONString());
        Response response = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
        response.prettyPrint();

    }
*/
    public static String changeStatus(String status) {
        int[] _devices = {10, 56, 59, 88, 89, 103, 104, 118, 125, 134, 145, 150, 153, 154, 155, 156, 165, 173, 174, 5306, 5435, 5560, 5561, 5562, 5565, 5568, 5575, 9899, 9900, 9904, 9905, 9908, 9914, 9926, 9933, 9939, 9941, 9942, 9945, 9948, 9949, 9952, 9953, 9954, 9957, 9959, 9960, 9961, 9963, 9964, 9966, 9967, 9976, 9978, 9982,125,5306,9914,9916,9917,9918,9919};

        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        JSONObject params = new JSONObject();
        if (_devices.length> 0) {
            for (int i = 0; i < _devices.length - 1; i++) {
                int sayi = _devices[i];

                    params.put("deviceId", sayi);
                    params.put("status", status);
                    httpRequest.body(params.toJSONString());
                    Response response3 = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
                    response3.prettyPrint();
            }
        }
            return status;

    }
    @Test(priority=2)
    public void changeStatusOffline() {
        changeStatus("3");
    }
    @Test(priority=3)
    public void changeStatusBusy() {

        changeStatus("2");

    }
    @Test(priority=4)
    public void changeStatusOnline() {

        changeStatus("1");

    }
    @Test(priority=5)
    public  void loginWithGetBusyDevice()  {
        RequestSpecification httpRequest = given();
        Response res = httpRequest.auth().oauth2(token).get("https://api.momentumsuite.com/api/devices/GetBusyDevices");
        res.prettyPrint();
        JsonPath jsonPathEvaluator = res.jsonPath();
        List<BusyDeviceList> allId = jsonPathEvaluator.getList("result",BusyDeviceList.class);
        _devices=allId;
        System.out.println("Total Busyde Kalan Cihaz:" + _devices.size());
    }
    /*@Test(priority=5)
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

    }*/
}

