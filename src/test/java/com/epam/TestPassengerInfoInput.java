package com.epam;

import com.epam.bean.Person;
import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestPassengerInfoInput {

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
    public void oneCanFillInfoAboutPassenger()
    {
        Person person = new Person("John", "Smith", "Minsk", "456783", "johnsmith@gmail.com", "BY", "+375");
        steps.openMainPageChooseCityOfDepartureCityOfArrivalAndDate(CITY_OF_DEPARTURE, CITY_OF_ARRIVAL, DATE_FORWARD);
        steps.fillPassengerInformation(person, DATE_BACK);
        Assert.assertTrue(steps.isFillInfoCorrect(person));
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }

}
