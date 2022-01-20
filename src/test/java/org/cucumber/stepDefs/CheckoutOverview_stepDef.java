package test.java.org.cucumber.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.java.org.framework.pom.*;

public class CheckoutOverview_stepDef {


    CheckoutOverview checkoutOverview;


    private WebDriver driver;
    private LoginPage loginPage;
    private Products productsPage;
    private Cart cart;
    private CheckoutYourInfo checkoutYourInfo;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I am on the CheckoutOverview Page")
    public void iAmOnTheCheckoutOverviewPage() {
        loginPage.quickLogin();
        productsPage.goToCart();
        cart.goToCheckout();
        checkoutYourInfo.setTextField(CheckoutYourInfo.TextFields.FIRSTNAME, "name");
        checkoutYourInfo.setTextField(CheckoutYourInfo.TextFields.LASTNAME, "name");
        checkoutYourInfo.setTextField(CheckoutYourInfo.TextFields.ZIPPOSTALCODE, "name");
        checkoutYourInfo.goToCheckoutOverview();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutOverview.getURL());
    }

    @When("I check the total of my purchases")
    public void iCheckTheTotalOfMyPurchases() {
        System.out.println(checkoutOverview.getSubtotal());
    }

    @Then("They should be calculated together with tax added on")
    public void theyShouldBeCalculatedTogetherWithTaxAddedOn() {
        System.out.println(checkoutOverview.getTax());
        System.out.println(checkoutOverview.getTotal());
    }

    @When("I check the tax")
    public void iCheckTheTax() {
    }

    @Then("I see what the tax is")
    public void iSeeWhatTheTaxIs() {
        System.out.println(checkoutOverview.getTax());
    }
}
