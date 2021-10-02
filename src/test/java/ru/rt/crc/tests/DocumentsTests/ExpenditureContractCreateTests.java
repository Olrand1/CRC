package ru.rt.crc.tests.DocumentsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ru.rt.crc.tests.TestBase;

import java.io.File;

public class ExpenditureContractCreateTests extends TestBase {

  private String documentType = "Договор";
  private String additionalDocument = "Прочее";
  private File mainFile = new File ("src\\test\\java\\resources\\files\\mainDocument.pdf");
  private File additionalFile = new File ("src\\test\\java\\resources\\files\\additionalDocument.doc");


  @Epic(value = "Расходные документы")
  @Feature(value = "Создание расходного договора. Предмет договора не требует указания адреса")
  @Test
  public void createContractWithoutAddress() throws InterruptedException {
    app.loginPage().login("nikitina-ar", "qwerty");
    Thread.sleep(6000);
    app.createDocumentPage().openCreateContractPage()
            .addFile(documentType, mainFile)
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillDepartment("Региональный центр развития информационных систем (г. Пермь) РИЗП-0333")
            .fillSubjectDoc("Канцелярские товары")
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().selectContractor("Anderson Group")
            .goToNextStep();
    Thread.sleep(1200);
    app.createDocumentPage().fillMaxSum("50000")
            .goToNextStep()
            .sentToAgreement();
  }

  @Test(dependsOnMethods = "createContractWithoutAddress")
  public void createTaskForPaperAgreement() throws InterruptedException {
    Thread.sleep(3000);
    app.createTaskPage().selectRoute("Согласование договоров");
    app.createTaskPage().selectSigning("Бумажное");
    app.createTaskPage().sendTasksToAgreement();
  }

  @Epic(value = "Расходные документы")
  @Feature(value = "Создание расходного договора. Предмет договора требует указания адреса")
  @Test
  public void createContractWithAddress() throws InterruptedException {
    app.loginPage().login("nikitina-ar", "qwerty");
    Thread.sleep(9000);
    app.createDocumentPage().openCreateContractPage()
            .addFile(documentType, mainFile)
            .addFile(additionalDocument, additionalFile)
            .goToNextStep();
    Thread.sleep(2000);
    app.createDocumentPage().fillDatesOfDocument(1, 28)
            .fillSignDate(2)
            .fillDocNumber("1111")
            .checkResponsible("Никитина Аделия")
            .isFramedTrue()
            .fillDepartment("Финансово-экономический блок РИЗП-0131")
            .fillSubjectDoc("Аренда прочих основных средств")
            .fillAddress("Город", "г. Пермь")
            .goToNextStep();
    Thread.sleep(9000);
    app.createDocumentPage().selectContractor("Asroeria")
            .addContact("Тестов", "79523386625" , "test@test.ru")
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillMaxSum("60000")
            .selectPiuItem("E10402")
            .selectDdsItem("P101")
            .fillSecuritySum("1000")
            .fillMonthSum("1000")
            .goToNextStep()
            .sentToAgreement();
  }

  @Test(dependsOnMethods = "createContractWithAddress")
  public void createTaskForAgreementByCEO() throws InterruptedException {
    Thread.sleep(3000);
    app.createTaskPage().selectRoute("Согласование договоров");
    app.createTaskPage().selectSigning("Электронное");
    app.createTaskPage().selectSignatory("Генеральный директор");
    app.createTaskPage().sendTasksToAgreement();
  }

  @Epic(value = "Расходные документы")
  @Feature(value = "Создание расходного договора. Предмет договора требует указания адреса")
  @Test
  public void createRentContract() throws InterruptedException {
    Thread.sleep(9000);
    app.createDocumentPage().openCreateContractPage()
            .addFile(documentType, mainFile)
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillDepartment("Финансово-экономический блок РИЗП-0131")
            .fillSubjectDoc("Аренда прочих основных средств")
            .fillAddress("Город", "г. Пермь", "Улица", "Пушкина 80", "80.5")
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().selectContractor("Asroeria")
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillMaxSum("60000")
            .goToNextStep()
            .sentToAgreement();
  }

  @Test(dependsOnMethods = "createRentContract")
  public void createTaskForAgreementByCFO() throws InterruptedException {
    Thread.sleep(3000);
    app.createTaskPage().selectRoute("Согласование договоров");
    app.createTaskPage().selectSigning("Электронное");
    app.createTaskPage().selectSignatory("Финансовый директор");
    app.createTaskPage().sendTasksToAgreement();
  }

}
