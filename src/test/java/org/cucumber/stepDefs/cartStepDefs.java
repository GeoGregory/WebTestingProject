package org.cucumber.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.Cart;
import org.framework.pom.LoginPage;
import org.framework.pom.Products;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cartStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products products;
    private Cart cart;

    @Given("I am logged in and on the cart page with the backpack added")
    public void iAmLoggedInAndOnTheCartPageWithTheBackpackAdded() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        products = loginPage.quickLogin();
        products.toggleAddOrRemoveToCart(products.getAddBackpackButton(), products.getRemoveBackpackButton());
        cart = products.goToCart();
    }


    @When("I click REMOVE on the backpack")
    public void iClickREMOVEOnTheBackpack() {
        cart.removeProduct(Cart.Products.BACKPACK);
    }


    @Then("The backpack will be removed from the cart")
    public void theBackpackWillBeRemovedFromTheCart() {
        Assertions.assertThrows(NoSuchElementException.class, () -> cart.findProduct(Cart.Products.BACKPACK));
    }

    @When("I click the CHECKOUT button")
    public void iClickTheCHECKOUTButton() {
        cart.goToCheckout();
    }

    @Then("I should be taken to a page to enter my details")
    public void iShouldBeTakenToAPageToEnterMyDetails() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl());
    }

    @When("I click the CONTINUE SHOPPING button")
    public void iClickTheCONTINUESHOPPINGButton() {
        cart.goToProducts();
    }

    @Then("I should be taken to the main products page")
    public void iShouldBeTakenToTheMainProductsPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }
}
