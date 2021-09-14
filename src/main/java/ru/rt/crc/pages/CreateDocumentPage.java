package ru.rt.crc.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rt.crc.appmanager.HelperBase;
import ru.rt.crc.model.Address;

public class CreateDocumentPage extends HelperBase {

  public CreateDocumentPage(WebDriver webDriver) {
    super(webDriver);
  }

  protected final String  createMenuButton = "Создать";

  @FindBy (xpath = "//*[text()='Документ']")
  WebElement createDocumentButton;
  @FindBy(xpath = "//div[@class=\'CreateDocumentSidebar_addFile__idhu3\']/span")
  WebElement addFile;
  @FindBy (xpath = "//input[@type=\"file\"]")
  WebElement addFileElement;

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
  protected final String contractTypeLabel = "Вид договора";
  //Виды договора
  protected final String expenditureTypeOfContract = "Расходный";
  protected final String profitableTypeOfContract = "Доходный";
  protected final String subjectDocLabel = "Предмет договора";
  protected final String subjectSpecLabel = "Конкретизация предмета";
  // Адрес
  protected final String locationTypeLabel = "Укажите тип населенного пункта";
  protected final String locationLabel = "Населённый пункт";
  protected final String addressTypeLabel = "Тип адреса";
  protected final String addressLabel = "Адрес";
  protected final String rentAreaLabel = "Арендуемая площадь, м²";

  // Шаг Контрагент
  protected final String contractorLabel = "Контрагент";
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

  public void fillCommonExpenditureContractData(String department, String subject){
    select(departmentLabel, department);
    select(contractTypeLabel, expenditureTypeOfContract);
    select(subjectDocLabel, subject);
  }

  public void selectContractor(String contractorName){
    select(contractorLabel, contractorName);
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
