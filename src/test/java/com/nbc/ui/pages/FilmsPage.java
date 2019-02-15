package com.nbc.ui.pages;

import com.nbc.ui.services.waitservice.WaitService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilmsPage extends BasePage {

    @FindBy(xpath = "//li//a[contains(@class, 'section-link films-content')]")
    private WebElement filmsButton;

    @FindBy(xpath = "//div[@class='module_header has-list has-dropdown']")
    private WebElement filmSelector;

    @FindBy(xpath = "//label[contains(@class,'module_title selected_movie')]")
    private WebElement filmNameLabel;

    @FindBy(xpath = "//div[@class='desc']")
    private WebElement filmDescription;

    @FindBy(xpath = "//ul[@class='drop-container']//li//span")
    private List<WebElement> films;

    public WebElement getFilmDescription() {
        return filmDescription;
    }

    public WebElement getFilmsButton() {
        return filmsButton;
    }

    public WebElement getFilmSelector() {
        return filmSelector;
    }

    public WebElement getFilmNameLabel() {
        return filmNameLabel;
    }

    public void selectMovie(String movieName) {
        filmSelector.click();
        WaitService.waitUntilElementIsDisplayed(films.get(films.size() - 1));
        films.stream().filter(el -> el.getText().contains(movieName)).findAny().get().click();
    }
}
