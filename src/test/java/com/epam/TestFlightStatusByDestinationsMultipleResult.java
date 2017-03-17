package com.epam;

import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestFlightStatusByDestinationsMultipleResult{
    private Steps steps;
    private final static String CITY_DEPARTURE = "Amsterdam";
    private final static String CITY_ARRIVAL = "Florence";
    private final static String DATE_OF_FLIGHT = "5/April";
    private final static String FULL_FORMAT_FLIGHT_DATE = "05/04/2017";

    @BeforeTest(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanVerifyStatusFlightByDestinationsWhenMultipleFlightsDisplayed()
    {
        steps.openFlightsStatusPageWithDestinationsChooseDepartureAndArrivalCitiesAndDate(CITY_DEPARTURE, CITY_ARRIVAL, DATE_OF_FLIGHT);
        Assert.assertTrue(steps.severalFlightsTableDisplayed());
        Assert.assertTrue(steps.correctMultipleFlightsInfoDisplayed(CITY_DEPARTURE, CITY_ARRIVAL, FULL_FORMAT_FLIGHT_DATE));
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
