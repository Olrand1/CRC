package tests;

import appmanager.ApplicationManger;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManger app
          = new ApplicationManger(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    Thread.sleep(1000);
  }

  @BeforeMethod(alwaysRun = true)
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + "with parameters" + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p) {
    logger.info("Stop test " + m.getName() + "with parameters" + Arrays.asList(p));
  }

  @AfterSuite(alwaysRun = true)
  public void downUp() {
    app.stop();
  }

}
