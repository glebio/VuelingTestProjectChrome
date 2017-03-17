package com.epam;

import com.epam.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Volha_Hitskaya on 3/17/2017.
 */
public class TestLogIn {
    private Steps steps;
    private final static String LOGIN = "mashkevich.nastya@mail.ru";
    private final static String PASSWORD = "wertyu1";

    @BeforeTest(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanLogin()
    {
        steps.loginToVueling(LOGIN, PASSWORD);
        Assert.assertTrue(steps.isLoginToVueling());
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }

}
