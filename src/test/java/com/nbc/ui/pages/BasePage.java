package com.nbc.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.nbc.ui.driverfactory.WebDriverSession;
import com.nbc.ui.services.logger.CustomLogger;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverSession.getCurrentSession();
        PageFactory.initElements(driver, this);
    }
}
