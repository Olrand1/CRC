package tests;

import org.testng.annotations.Test;

public class ContractorCreationTests extends TestBase {

  @Test
  public void createYurContractors() throws InterruptedException {
    Thread.sleep(3000);
    app.getSessionHelper().login("nikitina-ar", "qwerty");
    Thread.sleep(3000);
    app.createContractorPage().openCreateContractPage()
            .fillFullNameContractor("Тест")
            .fillShortNameContractor("Тест")
            .selectYurCategory()
            .fillYurInformation("1234657899", "1234567890123", "123456789", "г. Пермь 80");
    app.createContractorPage().fillYurContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().fillNote("Примечание")
            .submitCreateContractor()
            .checkCreateContractorMessage();
  }

  @Test
  public void createIPContractors() throws InterruptedException {
    Thread.sleep(3000);
    app.createContractorPage().openCreateContractPage()
            .fillFullNameContractor("Тест")
            .fillShortNameContractor("Тест")
            .selectIPCategory()
            .fillInn("123465789912")
            .fillOgrnip("1234657899")
            .fillNote("Примечание");
    app.createContractorPage().fillIPContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().submitCreateContractor()
            .checkCreateContractorMessage();
  }

  @Test
  public void createPHContractors() throws InterruptedException {
    Thread.sleep(3000);
    app.createContractorPage().openCreateContractPage()
            .fillFullNameContractor("Тест")
            .fillShortNameContractor("Тест")
            .selectPHCategory()
            .fillInn("1234657899")
            .fillNote("Примечание");
    app.createContractorPage().fillPHContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().submitCreateContractor()
            .checkCreateContractorMessage();
  }

}
