package com.nbc.api.testcases;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.nbc.api.apiobjects.SwapiAPIObject;
import com.nbc.ui.services.logger.CustomLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;

public class SwapiAPITest {
    public static final CustomLogger LOG = CustomLogger.getLogger();

    @Test
    public void findAllPlanetsTest() {
        SwapiAPIObject swapiAPIObject = new SwapiAPIObject();

        LOG.step("Step 1 - Find all planets");
        Response response = swapiAPIObject.findAll();
        final JsonPath jsonPath = response.jsonPath();

        LOG.step("Step 2 - Verify planets information");
        Assert.assertEquals(response.getStatusCode(), HttpURLConnection.HTTP_OK, "Verifying status code");

        int totalPlanets = 10;
        Assert.assertEquals(jsonPath.getList("results").size(), totalPlanets, "Verify total amount of planets");

        int planetAlderaanExpectedRotationPeriod = 24;
        Assert.assertEquals(jsonPath.getInt("results.find{it.name == 'Alderaan'}.rotation_period"), planetAlderaanExpectedRotationPeriod, "Verifying Alderaan rotation period");

        int planetBespinExpectedDiameter = 118000;
        Assert.assertEquals(jsonPath.getInt("results.find{it.name == 'Bespin'}.diameter"), planetBespinExpectedDiameter, "Verifying Bespin diametr");

        Assert.assertTrue(jsonPath.get("results.any{it.climate == 'temperate'}"), "Verifying if planets with temperate climate are present");
    }

    @Test
    public void findPlanetByIdTest() {
        SwapiAPIObject swapiAPIObject = new SwapiAPIObject();

        LOG.step("Step 1 - Find planet by id");
        Response response = swapiAPIObject.findById(3);
        final JsonPath jsonPath = response.jsonPath();

        LOG.step("Step 2 - Verify planet information");
        Assert.assertEquals(response.getStatusCode(), HttpURLConnection.HTTP_OK, "Verifying status code");

        int planetYavinFourOrbitalPeriod = 4818;
        Assert.assertEquals(jsonPath.getInt("orbital_period"), planetYavinFourOrbitalPeriod, "Verify orbital period");
        Assert.assertEquals(jsonPath.get("name"), "Yavin IV", "Verify planet name");
    }

    @Test
    public void findPlanetByIncorrectIdTest() {
        SwapiAPIObject swapiAPIObject = new SwapiAPIObject();

        LOG.step("Step 1 - Find planet by incorrect id");
        Response response = swapiAPIObject.findById(456);
        final JsonPath jsonPath = response.jsonPath();

        LOG.step("Step 2 - Verify that no planet returned");
        Assert.assertEquals(response.getStatusCode(), HttpURLConnection.HTTP_NOT_FOUND, "Verifying status code");
        Assert.assertEquals(jsonPath.get("detail"), "Not found", "Verifying that planet not presented");
    }
}
