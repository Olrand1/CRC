package tests.DocumentsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import tests.TestBase;

public class ExpenditureContractCreateTests extends TestBase {

  String documentType = "Договор";

  @Epic(value = "Расходные документы")
  @Feature(value = "Создание расходного договора. Предмет договора не требует указания адреса")
  @Test
  public void createContractWithoutAddress() throws InterruptedException {
    app.loginPage().login("nikitina-ar", "qwerty");
    Thread.sleep(6000);
    app.createDocumentPage().openCreateContractPage()
            .addFile(documentType)
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillDepartment("Региональный центр развития информационных систем (г. Пермь) РИЗП-0333")
            .fillSubjectDoc("Канцелярские товары")
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().selectContractor("Anderson Group")
            .goToNextStep();
    Thread.sleep(1200);
    app.createDocumentPage().fillMaxSum("60000")
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
    Thread.sleep(9000);
    app.createDocumentPage().openCreateContractPage()
            .addFile(documentType)
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillDepartment("Финансово-экономический блок РИЗП-0131")
            .fillSubjectDoc("Аренда прочих основных средств")
            .fillAddress("Город", "г. Пермь")
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().selectContractor("Asroeria")
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillMaxSum("60000")
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
            .addFile(documentType)
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
