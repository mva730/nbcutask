package com.nbc.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.nbc.ui.driverfactory.WebDriverSession;

import java.util.List;

public class VideoPage extends BasePage {

    private static final String RESULTS_XPATH = "//li[@class='video video-content result']//h3";

    @FindBy(xpath = "//li//a[contains(@class, 'section-link video-content')]")
    private WebElement videoButton;

    @FindBy(xpath = "//input[@placeholder='Search Videos']")
    private WebElement searchVideoInput;

    @FindBy(xpath = "//input[@class='large button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='totals']//h2//span")
    private WebElement resultsLabel;

    @FindBy(xpath = "//div[@class='suggestionNoResults']//h2//span")
    private WebElement noResultsLabel;

    private List<WebElement> results;

    public WebElement getSearchVideoInput() {
        return searchVideoInput;
    }

    public WebElement getVideoButton() {
        return videoButton;
    }

    public void setVideoButton(WebElement videoButton) {
        this.videoButton = videoButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getResultsLabel() {
        return resultsLabel;
    }

    public WebElement getNoResultsLabel() {
        return noResultsLabel;
    }

    public List<WebElement> getResults() {
        return WebDriverSession.getCurrentSession().findElements(By.xpath(RESULTS_XPATH));
    }

    public void setResults(List<WebElement> results) {
        this.results = results;
    }

    public VideoPage search(String videoName) {
        searchVideoInput.clear();
        searchVideoInput.sendKeys(videoName);
        searchButton.click();
        return this;
    }
}
