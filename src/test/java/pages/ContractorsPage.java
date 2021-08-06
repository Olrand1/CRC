package pages;

import appmanager.ApplicationManger;
import appmanager.HelperBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class ContractorsPage extends HelperBase {

  @FindBy(xpath = "//img[@alt='contractors']")
  WebElement contractorPage;
  @FindBy(xpath = "//div[@id='root']/div/div[3]/div/div/div")
  WebElement titleContractorsPage;
  @FindBy(xpath = "//input[@value='']")
  WebElement nameFilter;
  @FindBy(xpath = "//div[@id='root']/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div")
  WebElement categoryElement;

  public ContractorsPage(WebDriver webDriver) {
    super(webDriver);
  }

  public ContractorsPage goToContactorsPage(){
    contractorPage.click();
    return this;
  }

  public ContractorsPage checkTittle() {
    assertEquals(titleContractorsPage.getText(), "Контрагенты");
    return this;
  }

  public ContractorsPage checkNameFilter(String contractorsName) {
    nameFilter.sendKeys(contractorsName);
    return this;
  }

}


