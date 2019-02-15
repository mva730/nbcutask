package com.nbc.ui.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.nbc.ui.driverfactory.TestDriverFactory;
import com.nbc.ui.driverfactory.WebDriverSession;
import com.nbc.ui.services.logger.CustomLogger;

public class BaseTest {
    public static final CustomLogger LOG = CustomLogger.getLogger();
    protected static WebDriver driver;

    @BeforeSuite
    public static void start() {
        LOG.step("Before suite method started");
        WebDriverSession.setCurrentSession(TestDriverFactory.createDriver());
        driver = WebDriverSession.getCurrentSession();
        driver.get(TestDriverFactory.configureUrl().toString());
    }

    @AfterSuite
    public void closeBrowser() {
        WebDriverSession.getCurrentSession().quit();
        LOG.step("After method completed");
    }
}
