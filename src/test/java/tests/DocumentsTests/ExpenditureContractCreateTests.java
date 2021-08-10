package tests.DocumentsTests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.TestBase;

public class ExpenditureContractCreateTests extends TestBase {

  @Test
  public void createContractWithoutAddress() throws InterruptedException {
    app.loginPage().login("nikitina-ar", "qwerty");
    Thread.sleep(30000);
    app.createDocumentPage().openCreateContractPage();
    app.createDocumentPage().selectContractFile();
    app.createDocumentPage().goToNextStep();
    app.createDocumentPage().fillCommonExpenditureContractData("Региональный центр развития информационных систем (г. Пермь) РИЗП-0333", "Канцелярские товары");
    app.createDocumentPage().goToNextStep();
    app.createDocumentPage().selectContractor("Anderson Group");
    app.createDocumentPage().goToNextStep();
    Thread.sleep(30000);
    app.createDocumentPage().fillMaxSum("60000");
    app.createDocumentPage().goToNextStep();
    //app.createDocumentPage().sentToAgreement();
    Thread.sleep(3000);
  }

}
