package ru.rt.crc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rt.crc.appmanager.HelperBase;

import static org.testng.AssertJUnit.assertEquals;

public class DocumentPage extends HelperBase {

    public DocumentPage(WebDriver webDriver){super(webDriver);}

    String URL = "http://crc-staging.dev.digital.rt.ru/documents/document_card/";

    @FindBy(className = "")
    WebElement fullNameDocumentElement;
    @FindBy(className = "")
    WebElement dateCreateElement;
    @FindBy(xpath = "")
    WebElement element;
}
