package com.epam;

import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestSearchFlight {

    private Steps steps;
    private final static String CITY_OF_DEPARTURE = "Warsaw";
    private final static String CITY_OF_ARRIVAL = "Barcelona";
    private final static String DATE_FORWARD = "2/April";
    private final static String DATE_BACK = "14/May";

    @BeforeTest(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanSearchFlight()
    {
        steps.openMainPageChooseCityOfDepartureCityOfArrivalAndDate(CITY_OF_DEPARTURE, CITY_OF_ARRIVAL, DATE_FORWARD);
        Assert.assertTrue(steps.verifyFlight(DATE_BACK));
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
