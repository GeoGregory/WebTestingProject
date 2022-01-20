package org.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.IndividualProduct;
import org.framework.pom.LoginPage;
import org.framework.pom.Products;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductsStepdefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products productsPage;
    private IndividualProduct productPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }


    @Given("I have logged in")
    public void iHaveLoggedIn() {
        loginPage.quickLogin();
    }

    @When("I view the products page")
    public void iViewTheProductsPage() {


    }

    @Then("All \\({int}) products should be shown correctly \\(with corresponding image, price and description)")
    public void allProductsShouldBeShownCorrectlyWithCorrespondingImagePriceAndDescription(int arg0) {
        //read from csv files with elements on the page
    }

    @Given("that I am on the products page")
    public void thatIAmOnTheProductsPage() {
        productsPage = loginPage.quickLogin();
    }

    @When("I click on the add to cart button")
    public void iClickOnTheAddToCartButton() {
        productsPage.toggleAddOrRemoveToCart(productsPage.getAddBackpackButton(), productsPage.getRemoveBackpackButton());
    }

    @Then("the cart icon is incremented and the button for that product changes to remove")
    public void theCartIconIsIncrementedAndTheButtonForThatProductChangesToRemove() {
//        if (productsPage.getOriginalCartCount() != productsPage.getCartCount()) {
//            //cart count has successfully updated
//            System.out.println("Success");
//        } else {
//            //cart count has not updated. Display error message.
//            System.out.println("Fail cart count not updated");
//        }
        Assertions.assertNotEquals(productsPage.getOriginalCartCount(), productsPage.getCartCount());
    }

    @Given("that I am on the product page")
    public void thatIAmOnTheProductPage() {
        productPage = productsPage.goToProductPage(0);
    }

    @When("I click on the add to cart button for the single product")
    public void iClickOnTheAddToCartButtonForTheSingleProduct() {
        productPage.toggleSingleProductAddOrRemoveToCart();
    }

    @Then("the cart icon is incremented and the button for that product changes to remove from the product page")
    public void theCartIconIsIncrementedAndTheButtonForThatProductChangesToRemoveFromTheProductPage() {
        Assertions.assertNotEquals(productPage.getOriginalCartCount() , productPage.getCartCount());
    }

//    @Given("I am on the products page")
//    public void iAmOnTheProductsPage() {
//    }

    @When("I sort by <sortingMethods>")
    public void iSortBySortingMethods() {
    }

    @Then("The products are ordered correctly")
    public void theProductsAreOrderedCorrectly() {
    }

    @When("I click on a specific product")
    public void iClickOnASpecificProduct() {
        productsPage = loginPage.quickLogin();
        productPage = productsPage.goToProductPage(1);
    }

    @Then("I should go to \\{product page}")
    public void iShouldGoToProductPage() {
//        String productNameCheckFromProducts = productsPage.getProductName(1);
//        String productNameCheckFromIndividualProduct = productPage.getProductName();
//        Assertions.assertEquals(productNameCheckFromProducts,productNameCheckFromIndividualProduct);
    }

    @After
    void tearDown() {
        driver.quit();
    }
}
