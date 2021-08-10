package ru.rt.crc.api;

import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Authenticate extends EndPoints{

  public static int statusCode;
  public static String token;
  public static String message;


  public static void createToken(String login, String pass) {
    JsonObject requestBody = new JsonObject();
    requestBody.addProperty("login", login);
    requestBody.addProperty("password", pass);

    RequestSpecification request = RestAssured.given();
    request.contentType(ContentType.JSON);
    request.body(requestBody.toString());

    Response response = request.post( URL + LOGIN);
    statusCode = response.getStatusCode();
    token = response.getCookie("CRC_AUTH");
    if (statusCode != 200) {
      message = response.jsonPath().get("message");
    }
  }

  public static String getToken() {
    return token;
  }

  public static int getStatus() {
    return statusCode;
  }

  public static String getMessage() {
    return message;
  }

}




