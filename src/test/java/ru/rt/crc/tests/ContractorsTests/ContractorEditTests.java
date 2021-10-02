package ru.rt.crc.tests.ContractorsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.rt.crc.tests.TestBase;

public class ContractorEditTests extends TestBase {

  @Parameters ({"yur_contractor_id", "yur_contractor_name", "yur_contractor_inn", "yur_contractor_ogrn", "yur_contractor_kpp", "yur_contractor_address"})
  @Epic(value = "Контрагенты")
  @Feature(value = "Редактирование контрагента")
  @Test
  public void editYurContractor(int id, String fullName, String inn, String ogrn, String kpp, String address) throws InterruptedException {
    app.loginPage.login("nikitina-ar", "qwerty");
    Thread.sleep(600);
    app.contractorPage()      .openPage(id);
    Thread.sleep(6000);

    app.contractorPage()                          .editContractor();
    app.createContractorPage().fillFullNameContractor(fullName)
                              .selectYurCategory()
                              .fillYurInformation(inn, ogrn, kpp,address);
    app.createContractorPage().fillContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().fillNote("Примечание")
                              .submitCreateContractor()
                              .checkEditContractorMessage();
  }

  @Epic(value = "Контрагенты")
  @Feature(value = "Редактирование контрагента")
  @Test
  public void editPHContractor() {
    app.contractorPage()      .openPage(209)
                              .editContractor();
    app.createContractorPage().fillFullNameContractor("Тест")
                              .selectPHCategory()
                              .fillInn("1234657899");
    app.createContractorPage().fillContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().fillNote("Примечание")
                              .submitCreateContractor()
                              .checkEditContractorMessage();
  }

  @Epic(value = "Контрагенты")
  @Feature(value = "Редактирование контрагента")
  @Test
  public void editIPContractor() {
    app.contractorPage()      .openPage(209)
                              .editContractor();
    app.createContractorPage().fillFullNameContractor("Тест")
                              .selectIPCategory()
                              .fillInn("123465789912")
                              .fillOgrnip("1234657899");
    app.createContractorPage().fillContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().fillNote("Примечание")
                              .submitCreateContractor()
                              .checkEditContractorMessage();
  }

  @Test
  public void editSEContractors() {
    app.contractorPage()      .openPage(209)
                              .editContractor();
    app.createContractorPage().fillFullNameContractor("Тест")
                              .selectSECategory()
                              .fillInn("123465789912");
    app.createContractorPage().fillContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().fillNote("Примечание")
                              .submitCreateContractor()
                              .checkEditContractorMessage();
  }


}
