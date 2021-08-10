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

  public void checkPage(String url){
    assertEquals(webDriver.getCurrentUrl(), url);
  }

  public void goTo(String url){
    webDriver.get(url);
  }

  public void type(WebElement webElement, String value){
    webElement.clear();
    webElement.sendKeys(value);
  }

  public void type(String placeholder, String value){
    webDriver.findElement(By.xpath("//label[text()='" + placeholder + "']/preceding-sibling::input")).click();
    webDriver.findElement(By.xpath("//label[text()='" + placeholder + "']/preceding-sibling::input")).clear();
    webDriver.findElement(By.xpath("//label[text()='" + placeholder + "']/preceding-sibling::input")).sendKeys(value);
  }

  public void select(String placeholder, String value){
    webDriver.findElement(By.xpath("//label[text()='" + placeholder + "']/preceding-sibling::input")).click();
    webDriver.findElement(By.xpath("//*[text()='" + value + "']")).click();
  }

  public void clickButton(String buttonName){
    webDriver.findElement(By.xpath("//button//*[text()='" + buttonName + "']")).click();
  }

  public void typeNote(String value) {
    webDriver.findElement(By.xpath("//label[text()='Примечание']/preceding-sibling::textarea")).clear();
    webDriver.findElement(By.xpath("//label[text()='Примечание']/preceding-sibling::textarea")).sendKeys(value);
  }
}
