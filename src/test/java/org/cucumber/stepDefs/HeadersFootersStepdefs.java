package org.cucumber.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.framework.pom.IndividualProduct;
import org.framework.pom.LoginPage;
import org.framework.pom.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeadersFootersStepdefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products productsPage;
    private IndividualProduct productPage;

    @Given("I am on a page with a header and footer")
    public void iAmOnAPageWithAHeaderAndFooter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productsPage = loginPage.quickLogin();
    }

    @When("I click on the burger menu")
    public void iClickOnTheBurgerMenu() {

    }

    @Then("The burger menu with display its elements")
    public void theBurgerMenuWithDisplayItsElements() {
        System.out.println("hi");
    }
}
