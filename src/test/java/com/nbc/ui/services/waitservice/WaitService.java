package com.nbc.ui.services.waitservice;

import com.nbc.configuration.ConfigurationReader;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nbc.ui.driverfactory.WebDriverSession;

public class WaitService {

    public static boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void waitUntilElementIsDisplayed(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(WebDriverSession.getCurrentSession(), ConfigurationReader.get().timeout());
        webDriverWait.until(d -> isElementPresent(element));
    }
}
