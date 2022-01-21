package org.cucumber.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.Enums.UserOptions;
import org.framework.pom.LoginPage;
import org.framework.pom.Products;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeadersFootersStepdefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products products;
    private Integer cartNum;
    private String externalURL;

    @Given("I am on a page with a header and footer")
    public void iAmOnAPageWithAHeaderAndFooter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        products = loginPage.quickLogin(UserOptions.STANDARD);
    }

    @When("I click on the burger menu")
    public void iClickOnTheBurgerMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @Then("The burger menu with display its elements")
    public void theBurgerMenuWithDisplayItsElements() {
        String firstElementOnList = driver.findElement(By.className("bm-menu")).findElement(By.xpath("//a[@id='inventory_sidebar_link']")).getText();
        assertEquals("ALL ITEMS", firstElementOnList);
    }

    @When("I click the twitter icon")
    public void iClickTheTwitterIcon() {
        externalURL = products.getTwitter();
    }

    @Then("I wll be taken to the Swag twitter")
    public void iWllBeTakenToTheSwagTwitter() {
        assertEquals("https://twitter.com/saucelabs", externalURL);
    }


    @When("I click the facebook icon")
    public void iClickTheFacebookIcon() {
        driver.findElement(By.linkText("Facebook")).click();
    }

    @Then("I wll be taken to the Swag facebook")
    public void iWllBeTakenToTheSwagFacebook() {
        assertEquals("https://www.facebook.com/saucelabs", products.getFacebook());
    }

    @When("I click the linkedin icon")
    public void iClickTheLinkedinIcon() {
        driver.findElement(By.linkText("LinkedIn")).click();
    }

    @Then("I wll be taken to the Swag linkedin")
    public void iWllBeTakenToTheSwagLinkedin() {
        assertEquals("https://www.linkedin.com/company/sauce-labs/", products.getLinkedIn());
    }

    @When("I have an item in my basket")
    public void iHaveAnItemInMyBasket() {
        products.toggleAddOrRemoveToCart(products.getAddBackpackButton(), products.getRemoveBackpackButton());
        cartNum = products.getCartCount();
    }

    @And("I log out")
    public void iLogOut() {
        iClickOnTheBurgerMenu();
        driver.findElement(By.className("bm-menu"))
                .findElement(By.id("logout_sidebar_link")).click();

    }

    @And("I log back in again")
    public void iLogBackInAgain() {
        products = loginPage.quickLogin(UserOptions.STANDARD);
    }

    @Then("My cart will be the same as it was")
    public void myCartWillBeTheSameAsItWas() {
        assertEquals(cartNum, products.getCartCount());
    }

    @Given("I have opened the burger menu")
    public void iHaveOpenedTheBurgerMenu() {
        iClickOnTheBurgerMenu();
    }

    @When("I click on the all items link")
    public void iClickOnTheAllItemsLink() {
        driver.findElement(By.className("bm-menu"))
                .findElement(By.id("inventory_sidebar_link")).click();
    }

    @Then("I will be taken to the all items page")
    public void iWillBeTakenToTheAllItemsPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", products.getURL());
    }

    @When("I click on the about link")
    public void iClickOnTheAboutLink() {
        driver.findElement(By.className("bm-menu"))
                .findElement(By.id("about_sidebar_link")).click();
    }

    @Then("I will be taken to the about page")
    public void iWillBeTakenToTheAboutPage() {
        Assertions.assertEquals("https://saucelabs.com/", products.getURL());
    }

    @When("I click on the logout link")
    public void iClickOnTheLogoutLink() {
        driver.findElement(By.className("bm-menu"))
                .findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("I will be taken to the login page")
    public void iWillBeTakenToTheLoginPage() {
        Assertions.assertEquals("https://www.saucedemo.com/", products.getURL());
    }

    @Then("the trolley icon will display the number of items in the basket")
    public void theTrolleyIconWillDisplayTheNumberOfItemsInTheBasket() {
        Assertions.assertEquals(1, cartNum);
    }

    @And("I add a product to the cart")
    public void iAddAProductToTheCart() {
    }

    @Then("the trolley icon will increment")
    public void theTrolleyIconWillIncrement() {
    }

    @And("I remove a product from the cart")
    public void iRemoveAProductFromTheCart() {
    }

    @Then("the trolley icon will decrement")
    public void theTrolleyIconWillDecrement() {
    }
}
