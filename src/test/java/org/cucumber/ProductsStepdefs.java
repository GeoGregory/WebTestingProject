package test.java.org.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.java.org.framework.pom.IndividualProduct;
import test.java.org.framework.pom.LoginPage;
import test.java.org.framework.pom.Products;

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
    }

    @Given("that I am on the products page")
    public void thatIAmOnTheProductsPage() {
    }

    @When("I click on the add to cart button")
    public void iClickOnTheAddToCartButton() {
    }

    @Then("the cart icon is incremented and the button for that product changes to remove")
    public void theCartIconIsIncrementedAndTheButtonForThatProductChangesToRemove() {
    }

    @Given("that I am on the product page")
    public void thatIAmOnTheProductPage() {
    }

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
    }

    @When("I sort by <sortingMethods>")
    public void iSortBySortingMethods() {
    }

    @Then("The products are ordered correctly")
    public void theProductsAreOrderedCorrectly() {
    }

    @When("I click on a specific product")
    public void iClickOnASpecificProduct() {
    }

    @Then("I should go to \\{product page}")
    public void iShouldGoToProductPage() {
    }


}
