package ru.rt.crc.pages;

import io.qameta.allure.Step;
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

  @Step("Проверка инициатора")
  public void checkInitiator(String initiator) {
    check(initiatorLabel, initiator);
  }

  @Step("Заполнение инициатора")
  public CreateTaskPage fillInitiator(String initiator) {
    select(initiatorLabel, initiator);
    check(initiatorLabel, initiator);
    return this;
  }

  @Step("Выбор маршрута")
  public CreateTaskPage selectRoute(String route) {
    select(routeLabel, route);
    return this;
  }

  @Step("Выбор подписания")
  public CreateTaskPage selectSigning(String signingType) {
    select(signingLabel, signingType);
    return this;
  }

  @Step("Выбор подписанта")
  public CreateTaskPage selectSignatory(String signatory) {
    select(signatoryLabel, signatory);
    return this;
  }

  @Step("Отправка на сонласование")
  public CreateTaskPage sendTasksToAgreement() {
    clickButton(sendButton);
    return this;
  }

  @Step("Отмена создания задачи по кнопке")
  public CreateTaskPage cancelCreate() {
    clickButton(cancelButton);
    return this;
  }

}
