package com.epam;

import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestCarSearch{
    private Steps steps;
    private final static String CITY_OF_ARRIVAL = "Barcelona";

    @BeforeTest(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanFindCar()
    {
        steps.enterCarParameters(CITY_OF_ARRIVAL);
        Assert.assertTrue(steps.isMapWithCarOffersDisplayed());
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
