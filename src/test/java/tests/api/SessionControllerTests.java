package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import ru.rt.crc.api.Authenticate;

public class SessionControllerTests {

  @Tag(name = "API")
  @Test
  public void login() {
    Authenticate.createToken("nikitina-ar", "qwerty");
    int statusCode = Authenticate.getStatus();
    String token = Authenticate.getToken();
    Assert.assertEquals(statusCode, 200);
    System.out.println("The status code recieved: " + statusCode);
    System.out.println("Token: " + token);
  }

  @Tag(name = "API")
  @Test
  public void wrongUser() {
    Authenticate.createToken("nikitina-ar", "123");
    int statusCode = Authenticate.getStatus();
    String message = Authenticate.getMessage();
    Assert.assertEquals(statusCode, 401);
    Assert.assertEquals(message, "Неверный логин или пароль");
    System.out.println("The status code recieved: " + statusCode);
    System.out.println("Error message is : " + message);
  }

  @Tag(name = "API")
  @Test
  public void blockedUser() {
    Authenticate.createToken("block_user", "123");
    int statusCode = Authenticate.getStatus();
    String message = Authenticate.getMessage();
    Assert.assertEquals(statusCode, 403);
    Assert.assertEquals(message, "Пользователь с логином " +  "block_user" +  " заблокирован");
    System.out.println("The status code recieved: " + statusCode);
    System.out.println("Error message is : " + message);
  }

  @Tag(name = "API")
  @Test
  public void unExistUser() {
    Authenticate.createToken("fail_user", "123");
    int statusCode = Authenticate.getStatus();
    String message = Authenticate.getMessage();
    Assert.assertEquals(statusCode, 500);
    Assert.assertEquals(message, "Пользователь с логином " +  "fail_user" +  " не найден");
    System.out.println("The status code recieved: " + statusCode);
    System.out.println("Error message is : " + message);
  }

}
