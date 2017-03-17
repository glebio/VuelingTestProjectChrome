package com.epam;

import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestPriceFor2PassengersOneWay {
    private Steps steps;
    private final static String CITY_OF_DEPARTURE = "Warsaw";
    private final static String CITY_OF_ARRIVAL = "Barcelona";
    private final static String DATE_FORWARD = "2/April";
    private final static int NUMBER_OF_PASSENGERS = 2;

    @BeforeTest(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanVerifyRightPriceForTwoPassengersFlightOneWay()
    {
        steps.canChooseFlightOneWay(CITY_OF_DEPARTURE, CITY_OF_ARRIVAL, DATE_FORWARD);
        Assert.assertEquals((steps.takePriceFromWebSiteFor1Passenger() * NUMBER_OF_PASSENGERS), steps.takeTotalPriceForAllPassengers());
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
