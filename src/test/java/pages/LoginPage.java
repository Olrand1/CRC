package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends HelperBase {

  @FindBy(xpath = "//label[text()='Логин']/preceding-sibling::input")
  WebElement loginElement;
  @FindBy(xpath = "//label[text()='Пароль']/preceding-sibling::input")
  WebElement passwordElement;
  @FindBy(xpath = "//button[text()='Войти']")
  WebElement loginButtonElement;
  @FindBy(xpath = "//*[@id=\"root\"]/div[3]/div[1]/div[2]/div/form/div[3]")
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
