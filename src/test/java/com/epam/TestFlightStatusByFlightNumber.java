package com.epam;

import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestFlightStatusByFlightNumber{
    private Steps steps;
    private final static String CITY_OF_DEPARTURE = "Warsaw";
    private final static String CITY_OF_ARRIVAL = "Barcelona";
    private final static String DATE_OF_FLIGHT = "5/April";
    private final static String FLIGHT_NUMBER = "8845";

    @BeforeTest(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanVerifyStatusFlight()
    {
        steps.openFlightsStatusPageWithFlightNumberInsertFlightNumberAndChooseDate(FLIGHT_NUMBER, DATE_OF_FLIGHT);
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
