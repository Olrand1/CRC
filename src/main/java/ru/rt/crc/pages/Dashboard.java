package ru.rt.crc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rt.crc.api.Tasks;
import ru.rt.crc.appmanager.HelperBase;

import static org.testng.AssertJUnit.assertEquals;

public class Dashboard extends HelperBase {

  public Dashboard(WebDriver webDriver) {
    super(webDriver);
  }
  
  @FindBy(className = "TasksBlock_title__-uDaV")
  WebElement taskUnitTitle;
  @FindBy(xpath = "//button//*[text()='Новая задача']")
  WebElement newTaskButton;
  @FindBy(className = "DocumentsBlock_title__3f6Uu")
  WebElement documentUnitTitle;
  @FindBy(xpath = "//button//*[text()='Новый документ']")
  WebElement newDocumentButton;

}
