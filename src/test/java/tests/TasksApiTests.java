package tests;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TasksApiTests {

    @Test(priority = 2)
    public void getMyTasks(){
      given().
              contentType("application/json").
              cookie("CRC_AUTH", "f947a29d-2a47-4f52-a16b-bddbcaa89239").
              body("{\"page\":0,\"statuses\":[\"NEW\"]}").
      when().
              post("http://crc-staging.dev.digital.rt.ru/api/process/tasks").
      then().
              statusCode(200).and().body("page", is(0));
    }

}
