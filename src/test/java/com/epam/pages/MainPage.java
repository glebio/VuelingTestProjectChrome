package com.epam.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends AbstractPage {

    private final static String BASE_URL = "http://tickets.vueling.com/?culture=en-GB";
    private final static String PATH_TO_STATION_LIST = "//*[@id=\"stationsList\"]/ul/li/a/strong";
    private final static String PATH_TO_BUTTON_NEXT_IN_CALENDER = "ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right";
    private final static String PARAM_FOR_JAVA_SCRIPT = "arguments[0].click();";

    @FindBy(id = "accountButton_button")
    private WebElement buttonForLogin;

    @FindBy(id = "StaticHeaderViewSearchView_MemberLoginHeaderSearchView_TextBoxUserID")
    private WebElement fieldUserNameForLogin;

    @FindBy(id = "StaticHeaderViewSearchView_MemberLoginHeaderSearchView_PasswordFieldPassword")
    private WebElement fieldPasswordForLogin;

    @FindBy(id = "StaticHeaderViewSearchView_MemberLoginHeaderSearchView_ButtonLogIn")
    private WebElement buttonLogin;

    @FindBy(xpath = ".//*[@id='hiMyVyeling']/a")
    private WebElement fieldForCheckIsLogin;

    //@FindBy(xpath = ".//*[@id='radiosBuscador']//label")
    @FindBy(id = "AvailabilitySearchInputSearchView_RoundTrip")
    // //span[text() = 'Return']
    private WebElement buttonReturn;

    @FindBy(id = "AvailabilitySearchInputSearchView_OneWay")
    private WebElement buttonOneWayOnly;

    @FindBy(id = "AvailabilitySearchInputSearchView_TextBoxMarketOrigin1")
    private WebElement fieldFromFlight;

    @FindBy(id = "AvailabilitySearchInputSearchView_TextBoxMarketDestination1")
    private WebElement fieldToFlight;

    @FindBy(xpath = "//div[contains(@class, 'ui-helper-clearfix ui-corner-left')]//span[contains(@class, 'ui-datepicker-month')]")
    private WebElement monthInCalenderLeft;

    @FindBy(xpath = "//div[contains(@class, 'ui-helper-clearfix ui-corner-right')]//span[contains(@class, 'ui-datepicker-month')]")
    private WebElement monthInCalenderRight;

    @FindBy(id = "DropDownListPassengerType_ADT_1")
    private WebElement onePasenger;

    @FindBy(id = "DropDownListPassengerType_ADT_2")
    private WebElement twoPasengers;

    @FindBy(xpath = "//a[@title='Search for flights']")
    private WebElement searchForFlights;

    @FindBy(xpath = "//*[@id='stationsList']/ul/li/a[@class = 'optionActive']")
    private WebElement clickOnNeedCity;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public MainPage login(String login, String psw) {
        buttonForLogin.click();
        fieldUserNameForLogin.clear();
        fieldUserNameForLogin.sendKeys(login);
        fieldPasswordForLogin.clear();
        fieldPasswordForLogin.sendKeys(psw);
        buttonLogin.click();
        return this;
    }

    public String verifyLogin() {
        return fieldForCheckIsLogin.getText();
    }

    public void chooseFlightReturn() {
        super.clickOnButton(buttonReturn);
    }

    public void chooseFlightOneWay() {
        super.clickOnButton(buttonOneWayOnly);
    }

    public void chooseTwoPassenger() {
        super.clickOnButton(twoPasengers);
    }

    public void clickButtonSearchFlight() {
        super.clickOnButton(searchForFlights);
    }

    public void chooseCityForFlight(String cityOfDeparture, String cityOfArrival) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        fieldFromFlight.sendKeys(cityOfDeparture);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATH_TO_STATION_LIST)));
        clickOnNeedCity.click();

        fieldToFlight.sendKeys(cityOfArrival);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATH_TO_STATION_LIST)));
        clickOnNeedCity.click();
    }

    public void chooseDateFlight(String dateOfFlight) {

        //WebDriverWait wait = new WebDriverWait(driver, 50);

        /*List<WebElement> availableDatesList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/*//*[@id='datePickerContainer']//div[contains(@class, 'ui-datepicker-group-last')]//a")));
        WebElement webElement = availableDatesList.get(availableDatesList.size() - 1);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(PARAM_FOR_JAVA_SCRIPT, webElement);*/



        //WebDriverWait wait = new WebDriverWait(driver, 50);
       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(PATH_TO_BUTTON_NEXT_IN_CALENDER)));
        List<WebElement> availableDatesList = driver.findElements(By.xpath("//td[@data-handler='selectDay' and not(contains(@class, 'ui-datepicker-unselectable'))]"));
        WebElement webElement = availableDatesList.get(availableDatesList.size() - 1);
        System.out.println(availableDatesList.size());
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript(PARAM_FOR_JAVA_SCRIPT, webElement);
    }
}






