package ru.rt.crc.api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.*;

public class Tasks extends Authenticate {

  public static String task;
  public static String taskStatus;
  public Response response;

  public Response doRequest() {
    RequestSpecification request = given();
    request.contentType(ContentType.JSON);
    request.cookie("CRC_AUTH", token);
    request.body("{\"page\":0,\"statuses\":[\"NEW\"]}");

    response = request.post(URL + TASKS);
    return response;
  }

  public String getTaskTitle(){
    doRequest();
    String taskTitle = response.jsonPath().get("list[0].title");
    String taskInitiator = response.jsonPath().get("list[0].initiator");
    task = taskTitle + " " + taskInitiator;
    return task;
  }

  public String getTaskStatus(){
    doRequest();
    taskStatus = response.jsonPath().get("list[0].statusTitle");
    return taskStatus;
  }

 }
