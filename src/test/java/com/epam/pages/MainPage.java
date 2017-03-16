package com.epam.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends AbstractPage
{

    private final static String BASE_URL = "http://www.vueling.com/en";
    private final static String PATH_TO_STATION_LIST = "//*[@id=\"stationsList\"]/ul/li/a/strong";
    private final static String PATH_TO_BUTTON_NEXT_IN_CALENDER = ".//*[@id='datePickerContainer']//a[@data-handler = 'next']";
    private final static String PARAM_FOR_JAVA_SCRIPT = "arguments[0].click();";

    @FindBy(id = "openAccountButton")
    private WebElement buttonForLogin;

    @FindBy(id = "ControlGroupMainContact_MemberLoginAndRegisterAboveContactView_TextBoxRegisterEmail")
    private WebElement fieldUserNameForLogin;

    @FindBy(id = "ControlGroupMainContact_MemberLoginAndRegisterAboveContactView_TextBoxRegisterPassword")
    private WebElement fieldPasswordForLogin;

    @FindBy(xpath = "//span[@id='btnEnvContacto']/span[@class='bt_link']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//*[contains(@class, 'header_navBarUser_account_nick')]")
    private WebElement fieldForCheckIsLogin;

    @FindBy(xpath = "//span[text() = 'Return']")
    private WebElement buttonReturn;

    @FindBy(xpath = ".//input[@id='AvailabilitySearchInputXmlSearchView_OneWay']")
    private WebElement buttonOneWayOnly;

    @FindBy(xpath = "//input[@id='AvailabilitySearchInputXmlSearchView_TextBoxMarketOrigin1']")
    private WebElement fieldFromFlight;

    @FindBy(xpath = "//input[@id='AvailabilitySearchInputXmlSearchView_TextBoxMarketDestination1']")
    private WebElement fieldToFlight;

    @FindBy(xpath = "//div[contains(@class, 'ui-helper-clearfix ui-corner-left')]//span[contains(@class, 'ui-datepicker-month')]")
    private WebElement monthInCalenderLeft;

    @FindBy(xpath = "//div[contains(@class, 'ui-helper-clearfix ui-corner-right')]//span[contains(@class, 'ui-datepicker-month')]")
    private WebElement monthInCalenderRight;

    @FindBy(id = "DropDownListPassengerType_ADT_1")
    private WebElement onePasenger;

    @FindBy(id = "DropDownListPassengerType_ADT_2")
    private WebElement twoPasengers;

    @FindBy(id = "AvailabilitySearchInputXmlSearchView_btnClickToSearchNormal")
    private WebElement searchForFlights;

    @FindBy(xpath = "//*[@id='stationsList']/ul/li/a[@class = 'optionActive']")
    private WebElement clickOnNeedCity;

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public MainPage login(String login, String psw)
    {
        buttonForLogin.click();
        fieldUserNameForLogin.clear();
        fieldUserNameForLogin.sendKeys(login);
        fieldPasswordForLogin.clear();
        fieldPasswordForLogin.sendKeys(psw);
        buttonLogin.click();
        return this;
    }

    public String verifyLogin()
    {
        return fieldForCheckIsLogin.getText();
    }

    public void chooseFlightReturn()
    {
        super.clickOnButton(buttonReturn);
    }

    public void chooseFlightOneWay()
    {
        super.clickOnButton(buttonOneWayOnly);
    }

    public void chooseTwoPassenger()
    {
        super.clickOnButton(twoPasengers);
    }

    public void clickButtonSearchFlight()
    {
        super.clickOnButton(searchForFlights);
    }

    public void chooseCityForFlight(String cityOfDeparture, String cityOfArrival)
    {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        fieldFromFlight.sendKeys(cityOfDeparture);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATH_TO_STATION_LIST)));
        clickOnNeedCity.click();

        fieldToFlight.sendKeys(cityOfArrival);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATH_TO_STATION_LIST)));
        clickOnNeedCity.click();
    }

    public void chooseDateFlight(String dateOfFlight)
    {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATH_TO_BUTTON_NEXT_IN_CALENDER)));
        List<WebElement> availableDatesList = driver.findElements(By.xpath(".//*[@data-handler='selectDay']"));
        WebElement webElement = availableDatesList.get(availableDatesList.size() - 2);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript(PARAM_FOR_JAVA_SCRIPT, webElement);
    }
}






