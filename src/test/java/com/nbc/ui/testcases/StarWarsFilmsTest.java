package com.nbc.ui.testcases;

import com.nbc.ui.pages.FilmsPage;
import com.nbc.ui.services.waitservice.WaitService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StarWarsFilmsTest extends BaseTest {

    private static final String DESCRIPTION_PART = "Anakin wins a thrilling Podrace and with it his freedom as he leaves his home to be trained as a Jedi.";

    @Test
    public void selectMovieTest() {
        LOG.step("Step 1 - Go to Films Page");
        FilmsPage filmsPage = new FilmsPage();
        filmsPage.getFilmsButton().click();

        LOG.step("Step 2 - Select Movie");
        WaitService.waitUntilElementIsDisplayed(filmsPage.getFilmSelector());

        String movieName = "THE PHANTOM MENACE";
        filmsPage.selectMovie(movieName);

        LOG.step("Step 3 - Verify film data");
        Assert.assertTrue(filmsPage.getFilmNameLabel().getText().contains(movieName));
        Assert.assertTrue(filmsPage.getFilmDescription().getText().contains(DESCRIPTION_PART));
    }


}
