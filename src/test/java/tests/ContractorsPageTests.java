package tests;

import org.testng.annotations.Test;

public class ContractorsPageTests extends TestBase{

  @Test
  public void filterContractors() throws InterruptedException {
    Thread.sleep(3000);
    app.getSessionHelper().login("nikitina-ar", "qwerty");
    Thread.sleep(3000);
    app.getNavigationHelper().GoToContactorsPage();
    app.contractorsPage().checkNameFilter("Тест");
  }

}
