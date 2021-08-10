package tests.ContractorsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import tests.TestBase;

public class ContractorViewTests extends TestBase {

  @Epic(value = "Контрагенты")
  @Feature(value = "Просмотр контрагента")
  @Test(priority = 8)
  public void viewYurContractors() throws InterruptedException {
    int contractorId = 209;
    app.contractorPage().openPage(contractorId);
    Thread.sleep(3000);
    app.contractorPage().checkTitle("Тест", "04.08.2021")
                        .checkShortNameContractor("Tecт")
                        .checkCategory("ЮЛ")
                        .checkOPF("ООО")
                        .checkInn("1234657899")
                        .checkOgrn("1234567890123")
                        .checkKpp("123456789")
                        .checkAddress("г. Пермь 80")
                        .checkResponsibleRTK("Никитина Аделия Робертовна")
                        .checkNote("Примечание")
                        .checkContact("Тестов Тест Тестович", "+7 795 233-86-62", "test@test.test");
    app.contractorPage().closePage();
  }

  @Epic(value = "Контрагенты")
  @Feature(value = "Просмотр контрагента")
  @Test(priority = 8)
  public void viewIPContractors() throws InterruptedException {
    int contractorId = 500;
    app.contractorPage().openPage(contractorId);
    Thread.sleep(3000);
    app.contractorPage().checkTitle("Тест", "04.08.2021")
            .checkShortNameContractor("Tecт")
            .checkCategory("ЮЛ")
            .checkOPF("ООО")
            .checkInn("1234657899")
            .checkOgrn("1234567890123")
            .checkKpp("123456789")
            .checkAddress("г. Пермь 80")
            .checkResponsibleRTK("Никитина Аделия Робертовна")
            .checkNote("Примечание")
            .checkContact("Тестов Тест Тестович", "+7 795 233-86-62", "test@test.test");
    app.contractorPage().closePage();
  }

}
