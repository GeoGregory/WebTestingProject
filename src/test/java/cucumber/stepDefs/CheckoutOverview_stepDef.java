package test.java.cucumber.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import test.java.framework.pom.*;

import java.util.List;

public class CheckoutOverview_stepDef {


    CheckoutOverview checkoutOverview;

    private WebDriver driver;
    private LoginPage loginPage;
    private Products productsPage;
    private Cart cart;
    private CheckoutYourInfo checkoutYourInfo;
    private List<WebElement> items;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productsPage = loginPage.quickLogin();
        productsPage.toggleAddOrRemoveToCart(productsPage.getAddBackpackButton(), productsPage.getAddBackpackButton());
        cart = productsPage.goToCart();
        items = cart.getAllProducts();
        checkoutYourInfo = cart.goToCheckout();
        checkoutYourInfo.setTextField(CheckoutYourInfo.TextFields.FIRSTNAME, "name");
        checkoutYourInfo.setTextField(CheckoutYourInfo.TextFields.LASTNAME, "name");
        checkoutYourInfo.setTextField(CheckoutYourInfo.TextFields.ZIPPOSTALCODE, "name");
        checkoutOverview = checkoutYourInfo.goToCheckoutOverview();
    }

    @Given("I am on the CheckoutOverview Page")
    public void iAmOnTheCheckoutOverviewPage() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", checkoutOverview.getURL());
    }

    @When("I check the <total> of my purchases")
    public void iCheckTheTotalOfMyPurchases() {
        System.out.println(checkoutOverview.getTotal());
    }

    @Then("It should be the <subtotal> plus the <tax>")
    public void itShouldBeTheSubtotalPlusTheTax() {
        double total = checkoutOverview.getMoneyAsDouble(checkoutOverview.getTotal());
        System.out.println(total);
        double tax = checkoutOverview.getMoneyAsDouble(checkoutOverview.getTax());
        System.out.println(tax);
        double subtotal = checkoutOverview.getSubtotalAsDouble();
        System.out.println(subtotal);

        //Adds subtotal and tax together and checks that it is equal to total
        Assert.assertEquals((checkoutOverview.getSubtotalAsDouble()
                        + checkoutOverview.getMoneyAsDouble(checkoutOverview.getTax())),
                checkoutOverview.getMoneyAsDouble(checkoutOverview.getTotal()),1);
    }

    @When("I click the cancel button")
    public void iClickTheCancelButton() {
        checkoutOverview.goToCancel();
    }

    @Then("I go back to the products page")
    public void iGoBackToTheProductsPage() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @When("I click the finish button")
    public void iClickTheFinishButton() {
        checkoutOverview.goToFinish();
    }

    @Then("I go to the Checkout Complete Page")
    public void iGoToTheCheckoutCompletePage() {
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", driver.getCurrentUrl());
    }

    @When("I look at my items")
    public void iLookAtMyItems() {
        //This doesn't work, but the test works
        for (WebElement e : checkoutOverview.getCartItems())
            System.out.println(e.getText());
    }

    @Then("I see all the things I am purchasing")
    public void iSeeAllTheThingsIAmPurchasing() {
        Assert.assertEquals(items, checkoutOverview.getCartItems());
    }

    @After
    public void tearDown(){
        driver.quit();
        System.out.println("tearDown");
    }
}
