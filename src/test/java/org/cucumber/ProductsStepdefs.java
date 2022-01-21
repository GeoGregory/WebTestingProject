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
        productsPage = loginPage.quickLogin();
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
        productsPage = loginPage.quickLogin();
    }

    @When("I click on the add to cart button")
    public void iClickOnTheAddToCartButton() {
        productsPage.toggleAddOrRemoveToCart(productsPage.getAddBackpackButton(), productsPage.getRemoveBackpackButton());
    }

    @Then("the cart icon is incremented and the button for that product changes to remove")
    public void theCartIconIsIncrementedAndTheButtonForThatProductChangesToRemove() {
        Assertions.assertNotEquals(productsPage.getOriginalCartCount(), productsPage.getCartCount());
    }

    //error from here
//    @Given("that I am starting on the products page")
//    public void thatIAmStartingOnTheProductsPage() {
//        productsPage = loginPage.quickLogin();
//    }
//
//    //error from here - don't know why
//    @When("I sort by <sortingMethods>")
//    public void iSortBySortingMethods(String sortingMethod) {
//        test.java.org.framework.pom.Enums.SortOptions sortOption = productsPage.checkSortOptions(sortingMethod);
//        productsPage.sortBy(sortOption);
    }
    //error from here - don't know why
    @Then("The products are ordered correctly <firstProduct> is first")
    public void theProductsAreOrderedCorrectlyFirstProductIsFirst(String firstProduct) {
        boolean firstProductCheck = productsPage.getFirstProductOnThePage(firstProduct);
        Assertions.assertEquals(true, firstProductCheck);
    }

    @Given("that I am on the product page")
    public void thatIAmOnTheProductPage() {
        productsPage = loginPage.quickLogin();
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

    @Given("that I am starting on the products page")
    public void thatIAmStartingOnTheProductsPage() {
    }

    @When("I sort by <sortingMethods>")
    public void iSortBySortingMethods() {
    }

    @Then("The products are ordered correctly <firstProduct> is first")
    public void theProductsAreOrderedCorrectlyFirstProductIsFirst() {
    }


}
