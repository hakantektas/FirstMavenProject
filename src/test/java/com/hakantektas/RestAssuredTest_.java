package com.hakantektas;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestAssuredTest_ {

    private static String token;
    public static  List<BusyDeviceList> _devices;
    @Test(priority=1)
    public void bearerTokenAuthenticationLogin(){
        RequestSpecification request = given();
        data test = new data();
        request.header("Content-Type","application/json");
        Response responseFromGenerateToken=  request.body(test.postData).post("https://api.momentumsuite.com/api/auth/");
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
        int[] _devices = {6000, 6001,6002, 6003, 6004, 6005, 6006, 6012, 6013, 6014, 6016, 6017, 6018, 6019, 6020, 6021, 6022, 7000, 7001, 7002, 7003, 7004, 7005, 7006, 7007, 7008, 7009, 7010, 7011, 7012, 7013, 7014,7015, 7016, 7017, 7018, 7019, 7020, 7021, 7022, 7023, 7024, 7025, 7026, 7027, 7028, 7029, 7030, 7031, 7032, 7033, 7034, 7035,7036, 7037, 7038, 7039,7040,7041,7042,7043};

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

