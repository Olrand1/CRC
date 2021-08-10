package tests.ContractorsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import tests.TestBase;

public class ContractorCreationTests extends TestBase {

  @Epic(value = "Контрагенты")
  @Feature(value = "Создание контрагента")
  @Test(priority = 5)
  public void createYurContractors() throws InterruptedException {
    app.createContractorPage().openCreateContractPage()
            .checkTitle()
            .fillNameContractor("Тест", "Tecт")
            .selectYurCategory()
            .fillYurInformation("1234657899", "1234567890123", "123456789", "г. Пермь 80");
    app.createContractorPage().fillContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().fillNote("Примечание")
            .submitCreateContractor();
    Thread.sleep(3000);
    app.createContractorPage().checkCreateContractorMessage();
  }

  @Epic(value = "Контрагенты")
  @Feature(value = "Создание контрагента")
  @Test(priority = 6)
  public void createIPContractors() throws InterruptedException {
    Thread.sleep(3000);
    app.createContractorPage().openCreateContractPage()
            .fillFullNameContractor("Тест")
            .selectIPCategory()
            .fillInn("123465789912")
            .fillOgrnip("1234657899")
            .fillNote("Примечание");
    app.createContractorPage().fillContact("Тестов Тест Тестович", "+79523386625", "test@test.test");
    app.createContractorPage().submitCreateContractor();
    Thread.sleep(3000);
    app.createContractorPage().checkCreateContractorMessage();
  }

  @Epic(value = "Контрагенты")
  @Feature(value = "Создание контрагента")
  @Test(priority = 7)
  public void createPHContractors() throws InterruptedException {
    Thread.sleep(3000);
    app.createContractorPage().openCreateContractPage()
            .fillFullNameContractor("Тест")
            .selectPHCategory()
            .fillInn("1234657899")
            .fillNote("Примечание");
    app.createContractorPage().fillContact("Тестов Тест Тестович",  "test@test.test");
    app.createContractorPage().submitCreateContractor();
    Thread.sleep(3000);
    app.createContractorPage().checkCreateContractorMessage();
  }

}
