package com.epam;

import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestFlightStatusByDestinations{
    private Steps steps;
    private final static String CITY_OF_DEPARTURE = "Warsaw";
    private final static String CITY_OF_ARRIVAL = "Barcelona";
    private final static String DATE_OF_FLIGHT = "5/April";

    @BeforeTest(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanVerifyStatusFlightByDestinations()
    {
        steps.openFlightsStatusPageWithDestinationsChooseDepartureAndArrivalCitiesAndDate(CITY_OF_DEPARTURE, CITY_OF_ARRIVAL, DATE_OF_FLIGHT);
        Assert.assertFalse(steps.severalFlightsTableDisplayed());
        Assert.assertEquals(steps.verifyFlightStatus(), ("Not operating"));
        Assert.assertEquals(steps.verifyDateFlight(), DATE_OF_FLIGHT);
        Assert.assertEquals(steps.verifyCityDeparture(), CITY_OF_DEPARTURE);
        Assert.assertEquals(steps.verifyCityArrival(), CITY_OF_ARRIVAL);
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
