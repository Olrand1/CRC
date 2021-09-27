package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  @Parameters ({"correct_login", "fail_password"})
  @Feature(value = "Авторизация")
  @Test(priority = 1)
  public void invalidPassword(String login, String password) throws InterruptedException {
    app.loginPage.login(login, password);
    Thread.sleep(600);
    app.loginPage.checkMessage("Неверный логин или пароль");
  }

  @Parameters ({"block_user", "correct_password"})
  @Feature(value = "Авторизация")
  @Test(priority = 2)
  public void blockUser(String login, String password) {
    app.loginPage.login(login, password);
    app.loginPage.checkMessage("Пользователь с логином block_user заблокирован");
  }

  @Parameters ({"fail_user", "correct_password"})
  @Feature(value = "Авторизация")
  @Test(priority = 3)
  public void nonExistUser(String login, String password) {
    app.loginPage.login(login, password);
    app.loginPage.checkMessage("Пользователь с логином fail_user не найден");
  }

  @Parameters ({"correct_login", "correct_password"})
  @Feature(value = "Авторизация")
  @Test(priority = 4)
  public void newSessionInnerUser(String login, String password) throws InterruptedException {
    app.loginPage.login(login, password);
    Thread.sleep(500);
    app.loginPage.checkPage("http://crc-staging.dev.digital.rt.ru/dashboard");
  }

}
