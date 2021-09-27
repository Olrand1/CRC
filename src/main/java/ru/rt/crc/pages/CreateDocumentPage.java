package ru.rt.crc.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.rt.crc.appmanager.HelperBase;

public class CreateDocumentPage extends HelperBase {

  public CreateDocumentPage(WebDriver webDriver) {
    super(webDriver);
  }
  
  @FindBy (xpath = "//*[text()='Документ']")
  WebElement createDocumentButton;
  @FindBy(xpath = "//div[@class='CreateDocumentFiles_addFile__ae-pW']/span")
  WebElement addFile;
  @FindBy (xpath = "//input[@type=\"file\"]")
  WebElement addFileElement;

  protected final String  createMenuButton = "Создать";
  protected final String addFileButton = "Добавить";
  protected final String nextPageButton = "Далее";
  protected final String sentToAgreementButton = "Отправить на согласование";
  protected final String typeDocumentLabel = "Тип документа";

  // Типы документов
  protected final String typeExpenditureContract = "Договор";

  // Шаг с общими данными
  protected final String isFramedLabel = "Рамочный";
  protected final String eventEndLabel = "Неизвестна дата окончания действия";
  protected final String departmentLabel = "Департамент";
  protected final String subjectDocLabel = "Предмет договора";
  protected final String subjectSpecLabel = "Конкретизация предмета";
  // Адрес
  protected final String locationTypeLabel = "Укажите тип населенного пункта";
  protected final String locationLabel = "Населённый пункт";
  protected final String addressTypeLabel = "Тип адреса";
  protected final String addressLabel = "Адрес";
  protected final String rentAreaLabel = "Арендуемая площадь, м²";

  // Шаг Контрагент
  @FindBy (xpath = "//div[@id='root']/div[3]/div[3]/form/div/div[2]/div/div/div/div/div/div/div/div")
  WebElement contractorInput;
  protected final String contactNameOfContractorLabel = "ФИО";
  protected final String contactEmailOfContractorLabel = "Email";
  protected final String contactPhoneOfContractorLabel = "Телефон";

  // Шаг Финансы
  protected final String rateNdsLabel = "Ставка НДС";
  protected final String currency = "Валюта";
  protected final String maxSumLabel = "Предельная сумма по договору без НДС";
  protected final String maxSumNdsLabel = "Предельная сумма по договору с НДС";
  protected final String sumLabel = "Сумма без НДС";
  protected final String sumNdsLabel = "Сумма с НДС";
  protected final String piuItems = "Статья ПиУ";
  protected final String ddsItems = "Статья ДДС";
  protected final String cfoLabel = "ЦФО";
  protected final String mvzLabel = "МВЗ";
  protected final String bpLabel = "БП";
  protected final String securitySumLabel = "Сумма обеспечительного платежа без НДС";
  protected final String securitySumNdsLabel = "Сумма обеспечительного платежа с НДС";
  protected final String monthSumLabel = "Сумма ежемесячного платежа без НДС";
  protected final String monthSumNdsLabel = "Сумма ежемесячного платежа с НДС";

  @Step("Переход в карточку создания документа")
  public CreateDocumentPage openCreateContractPage() {
    clickButton(createMenuButton);
    createDocumentButton.click();
    return this;
  }

  @Step("Добавление основного файла")
  public void selectContractFile(){
    String filePath = "C:\\Users\\1283181\\Documents\\Работа\\Шаблоны документов\\Чек.jpg";
    addFile.click();
    select(typeDocumentLabel, typeExpenditureContract);
    addFileElement.sendKeys(filePath);
    clickButton(addFileButton);
  }

  @Step("Переход на следующий шаг")
  public void goToNextStep(){
    clickButton(nextPageButton);
  }

  @Step("Добавление основной информации по договору")
  public void fillCommonExpenditureContractData(String department, String subject){
    select(departmentLabel, department);
    select(subjectDocLabel, subject);
  }

  @Step("Выбор контрагента")
  public void selectContractor(String contractorName){
    contractorInput.click();
    webDriver.findElement(By.id("react-select-2-option-1")).click();
    //webDriver.findElement(By.xpath("xpath=//*/text()[normalize-space(.)='" + contractorName + "']/parent::*")).click();
  }

  public void fillMaxSum(String sum){
    type(maxSumLabel, sum);
  }

  public void sentToAgreement(){
    clickButton(sentToAgreementButton);
  }

  public void fillAddress(String locationType, String location){
    select(locationTypeLabel, locationType);
    type(locationLabel, location);
  }

  public void fillAddress(String locationType, String location, String addressType, String address){
    select(locationTypeLabel, locationType);
    type(locationLabel, location);
    select(addressTypeLabel, addressType);
    type(addressLabel, address);
  }

  public void fillAddress(String locationType, String location, String addressType, String address, String rentArea){
    select(locationTypeLabel, locationType);
    type(locationLabel, location);
    select(addressTypeLabel, addressType);
    type(addressLabel, address);
    type(rentAreaLabel, rentArea);
  }
}
