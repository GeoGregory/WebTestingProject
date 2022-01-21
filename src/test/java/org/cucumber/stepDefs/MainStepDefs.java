package org.cucumber.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.*;
import org.framework.pom.Enums.UserOptions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products products;
    private Cart cart;
    private CheckoutYourInfo yourInfo;
    private CheckoutOverview overview;
    private CheckoutComplete finish;

    private String username;
    private String password;
    private long duration;
    private String externalURL;
    private Integer cartNum;

    @After
    public void tearDown() {
        driver.quit();
    }

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
    

    @Given("I am logged in and on the cart page with the backpack added")
    public void iAmLoggedInAndOnTheCartPageWithTheBackpackAdded() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        products = loginPage.quickLogin(UserOptions.STANDARD);
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
        yourInfo = cart.goToCheckout();
    }

    @Then("I should be taken to a page to enter my details")
    public void iShouldBeTakenToAPageToEnterMyDetails() {
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", yourInfo.getURL());
    }

    @When("I click the CONTINUE SHOPPING button")
    public void iClickTheCONTINUESHOPPINGButton() {
        products = cart.goToProducts();
    }

    @Then("I should be taken to the main products page")
    public void iShouldBeTakenToTheMainProductsPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("The burger menu will display its elements")
    public void theBurgerMenuWillDisplayItsElements() {
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
        externalURL = products.getFacebook();
    }

    @Then("I wll be taken to the Swag facebook")
    public void iWllBeTakenToTheSwagFacebook() {
        assertEquals("https://www.facebook.com/saucelabs", externalURL);
    }

    @When("I click the linkedin icon")
    public void iClickTheLinkedinIcon() {
        externalURL = products.getLinkedIn();
    }

    @Then("I wll be taken to the Swag linkedin")
    public void iWllBeTakenToTheSwagLinkedin() {
        assertEquals(true, externalURL.contains("linkedin.com"));
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

    @Given("I have a valid username and password")
    public void iHaveAValidUsernameAndPassword() {
        username = UserOptions.STANDARD.getUserOption();
        password = "secret_sauce";
    }

    @Then("I should be logged in and moved to the main page")
    public void iShouldBeLoggedInAndMovedToTheMainPage() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Given("that my username or password are invalid")
    public void thatMyUsernameOrPasswordAreInvalid() {
        username = "PavleIsTheBestCoder";
        password = "LouisIsTheBestCoder";
    }

    @Then("an error should be displayed letting me know the username or password are invalid")
    public void anErrorShouldBeDisplayedLettingMeKnowTheUsernameAndOrPasswordAreInvalid() {
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }

    @When("I leave the username field blank")
    public void iLeaveTheUsernameFieldBlank() {
        loginPage.inputLoginFields(username,"");
    }

    @Then("an error should be displayed letting me know what fields I didn't fill out")
    public void anErrorShouldBeDisplayedLettingMeKnowWhatFieldsIDidnTFillOut() {
        Assertions.assertEquals(true, loginPage.getErrorMessage().contains("is required"));
    }

    @When("I leave the password field blank")
    public void iLeaveThePasswordFieldBlank() {
        loginPage.inputLoginFields("",password);
    }

    @Given("that I trigger an error message")
    public void thatITriggerAnErrorMessage() {
        loginPage.clickLoginButton();
    }

    @When("I click the x on the error message")
    public void iClickTheXOnTheErrorMessage() {
        loginPage.clickErrorCloseButton();
    }

    @Then("the error message should go away")
    public void theErrorMessageShouldGoAway() {
        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertEquals("", errorMessage);
    }

    @When("I type both in")
    public void iTypeBothIn() {
        loginPage.inputLoginFields(username, password);
    }

    @And("press login")
    public void pressLogin() {
        loginPage.clickLoginButton();
    }

    @And("press enter")
    public void pressEnter() {
        loginPage.pressEnter();
    }

    @Given("I have a locked out username and password")
    public void iHaveALockedOutUsernameAndPassword() {
        username = UserOptions.LOCKED_OUT.getUserOption();
        password = "secret_sauce";
    }

    @Then("an error should be displayed letting me know I am locked out")
    public void anErrorShouldBeDisplayedLettingMeKnowIAmLockedOut() {
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
    }

    @When("I try to log in")
    public void iTryToLogIn() {
        iTypeBothIn();
        pressEnter();
    }

    @Given("I have a performance glitched username and password")
    public void iHaveAPerformanceGlitchedUsernameAndPassword() {
        username = UserOptions.PERFORMANCE.getUserOption();
        password = "secret_sauce";
    }

    @When("I time my log in")
    public void iTimeMyLogIn() {
        long startTime = System.nanoTime();
        iTypeBothIn();
        pressEnter();
        long endTime = System.nanoTime();

        duration = (endTime - startTime);
    }

    @Then("it should take longer than a normal login")
    public void itShouldTakeLongerThanANormalLogin() {
        long glitchedDuration = duration;
        loginPage = new LoginPage(driver);
        iHaveAValidUsernameAndPassword();
        iTimeMyLogIn();
        long standardDuration = duration;
        long bufferTime = 1000000000L;
        Assertions.assertEquals(true,glitchedDuration > (standardDuration + bufferTime));
    }

    @Given("I log in with Bernie's username and password")
    public void iLogInWithBernieSUsernameAndPassword() {
        username = "Bernie 1982";
        password = "Hunter2";
    }


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }
}
