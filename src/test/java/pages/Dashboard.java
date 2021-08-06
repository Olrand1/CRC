package pages;

import appmanager.HelperBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends HelperBase {

  public Dashboard(WebDriver webDriver) {
    super(webDriver);
  }
  
  @FindBy(xpath = "//img[@alt='contractors']")
  WebElement contractorPage;

}
