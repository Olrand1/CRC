package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {

  protected WebDriver webDriver;

  public HelperBase(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void click(By locator) {
    webDriver.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = webDriver.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        webDriver.findElement(locator).clear();
        webDriver.findElement(locator).sendKeys(text);
      }
    }
  }

}
