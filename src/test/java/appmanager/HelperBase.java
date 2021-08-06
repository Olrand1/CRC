package appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;

public class HelperBase {

  protected WebDriver webDriver;

  public HelperBase(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void checkPage(String url){
    assertEquals(webDriver.getCurrentUrl(), url);
  }

  public void goTo(String url){
    webDriver.get(url);
  }

  public void type(WebElement webElement, String value){
    webElement.clear();
    webElement.sendKeys(value);
  }

}
