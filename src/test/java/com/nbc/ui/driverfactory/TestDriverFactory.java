package com.nbc.ui.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.nbc.configuration.ConfigurationReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestDriverFactory {

    public static WebDriver createDriver() {

        WebDriver driver = null;
        switch (ConfigurationReader.get().driver().toLowerCase()) {
            case "chrome":
                driver = getChromeDriver();
                break;

            case "firefox":
                driver = getFirefoxDriver();
                break;

            default:
                break;
        }

        driver.manage().timeouts().implicitlyWait(ConfigurationReader.get().implicitWait(), TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver getChromeDriver() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }

    public static URL configureUrl() {
        try {
            return new URL(ConfigurationReader.get().host());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}