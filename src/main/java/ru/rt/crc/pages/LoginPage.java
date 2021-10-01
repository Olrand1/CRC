package ru.rt.crc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rt.crc.appmanager.HelperBase;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends HelperBase {

  @FindBy(xpath = "//label[text()='Логин']/preceding-sibling::input")
  WebElement loginElement;
  @FindBy(xpath = "//label[text()='Пароль']/preceding-sibling::input")
  WebElement passwordElement;
  @FindBy(xpath = "//button/div[text()='Войти']")
  WebElement loginButtonElement;
  @FindBy(className = "FormLogin_errorMessage__3nf_X")
  WebElement errorMessage;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void login(String login, String password) {
    type(loginElement, login);
    type(passwordElement, password);
    loginButtonElement.click();
  }

  public void checkMessage(String message) {
    assertEquals(errorMessage.getText(), message);
  }

}
