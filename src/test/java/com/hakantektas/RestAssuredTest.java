package com.hakantektas;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;
import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    private static  List<BusyDeviceList> _devices;
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
    public  void getDevice()  {
        RequestSpecification httpRequest = given();
        Response res = httpRequest.auth().oauth2(token).get("https://api.momentumsuite.com/api/devices/GetBusyDevices");
        res.prettyPrint();
        JsonPath jsonPathEvaluator = res.jsonPath();
        List<BusyDeviceList> allId2 = jsonPathEvaluator.getList("result",BusyDeviceList.class);
        _devices=allId2;
        System.out.println("Total Cihaz Sayısı:" + _devices.size());
    }

    public static String changeStatus(String status) {
        if (_devices.size()>0) {
            RequestSpecification httpRequest = given();
            httpRequest.header("Content-Type", "application/json");
            JSONObject params =new JSONObject();
            for (int i=0 ; i <_devices.size() ; i ++) {
                params.put("deviceId", _devices.get(i).id);
                params.put("status", status);
                httpRequest.body(params.toJSONString());
                Response response3 = httpRequest.auth().oauth2(token).post("https://api.momentumsuite.com/api/devices/changeStatus");
                response3.prettyPrint();
            }
        }
        return status;
    }
    @Test(priority=3)
    public void changeStatusOffline() {
        changeStatus("3");
    }
    @Test(priority=4)
    public void changeStatusBusy() {
        changeStatus("2");
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
    @Test(priority=6)
    public void changeStatusOnline()  {
        changeStatus("1");
        loginWithGetBusyDevice();
    }

}


