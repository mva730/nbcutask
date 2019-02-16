package com.nbc.ui.pages;

import com.nbc.ui.driverfactory.WebDriverSession;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverSession.getCurrentSession();
        PageFactory.initElements(driver, this);
    }
}
