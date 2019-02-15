package com.nbc.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nbc.ui.pages.FilmsPage;
import com.nbc.ui.services.waitservice.WaitService;

public class StarWarsFilmsTest extends BaseTest {
    @Test
    public void selectMovieTest() {
        LOG.step("");
        FilmsPage filmsPage = new FilmsPage();
        filmsPage.getFilmsButton().click();

        LOG.step("");
        WaitService.waitUntilElementIsDisplayed(filmsPage.getFilmSelector());

        String movieName = "THE PHANTOM MENACE";
        filmsPage.selectMovie(movieName);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(filmsPage.getFilmNameLabel().getText().contains(movieName));
    }
}
