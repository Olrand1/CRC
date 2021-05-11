package appmanager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManger {
  public WebDriver webDriver;
  private final Properties properties;
  private String browser;
  private SessionHelper sessionHelper;

  public ApplicationManger(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    if ("".equals(properties.getProperty("selenium.server"))) {
      if (browser.equals(BrowserType.FIREFOX)) {
        webDriver = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        webDriver = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
        webDriver = new InternetExplorerDriver();
      }
    }
    else {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName(browser);
      capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "win10")));
      webDriver = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
    }
    webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    webDriver.get(properties.getProperty("web.baseUrl"));
    sessionHelper = new SessionHelper(webDriver);
  }

  public void stop() {
    webDriver.quit();
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

}