package tests;

import org.testng.annotations.Test;

public class ContractorEditTests extends TestBase {

  @Test
  public void editYurContractors() throws InterruptedException {
    app.contractorPage()      .openPage()
                              .editContractor();
    app.createContractorPage().fillFullNameContractor("Тест")
                              .selectYurCategory()
                              .fillYurInformation("1234657899", "1234567890123", "123456789","г. Пермь 80");
    app.createContractorPage().fillContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().fillNote("Примечание")
                              .submitCreateContractor()
                              .checkCreateContractorMessage();
  }

}
