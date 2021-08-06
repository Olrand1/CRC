package pages;

import appmanager.HelperBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class ContractorPage extends HelperBase  {

  public ContractorPage(WebDriver webDriver) {
    super(webDriver);
  }

  String URL =  "http://crc-staging.dev.digital.rt.ru/contractors/contractor_card/209";

  @FindBy(className = "ContractorCardSidebar_title__1PHAR")
  WebElement fullNameContractorElement;
  @FindBy(className = "ContractorCardSidebar_createdDate__30sFB")
  WebElement dateCreateElement;
  @FindBy(xpath = "//*[contains(text(),'Краткое наименование')]/following::div[1]")
  WebElement shortNameContractorElement;
  @FindBy(xpath = "//*[contains(text(),'Категория')]/following::div[1]")
  WebElement categoryElement;
  @FindBy(xpath = "//*[contains(text(),'Организационно-правовая форма')]/following::div[1]")
  WebElement OPFElement;
  @FindBy(xpath = "//*[contains(text(),'ИНН')]/following::div[1]")
  WebElement innElement;
  @FindBy(xpath = "//*[contains(text(),'ОГРН')]/following::div[1]")
  WebElement OgrnElement;
  @FindBy(xpath = "//*[contains(text(),'КПП')]/following::div[1]")
  WebElement kppElement;
  @FindBy(xpath = "//*[contains(text(),'ОГРНИП')]/following::div[1]")
  WebElement OgrnipElement;
  @FindBy(xpath = "//*[contains(text(),'Юридический адрес')]/following::div[1]")
  WebElement addressElement;
  @FindBy(xpath = "//*[contains(text(),'Ответственный от РТК ИТ')]/following::div[1]")
  WebElement responsibleRTKElement;
  @FindBy(xpath = "//label[text()='Примечание']/preceding-sibling::textarea")
  WebElement noteElement;
  @FindBy(className = "ContractorCardSidebar_contactTitle__26hK6")
  WebElement mainContactTitleElement;
  @FindBy(xpath = "//*[contains(text(),'ФИО')]/following::div[1]")
  WebElement nameContact;
  @FindBy(xpath = "//*[contains(text(),'Телефон')]/following::div[1]")
  WebElement phoneContact;
  @FindBy(xpath = "//*[contains(text(),'Почта')]/following::div[1]")
  WebElement emailContact;
  @FindBy(xpath = "//button//*[text()='Закрыть']")
  WebElement closeButton;
  @FindBy(xpath = "//button//*[text()='Редактировать']")
  WebElement editButton;

  public ContractorPage openPage(){
    goTo(URL);
    return this;
  }

  public ContractorPage checkTitle(String contractorFullName, String contractorDateCreate){
    assertEquals(fullNameContractorElement.getText(), contractorFullName);
    assertEquals(dateCreateElement.getText(), contractorDateCreate);
    return this;
  }

  public ContractorPage checkShortNameContractor(String contractorShortName){
    assertEquals(shortNameContractorElement.getText(), contractorShortName);
    return this;
  }

  public ContractorPage checkCategory(String contractorCategory){
    assertEquals(categoryElement.getText(), contractorCategory);
    return this;
  }

  public ContractorPage checkOPF(String opf){
    assertEquals(OPFElement.getText(), opf);
    return this;
  }

  public ContractorPage checkInn(String inn){
    assertEquals(innElement.getText(), inn);
    return this;
  }

  public ContractorPage checkOgrn(String ogrn){
    assertEquals(OgrnElement.getText(), ogrn);
    return this;
  }

  public ContractorPage checkKpp (String kpp){
    assertEquals(kppElement.getText(), kpp);
    return this;
  }

  public ContractorPage checkOgrnip (String ogrnip){
    assertEquals(OgrnipElement.getText(), ogrnip);
    return this;
  }

  public ContractorPage checkAddress(String address){
    assertEquals(addressElement.getText(), address);
    return this;
  }

  public ContractorPage checkResponsibleRTK (String responsibleRTK){
    assertEquals(responsibleRTKElement.getText(), responsibleRTK);
    return this;
  }

  public ContractorPage checkNote (String note){
    assertEquals(noteElement.getText(), note);
    return this;
  }

  public ContractorPage checkContact (String name, String phone, String email){
    assertEquals(mainContactTitleElement.getText(), "Основное контактное лицо");
    assertEquals(nameContact.getText(), name);
    assertEquals(phoneContact.getText(), phone);
    assertEquals(emailContact.getText(), email);
    return this;
  }

  public ContractorPage editContractor (){
    editButton.click();
    return this;
  }

  public ContractorPage closePage(){
    closeButton.click();
    return this;
  }

}
