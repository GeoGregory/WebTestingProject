package org.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.Enums.UserOptions;
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

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @When("I logged in")
    public void iLoggedIn() {
        productsPage = loginPage.quickLogin(UserOptions.STANDARD);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
    }


    @Given("I have logged in")
    public void iHaveLoggedIn() {
    }

    @When("I view the products page")
    public void iViewTheProductsPage() {

    }

    @Then("All products should be shown correctly \\(with corresponding image, price and description)")
    public void allProductsShouldBeShownCorrectlyWithCorrespondingImagePriceAndDescription() {
        //read from csv files with elements on the page
        boolean allCorrect = true;
        for (int i = 0; i < 6; i++) {
            allCorrect = productsPage.isCorrect(allCorrect, i);
        }
        Assertions.assertEquals(true, allCorrect);
    }

    @Given("that I am on the products page")
    public void thatIAmOnTheProductsPage() {
    }

    @When("I click on a {string} and add to cart button")
    public void iClickOnAAndAddToCartButton(String productName) {
        if (productName.equals("Sauce Labs Backpack")) {
            productsPage.toggleAddOrRemoveToCart(productsPage.getAddBackpackButton(), productsPage.getRemoveBackpackButton());
        }
        if (productName.equals("Sauce Labs Bike Light")) {
            productsPage.toggleAddOrRemoveToCart(productsPage.getAddBikeLightsButton(), productsPage.getRemoveBikeLightsButton());
        }
        if (productName.equals("Sauce Labs Bolt T-Shirt")) {
            productsPage.toggleAddOrRemoveToCart(productsPage.getAddBoltTShirtButton(), productsPage.getRemoveBoltTShirtButton());
        }
        if (productName.equals("Sauce Labs Fleece Jacket")) {
            productsPage.toggleAddOrRemoveToCart(productsPage.getAddFleeceJacketButton(), productsPage.getRemoveFleeceJacketButton());
        }
        if (productName.equals("Sauce Labs Onesie")) {
            productsPage.toggleAddOrRemoveToCart(productsPage.getAddOnesieButton(), productsPage.getRemoveOnsieButton());
        }
        if (productName.equals("Test.allTheThings() T-Shirt (Red)")) {
            productsPage.toggleAddOrRemoveToCart(productsPage.getAddRedShirtButton(), productsPage.getRemoveRedShirtButton());
        }
    }

    @Then("the cart icon is incremented and the button for that product changes to remove")
    public void theCartIconIsIncrementedAndTheButtonForThatProductChangesToRemove() {
        Assertions.assertNotEquals(productsPage.getOriginalCartCount(), productsPage.getCartCount());
    }

    //error from here
    @Given("that I am starting on the products page")
    public void thatIAmStartingOnTheProductsPage() {
    }

    @When("I sort by {string}")
    public void iSortBy(String sortingMethod) {
        productsPage.checkSortOptions(sortingMethod);
    }

    @Then("The products are ordered correctly {string} is first")
    public void theProductsAreOrderedCorrectlyIsFirst(String firstProduct) {
        boolean firstProductCheck = productsPage.getFirstProductOnThePage(firstProduct);
        Assertions.assertEquals(true, firstProductCheck);
    }

    @Given("that I am on the {string} page")
    public void thatIAmOnThePage(String productName) {
        for (int i = 0; i < 6; i++) {
            if (productsPage.getProductName(i).equals(productName)) {
                productPage = productsPage.goToProductPage(i);
            }
        }
    }

    @When("I click on the add to cart button for the single {string}")
    public void iClickOnTheAddToCartButtonForTheSingle(String productName) {
        productPage.toggleSingleProductAddOrRemoveToCart();
    }

    @Then("the cart icon is incremented and the button changes to remove")
    public void theCartIconIsIncrementedAndTheButtonChangesToRemove() {
        Assertions.assertNotEquals(productPage.getOriginalCartCount() , productPage.getCartCount());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}





















//    @Given("that I am on the product page")
//    public void thatIAmOnTheProductPage() {
//        productPage = productsPage.goToProductPage(0);
//    }
//
//    @When("I click on the add to cart button for the single product")
//    public void iClickOnTheAddToCartButtonForTheSingleProduct() {
//        productPage.toggleSingleProductAddOrRemoveToCart();
//    }
//
//    @Then("the cart icon is incremented and the button for that product changes to remove from the product page")
//    public void theCartIconIsIncrementedAndTheButtonForThatProductChangesToRemoveFromTheProductPage() {
//        Assertions.assertNotEquals(productPage.getOriginalCartCount() , productPage.getCartCount());
//    }

//    @When("I click on a specific product")
//    public void iClickOnASpecificProduct() {
//        productsPage = loginPage.quickLogin(UserOptions.STANDARD);
//        productPage = productsPage.goToProductPage(1);
//    }
//
//    @Then("I should go to \\{product page}")
//    public void iShouldGoToProductPage() {
////        String productNameCheckFromProducts = productsPage.getProductName(1);
////        String productNameCheckFromIndividualProduct = productPage.getProductName();
////        Assertions.assertEquals(productNameCheckFromProducts,productNameCheckFromIndividualProduct);
//    }

//
//    @When("I click on a specific {string}")
//    public void iClickOnASpecific(String productName) {
////       productsPage = loginPage.quickLogin(UserOptions.STANDARD);
////        productPage = productsPage.goToProductPage(1);
//        for (int i = 0; i < 6 ; i++) {
//             if (productsPage.getProductName(i).equals(productName)) {
//                 productPage = productsPage.goToProductPage(i);
//             }
//        }
//    }
//
//    @Then("I should go to {string} page")
//    public void iShouldGoToPage(String productName) {
////        System.out.println(productPage.getProductName());
////        Assertions.assertEquals(productName, productPage.getProductName());
//    }