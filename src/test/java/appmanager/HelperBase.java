package appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class HelperBase {

  protected WebDriver webDriver;
  private boolean acceptNextAlert = true;

  public HelperBase(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = webDriver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

}
