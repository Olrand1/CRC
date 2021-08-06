package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  @Feature(value = "Авторизация")
  @Test(priority = 1)
  public void invalidPassword() throws InterruptedException {
    app.loginPage.login("nikitina-ar", "fail_password");
    Thread.sleep(300);
    app.loginPage.checkMessage("Неверный логин или пароль");
  }

  @Feature(value = "Авторизация")
  @Test(priority = 2)
  public void blockUser() {
    app.loginPage.login("block_user", "qwerty");
    app.loginPage.checkMessage("Пользователь с логином block_user заблокирован");
  }

  @Feature(value = "Авторизация")
  @Test(priority = 3)
  public void nonExistUser() {
    app.loginPage.login("fail_user", "qwerty");
    app.loginPage.checkMessage("Пользователь с логином fail_user не найден");
  }

  @Feature(value = "Авторизация")
  @Test(priority = 4)
  public void newSessionInnerUser() throws InterruptedException {
    app.loginPage.login("nikitina-ar", "qwerty");
    Thread.sleep(500);
    app.loginPage.checkPage("http://crc-staging.dev.digital.rt.ru/dashboard");

  }

}
