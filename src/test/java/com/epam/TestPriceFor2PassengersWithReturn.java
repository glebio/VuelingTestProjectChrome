package com.epam;

import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestPriceFor2PassengersWithReturn {
    private Steps steps;
    private final static String CITY_OF_DEPARTURE = "Warsaw";
    private final static String CITY_OF_ARRIVAL = "Barcelona";
    private final static String DATE_FORWARD = "2/April";
    private final static int NUMBER_OF_PASSENGERS = 2;
    private final static String DATE_BACK = "14/May";

    @BeforeTest(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanVerifyRightPriceForTwoPassengersFlightWithReturn()
    {
        steps.canChooseFlightWithReturn(CITY_OF_DEPARTURE, CITY_OF_ARRIVAL, DATE_FORWARD, DATE_BACK);
        double priceWithoutFee = steps.takePriceFromWebSiteFor1Passenger() * NUMBER_OF_PASSENGERS;
        double bookingFee = steps.takeBookingFee();
        double actualPrice = priceWithoutFee + bookingFee;
        DecimalFormat df = new DecimalFormat("#.##");
        Assert.assertEquals(df.format(actualPrice), df.format(steps.takeFinalPrice()));
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
