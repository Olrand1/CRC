package ru.rt.crc.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;

public class HelperBase {

  protected WebDriver webDriver;

  public HelperBase(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public void goTo(String url){
    webDriver.get(url);
  }

  public void checkPage(String url){
    assertEquals(webDriver.getCurrentUrl(), url);
  }

  public void checkSidebarTitle(String title){
    String titleElement = webDriver.findElement(By.xpath("SidebarFormHeader_title__39UKf")).getText();
    assertEquals(titleElement, title);
  }

  public void type(WebElement webElement, String value){
    webElement.clear();
    webElement.sendKeys(value);
  }

  public void type(String placeholder, String value){
    By locator = By.xpath("//label[text()='" + placeholder + "']/preceding-sibling::input");
    webDriver.findElement(locator).click();
    webDriver.findElement(locator).clear();
    webDriver.findElement(locator).sendKeys(value);
  }

  public void select(String placeholder, String value){
    webDriver.findElement(By.xpath("//label[text()='" + placeholder + "']/preceding-sibling::input")).click();
    webDriver.findElement(By.xpath("//*[text()='" + value + "']")).click();
  }

  public void check(String placeholder, String value){
    String currentValue = webDriver.findElement(By.xpath("//label[text()='" + placeholder + "']/preceding-sibling::input")).getCssValue(value);
    assertEquals(currentValue, value);
  }

  public void clickButton(String buttonName){
    webDriver.findElement(By.xpath("//button//*[text()='" + buttonName + "']")).click();
  }

  public void selectCheckbox(String label){
    webDriver.findElement(By.xpath("//span[text()='" + label + "']/preceding-sibling::input")).click();
  }

  public void typeNote(String value) {
    By locator = By.xpath("//label[text()='Примечание']/preceding-sibling::textarea");
    webDriver.findElement(locator).clear();
    webDriver.findElement(locator).sendKeys(value);
  }

  public void typeComment(String value) {
    By locator = By.xpath("//label[text()='Комментарий (необязательно)']/preceding-sibling::textarea");
    webDriver.findElement(locator).clear();
    webDriver.findElement(locator).sendKeys(value);
  }
}
