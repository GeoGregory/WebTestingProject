package org.cucumber.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.*;
import org.framework.pom.Enums.UserOptions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckoutYourInfoStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products products;
    private Cart cart;
    private CheckoutYourInfo yourInfo;
    private CheckoutOverview overview;

    @Given("I am logged in as a standard user and on the checkout your info page")
    public void iAmLoggedInAndOnTheCheckoutYourInfoPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        products = loginPage.quickLogin(UserOptions.STANDARD);
        cart = products.goToCart();
        yourInfo = cart.goToCheckout();
    }

    @Given("I am logged in as a problem user and on the checkout your info page")
    public void iAmLoggedInAsAProblemUserAndOnTheCheckoutYourInfoPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        products = loginPage.quickLogin(UserOptions.PROBLEM);
        cart = products.goToCart();
        yourInfo = cart.goToCheckout();
    }



    @And("I fill in all available text fields")
    public void iFillInAllAvailableTextFields() {
        yourInfo.setTextField(CheckoutYourInfo.TextFields.FIRSTNAME, "First Name");
        yourInfo.setTextField(CheckoutYourInfo.TextFields.LASTNAME, "Last Name");
        yourInfo.setTextField(CheckoutYourInfo.TextFields.ZIPPOSTALCODE, "ZIP\\/Postal Code");
    }

    @When("I click the CONTINUE button")
    public void iClickTheCONTINUEButton() {
        overview = yourInfo.goToCheckoutOverview();
    }

    @Then("I should be taken to the checkout overview page")
    public void iShouldBeTakenToTheCheckoutOverviewPage() {
        Assertions.assertEquals(overview.getURL(), "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Then("I should receive an error message")
    public void iShouldReceiveAnErrorMessage() {
        Assertions.assertTrue(yourInfo.getErrorMessage().contains("Error"));
    }

    @And("I have filled in the First Name field")
    public void iHaveFilledInTheFirstNameField() {
        yourInfo.setTextField(CheckoutYourInfo.TextFields.FIRSTNAME, "First Name");
    }

    @And("I have filled in the Last Name field")
    public void iHaveFilledInTheLastNameField() {
        yourInfo.setTextField(CheckoutYourInfo.TextFields.LASTNAME, "Last Name");
    }

    @And("I have filled in the Postal Code field")
    public void iHaveFilledInThePostalCodeField() {
        yourInfo.setTextField(CheckoutYourInfo.TextFields.ZIPPOSTALCODE, "ZIP\\/Postal Code");
    }

    @Then("I should receive an error prompting me to fill in the Postal Code field")
    public void iShouldReceiveAnErrorPromptingMeToFillInThePostalCodeField() {
        Assertions.assertTrue(yourInfo.getErrorMessage().contains("Error: Postal Code is required"));
    }

    @Then("I should receive an error prompting me to fill in the Last Name field")
    public void iShouldReceiveAnErrorPromptingMeToFillInTheLastNameField() {
        Assertions.assertTrue(yourInfo.getErrorMessage().contains("Error: Last Name is required"));

    }

    @Then("I should receive an error prompting me to fill in the First Name field")
    public void iShouldReceiveAnErrorPromptingMeToFillInTheFirstNameField() {
        Assertions.assertTrue(yourInfo.getErrorMessage().contains("Error: First Name is required"));

    }

    @When("I click the CANCEL button")
    public void iClickTheCANCELButton() {
        cart = yourInfo.goToCartViaCancel();
    }

    @Then("I should be taken to the cart page")
    public void iShouldBeTakenToTheCartPage() {
        Assertions.assertEquals(cart.getURL(), "https://www.saucedemo.com/cart.html");
    }


}
