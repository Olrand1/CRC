package tests;

import com.google.gson.Gson;
import io.qameta.allure.Feature;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.rt.crc.model.LoginData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginTests extends TestBase {

  @DataProvider
  public Object[][] getLoginData() {
    Object[][] loginData = {{"nikitina-ar", "fail_password", "Неверный логин или пароль"}};
    return loginData;
  }

  @Feature(value = "Авторизация")
  @Test(priority = 1, dataProvider = "getLoginData")
  public void invalidPassword(String login, String password, String message) throws InterruptedException {
    app.loginPage.login(login, password);
    Thread.sleep(600);
    app.loginPage.checkMessage(message);
  }

  @Parameters ({"block_user", "password"})
  @Feature(value = "Авторизация")
  @Test(priority = 2)
  public void blockUser(String login, String password) {
    app.loginPage.login(login, password);
    app.loginPage.checkMessage("Пользователь с логином block_user заблокирован");
  }

  @Parameters ({"fail_user", "password"})
  @Feature(value = "Авторизация")
  @Test(priority = 3)
  public void nonExistUser(String login, String password) {
    app.loginPage.login(login, password);
    app.loginPage.checkMessage("Пользователь с логином fail_user не найден");
  }

  @DataProvider
  public Object getLoginData2() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/java/resources/loginData.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      Object loginData = gson.fromJson(json, LoginData.class);
      System.out.println(loginData);
      return loginData;
    }
  }

  @Feature(value = "Авторизация")
  @Test(priority = 4, dataProvider = "getLoginData2")
  public void newSessionInnerUser(String login, String password) throws InterruptedException {
    app.loginPage.login(login, password);
    Thread.sleep(500);
    app.loginPage.checkPage("http://crc-staging.dev.digital.rt.ru/dashboard");
  }

}
