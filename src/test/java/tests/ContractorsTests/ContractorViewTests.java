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

  @Epic(value = "Контрагенты")
  @Feature(value = "Просмотр контрагента")
  @Test(priority = 8)
  public void viewPhContractors() throws InterruptedException {
    int contractorId = 306;
    app.contractorPage().openPage(contractorId);
    Thread.sleep(3000);
    app.contractorPage().checkTitle("hello","21.09.2021")
            .checkShortNameContractor("hi")
            .checkCategory("ФЛ")
            .checkInn("567475685485")
            .checkResponsibleRTK("Архипов Владислав Дмитриевич")
            .checkNote("").checkContact("hello guy","","l@maal.ru");
    app.contractorPage().closePage();
  }

  @Epic(value = "Контрагенты")
  @Feature(value = "Просмотр контрагента")
  @Test(priority = 8)
  public void viewSEContractors() throws InterruptedException {
    int contractorId = 287;
    app.contractorPage().openPage(contractorId);
    Thread.sleep(3000);
    app.contractorPage().checkTitle("arthas","11.09.2021")
            .checkShortNameContractor("best")
            .checkCategory("Самозанятый")
            .checkInn("141241212242")
            .checkResponsibleRTK("Антонов Андрей Игоревич")
            .checkNote("").checkContact("1241","+7 124 124-12-42","24@mail.ru");
    app.contractorPage().closePage();
  }
}
