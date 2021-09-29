package tests.ContractorsTests;

import org.testng.annotations.Test;
import tests.TestBase;

public class ContractorEditTests extends TestBase {

  @Test
  public void editYurContractors() {
    app.contractorPage()      .openPage(209)
                              .editContractor();
    app.createContractorPage().fillFullNameContractor("Тест")
                              .selectYurCategory()
                              .fillYurInformation("1234657899", "1234567890123", "123456789","г. Пермь 80");
    app.createContractorPage().fillContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().fillNote("Примечание")
                              .submitCreateContractor()
                              .checkEditContractorMessage();
  }

  @Test
  public void editPHContractors() {
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

  @Test
  public void editIPContractors() {
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
