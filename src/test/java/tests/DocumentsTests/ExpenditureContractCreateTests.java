package tests.DocumentsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import tests.TestBase;

public class ExpenditureContractCreateTests extends TestBase {

  @Epic(value = "Расходные документы")
  @Feature(value = "Создание расходного договора. Предмет договора не требует указания адреса")
  @Test
  public void createContractWithoutAddress() throws InterruptedException {
    app.loginPage().login("nikitina-ar", "qwerty");
    Thread.sleep(6000);
    app.createDocumentPage().openCreateContractPage();
    app.createDocumentPage().selectContractFile();
    app.createDocumentPage().goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillCommonExpenditureContractData("Региональный центр развития информационных систем (г. Пермь) РИЗП-0333", "Канцелярские товары");
    app.createDocumentPage().goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().selectContractor("Anderson Group");
    app.createDocumentPage().goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().fillMaxSum("60000");
    app.createDocumentPage().goToNextStep();
    app.createDocumentPage().sentToAgreement();
  }

  @Test(dependsOnMethods = "createContractWithoutAddress")
  public void createTaskForAgreement() throws InterruptedException {
    Thread.sleep(3000);
    app.createTaskPage().selectRoute("Согласование договоров");
    app.createTaskPage().selectSigning("Бумажное");
    app.createTaskPage().sendTasksToAgreement();
  }

}
