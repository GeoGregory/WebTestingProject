package org.cucumber.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.Enums.UserOptions;
import org.framework.pom.LoginPage;
import org.framework.pom.POMUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefs {
    private WebDriver driver;
    private LoginPage loginPage;
    private String username;
    private String password;
    private long duration;

//    @Before
//    public void setup(){
//        System.out.println("setup");
//        POMUtils.setDriverLocation("src/test/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        loginPage = new LoginPage(driver);
//    }
//
//    @After
//    public void teardown(){
//        System.out.println("quit");
//        driver.quit();
//    }

    @Given("I have a valid username and password")
    public void iHaveAValidUsernameAndPassword() {
        username = UserOptions.STANDARD.getUserOption();
        password = "secret_sauce";
    }

    @Then("I should be logged in and moved to the main page")
    public void iShouldBeLoggedInAndMovedToTheMainPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Given("that my username or password are invalid")
    public void thatMyUsernameOrPasswordAreInvalid() {
        username = "PavleIsTheBestCoder";
        password = "LouisIsTheBestCoder";
    }

    @Then("an error should be displayed letting me know the username or password are invalid")
    public void anErrorShouldBeDisplayedLettingMeKnowTheUsernameAndOrPasswordAreInvalid() {
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }

    @When("I leave the username field blank")
    public void iLeaveTheUsernameFieldBlank() {
        loginPage.inputLoginFields(username,"");
    }

    @Then("an error should be displayed letting me know what fields I didn't fill out")
    public void anErrorShouldBeDisplayedLettingMeKnowWhatFieldsIDidnTFillOut() {
        Assertions.assertEquals(true, loginPage.getErrorMessage().contains("is required"));
    }

    @When("I leave the password field blank")
    public void iLeaveThePasswordFieldBlank() {
        loginPage.inputLoginFields("",password);
    }

    @Given("that I trigger an error message")
    public void thatITriggerAnErrorMessage() {
        loginPage.clickLoginButton();
    }

    @When("I click the x on the error message")
    public void iClickTheXOnTheErrorMessage() {
        loginPage.clickErrorCloseButton();
    }

    @Then("the error message should go away")
    public void theErrorMessageShouldGoAway() {
        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertEquals("", errorMessage);
    }

    @When("I type both in")
    public void iTypeBothIn() {
        loginPage.inputLoginFields(username, password);
    }

    @And("press login")
    public void pressLogin() {
        loginPage.clickLoginButton();
    }

    @And("press enter")
    public void pressEnter() {
        loginPage.pressEnter();
    }

    @Given("I have a locked out username and password")
    public void iHaveALockedOutUsernameAndPassword() {
        username = UserOptions.LOCKED_OUT.getUserOption();
        password = "secret_sauce";
    }

    @Then("an error should be displayed letting me know I am locked out")
    public void anErrorShouldBeDisplayedLettingMeKnowIAmLockedOut() {
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
    }

    @When("I try to log in")
    public void iTryToLogIn() {
        iTypeBothIn();
        pressEnter();
    }

    @Given("I have a performance glitched username and password")
    public void iHaveAPerformanceGlitchedUsernameAndPassword() {
        username = UserOptions.PERFORMANCE.getUserOption();
        password = "secret_sauce";
    }

    @When("I time my log in")
    public void iTimeMyLogIn() {
        long startTime = System.nanoTime();
        iTypeBothIn();
        pressEnter();
        long endTime = System.nanoTime();

        duration = (endTime - startTime);
    }

    @Then("it should take longer than a normal login")
    public void itShouldTakeLongerThanANormalLogin() {
        long glitchedDuration = duration;
        loginPage = new LoginPage(driver);
        iHaveAValidUsernameAndPassword();
        iTimeMyLogIn();
        long standardDuration = duration;
        long bufferTime = 1000000000L;
        Assertions.assertEquals(true,glitchedDuration > (standardDuration + bufferTime));
    }

    @Given("I log in with Bernie's username and password")
    public void iLogInWithBernieSUsernameAndPassword() {
        username = "Bernie 1982";
        password = "Hunter2";
    }

}