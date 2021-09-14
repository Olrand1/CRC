package ru.rt.crc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rt.crc.appmanager.HelperBase;
import ru.rt.crc.model.Contact;

import static org.testng.AssertJUnit.assertEquals;

public class CreateContractorPage<contractorName> extends HelperBase {

  public CreateContractorPage(WebDriver webDriver) {
    super(webDriver);
  }

  @FindBy(xpath = "//div[@id='root']/div/div[3]/form/div/div/div/div")
  WebElement pageTitle;
  @FindBy(xpath = "//button//*[text()='Создать']")
  WebElement createMenuButton;
  @FindBy (xpath = "//div[@id='root']/div/div[2]/div[2]/div/div/div[3]")
  WebElement createContractorButton;
  @FindBy (xpath = "//label[text()='Наименование полное']/preceding-sibling::input")
  WebElement fullNameContractorElement;
  @FindBy (xpath = "//label[text()='Наименование краткое (необязательно)']/preceding-sibling::input")
  WebElement shortNameContractorElement;
  @FindBy (xpath = "//label[text()='Категория']/preceding-sibling::input")
  WebElement categoryList;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[3]/div[2]/div/div/div/ul/li")
  WebElement YurCategory;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[3]/div[2]/div/div/div/ul/li[2]")
  WebElement IPCategory;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[3]/div[2]/div/div/div/ul/li[3]")
  WebElement PHCategory;
  @FindBy (xpath = "//label[text()='ИНН']/preceding-sibling::input")
  WebElement innElement;
  @FindBy (xpath = "//label[text()='Юридический адрес']/preceding-sibling::input")
  WebElement addressElement;
  @FindBy (xpath = "//label[text()='ОГРН']/preceding-sibling::input")
  WebElement OgrnElement;
  @FindBy (xpath = "//label[text()='ОГРНИП']/preceding-sibling::input")
  WebElement OgrnipElement;
  @FindBy (xpath = "//label[text()='КПП']/preceding-sibling::input")
  WebElement kppElement;
  @FindBy (xpath = "//div[@id='root']/div/div[3]/form/div/div[2]/div/div[5]/div/div/div/input")
  WebElement OPFElement;
  @FindBy (xpath = "//*[@id='root']/div/div[3]/form/div/div[2]/div/div[5]/div[2]/div/div/div/ul/li[1]")
  WebElement OOOElement;
  @FindBy (xpath = "//label[text()='Примечание']/preceding-sibling::textarea")
  WebElement noteElement;
  @FindBy (xpath = "//*[@id=\"root\"]/div/div[3]/form/div/div[3]/div/button[2]")
  WebElement submitCreateButton;
  @FindBy (xpath = "//label[text()='ФИО']/preceding-sibling::input")
  WebElement nameContact;
  @FindBy (xpath = "//label[text()='Телефон']/preceding-sibling::input")
  WebElement phoneContact;
  @FindBy (xpath = "//label[text()='Email']/preceding-sibling::input")
  WebElement emailContact;
  @FindBy (xpath = "//h4")
  WebElement successMessage;

  public CreateContractorPage checkTitle (){
    assertEquals(pageTitle.getText(),"Создание контрагента");
    return this;
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

  public CreateContractorPage fillNameContractor(String fullNameContractor, String shortNameContractor) {
    fullNameContractorElement.sendKeys(fullNameContractor);
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
    OgrnElement.sendKeys(ogrn);
    return this;
  }

  public CreateContractorPage fillOgrnip(String ogrnip) {
    OgrnipElement.sendKeys(ogrnip);
    return this;
  }

  public CreateContractorPage fillKpp(String kpp) {
    kppElement.sendKeys(kpp);
    return this;
  }

  public CreateContractorPage fillAddress(String address) {
    addressElement.sendKeys(address);
    return this;
  }

  public CreateContractorPage fillNote(String note) {
    noteElement.sendKeys(note);
    return this;
  }
  public void fillContact (String name, String phone, String email){
    type(nameContact, name);
    type(phoneContact, phone);
    type(emailContact, email);
  }
  public void fillContact (String name, String email){
    type(nameContact, name);
    type(emailContact, email);
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
    assertEquals(successMessage.getText(), "Контрагент успешно создан!");
    return this;
  }

  public CreateContractorPage checkEditContractorMessage() {
    assertEquals(successMessage.getText(), "Контрагент успешно сохранен!");
    return this;
  }
}



