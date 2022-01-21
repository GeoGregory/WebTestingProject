package org.cucumber.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.*;
import org.framework.pom.Enums.UserOptions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutCompleteStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products products;
    private Cart cart;
    private CheckoutYourInfo yourInfo;
    private CheckoutOverview overview;
    private CheckoutComplete finish;

    @Given("I am on the checkout complete page after a purchase")
    public void iAmOnTheCheckoutCompletePageAfterAPurchase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        products = loginPage.quickLogin(UserOptions.STANDARD);
        cart = products.goToCart();
        yourInfo = cart.goToCheckout();
        yourInfo.setTextField(CheckoutYourInfo.TextFields.FIRSTNAME, "A");
        yourInfo.setTextField(CheckoutYourInfo.TextFields.LASTNAME, "A");
        yourInfo.setTextField(CheckoutYourInfo.TextFields.ZIPPOSTALCODE, "A");
        overview = yourInfo.goToCheckoutOverview();
        finish = overview.goToFinish();
    }

    @When("I click the BACK HOME button")
    public void iClickTheBACKHOMEButton() {
        products = finish.goToPastPage();
    }

    @Then("I should be taken to the main products page from the checkout complete page")
    public void iShouldBeTakenToTheMainProductsPageFromTheCheckoutCompletePage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", products.getURL());
    }
}
