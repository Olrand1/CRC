package ru.rt.crc.pages;

import org.openqa.selenium.WebDriver;
import ru.rt.crc.appmanager.HelperBase;

public class CreateTaskPage extends HelperBase {

  public CreateTaskPage(WebDriver webDriver) {
    super(webDriver);
  }

  protected final String initiatorLabel = "Инициатор";
  protected final String routeLabel = "Маршрут согласования";
  protected final String signingLabel = "Подписание";
  protected final String signatoryLabel = "Подписант";
  protected final String sendButton = "Отправить";
  protected final String cancelButton = "Отменить";

  public void checkInitiator(String initiator) {
    check(initiatorLabel, initiator);
  }

  public CreateTaskPage fillInitiator(String initiator) {
    select(initiatorLabel, initiator);
    check(initiatorLabel, initiator);
    return this;
  }

  public CreateTaskPage selectRoute(String route) {
    select(routeLabel, route);
    return this;
  }

  public CreateTaskPage selectSigning(String signingType) {
    select(signingLabel, signingType);
    return this;
  }

  public CreateTaskPage selectSignatory(String signatory) {
    select(signatoryLabel, signatory);
    return this;
  }

  public CreateTaskPage sendTasksToAgreement() {
    clickButton(sendButton);
    return this;
  }

  public CreateTaskPage cancelCreate() {
    clickButton(cancelButton);
    return this;
  }

}
