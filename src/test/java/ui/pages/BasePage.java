package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui.driverfactory.WebDriverSession;
import ui.services.logger.CustomLogger;

public class BasePage {
    public static final CustomLogger LOG = new CustomLogger();

    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverSession.getCurrentSession();
        PageFactory.initElements(driver, this);
    }
}
