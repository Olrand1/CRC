package pages;

import appmanager.ApplicationManger;
import appmanager.HelperBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractorsPage extends HelperBase {

  @FindBy(xpath = "//div[@id='root']/div/div[3]/div/div/div")
  WebElement titleContractorsPage;
  @FindBy(xpath = "//input[@value='']")
  WebElement nameFilter;

  public ContractorsPage(WebDriver webDriver) {
    super(webDriver);
  }

  public ContractorsPage checkTittle() {
    return this;
  }

  public ContractorsPage checkNameFilter(String fullNameOfContractors) {
    nameFilter.sendKeys(fullNameOfContractors);
    return this;
  }

}


