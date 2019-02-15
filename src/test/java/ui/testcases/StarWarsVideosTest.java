package ui.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pages.VideoPage;
import ui.services.waitservice.WaitService;

public class StarWarsVideosTest extends BaseTest {

    private VideoPage videoPage;

    @BeforeMethod
    public void setUp() {
        LOG.step("Step 1 - Go to Video Page");
        videoPage = new VideoPage();
        videoPage.getVideoButton().click();
        WaitService.waitUntilElementIsDisplayed(videoPage.getVideoButton());
    }

    @Test(alwaysRun = true)
    public void starWarsVideoPageTest() {
        LOG.step("Step 2 - Verify if we are on the video page");
        Assert.assertEquals(videoPage.getVideoButton().getText(), "VIDEO", "Checking video button label");

        LOG.step("Step 3 - Verify that search field is present");
        Assert.assertTrue(WaitService.isElementPresent(videoPage.getSearchVideoInput()));
    }

    @Test(alwaysRun = true/*, dependsOnMethods = "starWarsVideoPageTest"*/)
    public void positiveSearchTest() {
        LOG.step("Step 2 - Search for 'Star Wars' words");
        String expectedValue = "Star wars";
        videoPage.search(expectedValue);

        LOG.step("Step 3 - Verify search results label text");
        WaitService.waitUntilElementIsDisplayed(videoPage.getResultsLabel());
        Assert.assertTrue(videoPage.getResultsLabel().getText().toLowerCase().contains(expectedValue.toLowerCase()), "Verify results found for " + expectedValue);

        LOG.step("Step 4 - Verify search results list");
        String expectedVideoResult1 = "STAR WARS REBELS: STAND AGAINST THE EMPIRE";
        String expectedVideoResult2 = "STAR WARS: TINY DEATH STAR TRAILER";

        Assert.assertTrue(videoPage.getResults().stream().anyMatch(el -> el.getText().contains(expectedVideoResult1)), "Verify result " + expectedVideoResult1);
        Assert.assertTrue(videoPage.getResults().stream().anyMatch(el -> el.getText().contains(expectedVideoResult2)), "Verify result " + expectedVideoResult2);
    }

    @Test(alwaysRun = true/*, dependsOnMethods = "positiveSearchTest"*/)
    public void negativeSearchTest() {
        LOG.step("Step 2 - Search for incorrect word");
        String expectedValue = "12315468/43515";
        videoPage.search(expectedValue);

        LOG.step("Step 3 - Verify search no results label text");
        WaitService.waitUntilElementIsDisplayed(videoPage.getNoResultsLabel());
        Assert.assertTrue(videoPage.getNoResultsLabel().getText().toLowerCase().contains(expectedValue.toLowerCase()), "Verify no results found for " + expectedValue);

        LOG.step("Step 4 - Verify search results list");
        Assert.assertTrue(videoPage.getResults().isEmpty(), "Verify that results list is empty");
    }
}
