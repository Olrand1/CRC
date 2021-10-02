package ru.rt.crc.tests.api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.rt.crc.api.Authenticate;

import static com.jayway.restassured.RestAssured.given;


public class TasksApiTests extends Authenticate {

  @Test
  public void MyOpenTask() {
    createToken("nikitina-ar", "qwerty");
    getToken();
    RequestSpecification request = given();
    request.contentType(ContentType.JSON);
    request.cookie("CRC_AUTH", token);
    request.body("{\"page\":0,\"statuses\":[\"NEW\"]}");

    Response response = request.post(URL + TASKS);
    int statusCode = response.statusCode();
    System.out.println(statusCode);
    String taskTitle = response.jsonPath().get("list[0].title");
    String taskInitiator = response.jsonPath().get("list[0].initiator");
    String taskStatus = response.jsonPath().get("list[0].statusTitle");
    String task = taskTitle + " " + taskInitiator;
    System.out.println(taskTitle);
    System.out.println(taskInitiator);
    System.out.println(taskStatus);
    System.out.println("Полное имя: " + task);

  }

}
