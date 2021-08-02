package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HelperBase {

  @FindBy(xpath = "//input[@name='']")
  WebElement loginElement;
  @FindBy(xpath = "//div[@id='root']/div/div/div[2]/div/form/div[4]/div/input")
  WebElement passwordElement;
  @FindBy(xpath = "//div[@id='root']/div/div/div[2]/div/form/button")
  WebElement loginButtonElement;
  @FindBy(xpath = "//div[@id='root']/div/div[2]/div[3]/div/button")
  WebElement profileElement;
  @FindBy(xpath = "//div[@id='root']/div/div[3]/div[5]/div")
  WebElement logoutElement;

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void login(String username, String password) {
    loginElement.sendKeys(username);
    passwordElement.sendKeys(password);
    loginButtonElement.click();
  }

  public void logout() {
    profileElement.click();
    logoutElement.click();
  }

}
