package tests.DocumentsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.File;

public class InvoiceOfferCreateTests extends TestBase {

  String documentType = "Счет-оферта/счет без договора";
  private File mainFile = new File ("src\\test\\java\\resources\\files\\mainDocument.pdf");

  @Epic(value = "Расходные документы")
  @Feature(value = "Создание счет-оферты. Предмет договора не требует указания адреса")
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
    app.createDocumentPage().fillMaxSum("60000")
            .goToNextStep()
            .sentToAgreement();
  }
}
