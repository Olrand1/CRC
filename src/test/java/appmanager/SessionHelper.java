package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver webDriver) {
    super(webDriver);
  }

  public void login(String username, String password) {
    type(By.name("email"), username);
    type(By.name("password"), password);
    click((By.xpath("//div[@id='root']/div/div/div/div[2]/div/form/button")));
  }

  public void logout() {
    click(By.linkText("Logout"));
  }

}
