package tests.ContractorsTests;

import org.testng.annotations.Test;
import tests.TestBase;

public class ContractorsPageTests extends TestBase {

  @Test
  public void filterContractors() throws InterruptedException {
    Thread.sleep(3000);
    app.loginPage().login("nikitina-ar", "qwerty");
    Thread.sleep(3000);
    app.contractorsPage().goToContactorsPage();
    app.contractorsPage().checkTittle();
    app.contractorsPage().checkNameFilter("Тест");
  }

}
