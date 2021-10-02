package tests.DocumentsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import tests.TestBase;

import java.io.File;

public class CorporateCard extends TestBase {

  String documentType = "Корпоративная карта";
  private File mainFile = new File ("src\\test\\java\\resources\\files\\mainDocument.pdf");

  @Epic(value = "Расходные документы")
  @Feature(value = "Создание корпоративной карты")
  @Test
  public void createCorporateCard() throws InterruptedException {
    app.loginPage().login("nikitina-ar", "qwerty");
    Thread.sleep(6000);
    app.createDocumentPage().openCreateContractPage()
            .addFile(documentType, mainFile)
            .goToNextStep();
    Thread.sleep(6000);
    app.createDocumentPage().fillDocNumber("111")
            .selectContractor("1111111111")
            .goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().goToNextStep();
    Thread.sleep(900);
    app.createDocumentPage().createDocument();
  }

}
