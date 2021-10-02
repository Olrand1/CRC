package ru.rt.crc.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.rt.crc.appmanager.HelperBase;

import java.io.File;

public class CreateDocumentPage extends HelperBase {

  public CreateDocumentPage(WebDriver webDriver) {
    super(webDriver);
  }

  // Общие элементы
  protected final String createMenuButton = "Создать";
  protected final String createDocumentLink = "Документ";
  protected final String nextPageButton = "Далее";
  protected final String sentToAgreementButton = "Отправить на согласование";
  protected final String createDocumentButton = "Создать документ";

  // Шаг добавления файлов
  By addFile = By.xpath("//div[@class='CreateDocumentFiles_addFile__ae-pW']/span");
  By addFileElement = By.xpath("//input[@type=\"file\"]");
  protected final String typeDocumentLabel = "Тип документа";
  protected final String addFileButton = "Добавить";

  // Шаг с общими данными
  protected final String dateStartLabel = "Дата начала действия";
  protected final String dateEndLabel = "Дата окончания действия";
  protected final String isEventEndLabel = "Неизвестна дата окончания действия";
  protected final String eventEndLabel = "Событие окончания действия";
  protected final String dateSignLabel = "Дата подписания";
  protected final String docNumberLabel = "Номер документа";
  protected final String departmentLabel = "Департамент";
  protected final String responsibleLabel = "Ответственный от РТК ИТ";
  protected final String isFramedLabel = "Рамочный";
  protected final String subjectDocLabel = "Предмет договора";
  protected final String subjectSpecLabel = "Конкретизация предмета";
  // Адрес
  protected final String locationTypeLabel = "Укажите тип населенного пункта";
  protected final String locationLabel = "Населённый пункт";
  protected final String addressTypeLabel = "Тип адреса";
  protected final String addressLabel = "Адрес";
  protected final String rentAreaLabel = "Арендуемая площадь, м²";

  // Шаг Контрагент
  protected final String contactNameOfContractorLabel = "ФИО";
  protected final String contactEmailOfContractorLabel = "Email";
  protected final String contactPhoneOfContractorLabel = "Телефон";
  protected final String addNewContactLink = "Добавить контактное лицо";
  protected final String deletedContactLink = "Добавить контактное лицо";

