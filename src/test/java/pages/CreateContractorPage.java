package pages;

import appmanager.HelperBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class CreateContractorPage extends HelperBase {

  public CreateContractorPage(WebDriver webDriver) {
    super(webDriver);
  }

  @FindBy(xpath = "//div[@id='root']/div/div[2]/div[2]/div/button/div")
  WebElement createMenuButton;
  @FindBy (xpath = "//div[@id='root']/div/div[2]/div[2]/div/div/div[3]")
  WebElement createContractorButton;
  @FindBy (xpath = "//input[@name='']")
  WebElement fullNameContractorElement;
  @FindBy (xpath = "(//input[@name=''])[2]")
  WebElement shortNameContractorElement;
  @FindBy ( xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[3]/div/div/div/input")
  WebElement categoryList;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[3]/div[2]/div/div/div/ul/li")
  WebElement YurCategory;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[3]/div[2]/div/div/ul/li[2]")
  WebElement IPCategory;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[3]/div[2]/div/div/ul/li[3]")
  WebElement PHCategory;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[4]/div/input")
  WebElement innElement;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[8]/div/input")
  WebElement addressElement;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[6]/div/input")
  WebElement OgrnElement;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[5]/div/input")
  WebElement OgrnipElement;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[7]/div/input")
  WebElement kppElement;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[5]/div/div/div/input")
  WebElement OPFElement;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[5]/div[2]/div/div/ul/li")
  WebElement OOOElement;
  @FindBy (xpath = "//textarea[@name='']")
  WebElement noteElement;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[3]/div/div[2]/div/button/div")
  WebElement submitCreateButton;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[12]/div/div/input")
  WebElement nameYurContact;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[12]/div[2]/div/input")
  WebElement phoneYurContact;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[12]/div[3]/div/input")
  WebElement emailYurContact;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[8]/div/div/input")
  WebElement namePHContact;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[8]/div[2]/div/input")
  WebElement phonePHContact;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[8]/div[3]/div/input")
  WebElement emailPHContact;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[11]/div/div/input")
  WebElement nameIPContact;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[11]/div[2]/div/input")
  WebElement phoneIPContact;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[11]/div[3]/div/input")
  WebElement emailIPContact;

  public void fillYurContact (String name, String phone, String email){
    nameYurContact.sendKeys(name);
    phoneYurContact.sendKeys(phone);
    emailYurContact.sendKeys(email);
  }

  public void fillIPContact (String name, String phone, String email){
    nameIPContact.sendKeys(name);
    phoneIPContact.sendKeys(phone);
    emailIPContact.sendKeys(email);
  }
  public void fillPHContact (String name, String phone, String email){
    namePHContact.sendKeys(name);
    phonePHContact.sendKeys(phone);
    emailPHContact.sendKeys(email);
  }

  public CreateContractorPage openCreateContractPage() {
    createMenuButton.click();
    createContractorButton.click();
    return this;
  }

  public CreateContractorPage fillFullNameContractor(String fullNameContractor) {
    fullNameContractorElement.sendKeys(fullNameContractor);
    return this;
  }

  public CreateContractorPage fillShortNameContractor(String shortNameContractor) {
    shortNameContractorElement.sendKeys(shortNameContractor);
    return this;
  }

  public CreateContractorPage selectYurCategory() {
    categoryList.click();
    YurCategory.click();
    return this;
  }

  public CreateContractorPage selectIPCategory() {
    categoryList.click();
    IPCategory.click();
    return this;
  }

  public CreateContractorPage selectPHCategory() {
    categoryList.click();
    PHCategory.click();
    return this;
  }

  public CreateContractorPage fillInn(String inn) {
    innElement.sendKeys(inn);
    return this;
  }

  public CreateContractorPage selectOPFlikeOOO() {
    OPFElement.click();
    OOOElement.click();
    return this;
  }

  public CreateContractorPage fillOgrn(String ogrn) {
    OgrnElement.click();
    return this;
  }

  public CreateContractorPage fillOgrnip(String ogrn) {
    OgrnipElement.click();
    return this;
  }

  public CreateContractorPage fillKpp(String kpp) {
    kppElement.click();
    return this;
  }

  public CreateContractorPage fillAddress(String address) {
    addressElement.click();
    return this;
  }

  public CreateContractorPage fillNote(String note) {
    noteElement.click();
    return this;
  }

  public CreateContractorPage submitCreateContractor() {
    submitCreateButton.click();
    return this;
  }

  public CreateContractorPage fillYurInformation(String inn, String ogrn, String kpp, String address) {
    fillInn(inn);
    selectOPFlikeOOO();
    fillOgrn(ogrn);
    fillKpp(kpp);
    fillAddress(address);
    return this;
  }

  public CreateContractorPage checkCreateContractorMessage() {
    assertEquals(closeAlertAndGetItsText(), "Контрагент успешно создан!");
    return this;
  }
}