  // Шаг Финансы
  protected final String currencyLabel = "Валюта";
  protected final String rateNdsLabel = "Ставка НДС";
  protected final String maxSumLabel = "Предельная сумма по договору без НДС";
  protected final String maxSumNdsLabel = "Предельная сумма по договору с НДС";
  protected final String sumLabel = "Сумма без НДС";
  protected final String sumNdsLabel = "Сумма с НДС";
  protected final String piuItemsLabel = "Статья ПиУ";
  protected final String ddsItemsLabel = "Статья ДДС";
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
    clickLink(createDocumentLink);
    return this;
  }

  @Step("Добавление файла")
  public CreateDocumentPage addFile(String documentType, File filePath) {
    webDriver.findElement(addFile).click();
    select(typeDocumentLabel, documentType);
    webDriver.findElement(addFileElement).sendKeys(filePath.getAbsolutePath());
    clickButton(addFileButton);
    return this;
  }

  @Step("Переход на следующий шаг")
  public CreateDocumentPage goToNextStep() {
    clickButton(nextPageButton);
    return this;
  }

  @Step("Заполнение сроков документа")
  public CreateDocumentPage fillDatesOfDocument(int dateStart, int dateEnd) {
    fillDate(dateStartLabel, dateStart);
    fillDate(dateEndLabel, dateEnd);
    return this;
  }

  @Step("Заполнение сроков документа")
  public CreateDocumentPage fillDatesOfDocument(int dateStart, String eventEnd) {
    fillDate(dateStartLabel, 1);
    selectCheckbox(isEventEndLabel);
    type(eventEndLabel, eventEnd);
    return this;
  }

  @Step("Заполнение даты подписания документы")
  public CreateDocumentPage fillSignDate(int date) {
    fillDate(dateSignLabel, date);
    return this;
  }

  @Step("Ввод номера документы")
  public CreateDocumentPage fillDocNumber(String docNumber) {
    type(docNumberLabel, docNumber);
    return this;
  }

  @Step("Выбор департамента")
  public CreateDocumentPage fillDepartment(String department) {
    select(departmentLabel, department);
    return this;
  }

  @Step("Проверка ответственного от РТК ИТ")
  public CreateDocumentPage checkResponsible(String responsibleRTK) {
    check(responsibleLabel, responsibleRTK);
    return this;
  }

  @Step("Установка ответственного от РТК ИТ")
  public CreateDocumentPage selectResponsible(String responsibleRTK) {
    select(responsibleLabel, responsibleRTK);
    return this;
  }

  @Step("Установка признака рамочного документа")
  public CreateDocumentPage isFramedTrue() {
    selectCheckbox(isFramedLabel);
    return this;
  }

  @Step("Выбор предмета документа")
  public CreateDocumentPage fillSubjectDoc(String subject) {
    select(subjectDocLabel, subject);
    return this;
  }

  @Step("Выбор предмета документа")
  public CreateDocumentPage fillSubjectDoc(String subject, String subjectSpec) {
    select(subjectDocLabel, subject);
    select(subjectSpecLabel, subjectSpec);
    return this;
  }

  @Step("Ввод адреса")
  public CreateDocumentPage fillAddress(String locationType, String location) {
    select(locationTypeLabel, locationType);
    type(locationLabel, location);
    return this;
  }

  @Step("Ввод адреса")
  public CreateDocumentPage fillAddress(String locationType, String location, String addressType, String address) {
    select(locationTypeLabel, locationType);
    type(locationLabel, location);
    select(addressTypeLabel, addressType);
    type(addressLabel, address);
    return this;
  }

  @Step("Ввод адреса")
  public CreateDocumentPage fillAddress(String locationType, String location, String addressType, String address, String rentArea) {
    select(locationTypeLabel, locationType);
    type(locationLabel, location);
    select(addressTypeLabel, addressType);
    type(addressLabel, address);
    type(rentAreaLabel, rentArea);
    return this;
  }

  @Step("Выбор контрагента")
  public CreateDocumentPage selectContractor(String contractorName) {
    webDriver.findElement(By.xpath("//div[@id='root']/div[3]/div[3]/form/div/div[2]/div/div/div/div/div/div/div/div")).click();
    webDriver.findElement(By.xpath("//*/text()[normalize-space(.)='" + contractorName + "']/parent::*")).click();
    return this;
  }

  @Step("Добавление контакта")
  public CreateDocumentPage editContact(String contactName, String contactPhone, String contactEmail) {
    type(contactNameOfContractorLabel, contactName);
    type(contactEmailOfContractorLabel, contactEmail);
    type(contactPhoneOfContractorLabel, contactPhone);
    return this;
  }

  @Step("Добавление контакта")
  public CreateDocumentPage addContact(String contactName, String contactPhone, String contactEmail) {
    clickLink(addNewContactLink);
    type(contactNameOfContractorLabel, contactName, 2);
    type(contactEmailOfContractorLabel, contactEmail, 2);
    type(contactPhoneOfContractorLabel, contactPhone, 2);
    return this;
  }

  @Step("Добавление контакта")
  public CreateDocumentPage addContact(String contactName, String contactEmail) {
    clickLink(addNewContactLink);
    type(contactNameOfContractorLabel, contactName);
    type(contactEmailOfContractorLabel, contactEmail);
    return this;
  }

  @Step("Добавление контакта")
  public CreateDocumentPage deleteContact() {
    clickLink(deletedContactLink);
    return this;
  }

  @Step("Ввод валюты и ставки НДС")
  public CreateDocumentPage fillNdsAndCurrency(String nds, String currency) {
    select(currencyLabel, currency);
    select(rateNdsLabel, nds);
    return this;
  }

  @Step("Проверка валюты и ставки НДС")
  public CreateDocumentPage checkNdsAndCurrency(String nds, String currency) {
    select(currencyLabel, currency);
    select(rateNdsLabel, nds);
    return this;
  }

  @Step("Ввод предельной суммы по договору без НДС")
  public CreateDocumentPage fillMaxSum(String sum) {
    type(maxSumLabel, sum);
    return this;
  }

  @Step("Ввод предельной суммы по договору с НДС")
  public CreateDocumentPage fillMaxSumNds(String sumNds) {
    type(maxSumNdsLabel, sumNds);
    return this;
  }

  @Step("Ввод суммы по документу без НДС")
  public CreateDocumentPage fillSum(String sum) {
    type(sumLabel, sum);
    return this;
  }

  @Step("Ввод суммы по документу с НДС")
  public CreateDocumentPage fillSumNds(String sumNds) {
    type(sumNdsLabel, sumNds);
    return this;
  }

  @Step("Выбор статьи ПиУ")
  public CreateDocumentPage selectPiuItem(String piuItem) {
    select(piuItemsLabel, piuItem);
    return this;
  }

  @Step("Выбор статьи ДДС")
  public CreateDocumentPage selectDdsItem(String ddsItem) {
    select(ddsItemsLabel, ddsItem);
    return this;
  }

  @Step("Выбор ЦФО")
  public CreateDocumentPage selectCfo(String cfo) {
    select(cfoLabel, cfo);
    return this;
  }

  @Step("Выбор МВЗ")
  public CreateDocumentPage selectMvz(String ddsItem) {
    select(mvzLabel, ddsItem);
    return this;
  }

  @Step("Выбор БП")
  public CreateDocumentPage selectBP(String bp) {
    select(bpLabel, bp);
    return this;
  }

  @Step("Ввод суммы обеспечительного платежа без НДС ")
  public CreateDocumentPage fillSecuritySum(String securitySum) {
    type(securitySumLabel, securitySum);
    return this;
  }

  @Step("Ввод суммы обеспечительного платежа c НДС ")
  public CreateDocumentPage fillSecurityNdsSum(String securityNdsSum) {
    type(securitySumNdsLabel, securityNdsSum);
    return this;
  }

  @Step("Ввод суммы ежемесячного платежа c НДС ")
  public CreateDocumentPage fillMonthSum(String monthSum) {
    type(monthSumLabel, monthSum);
    return this;
  }

  @Step("Ввод суммы ежемесячного платежа c НДС ")
  public CreateDocumentPage fillMonthNdsSum(String monthNdsSum) {
    type(monthSumNdsLabel, monthNdsSum);
    return this;
  }

  @Step("Отправка на согласование")
  public CreateDocumentPage sentToAgreement() {
    clickButton(sentToAgreementButton);
    return this;
  }

  @Step("Нажатие кнопки 'Создать документ'")
  public CreateDocumentPage createDocument() {
    clickButton(createDocumentButton);
    return this;
  }

}
