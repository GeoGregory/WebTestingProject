package test.java.org.cucumber.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.java.org.framework.pom.LoginPage;
import test.java.org.framework.pom.Products;

public class HeadersFootersStepdefs {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products products;

    @Given("I am on a page with a header and footer")
    public void iAmOnAPageWithAHeaderAndFooter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
//        loginPage.inputLoginFields("standard_user", "secret_sauce");
//        loginPage.clickLoginButton();

        products = loginPage.quickLogin();
    }

    @When("I click on the burger menu")
    public void iClickOnTheBurgerMenu() {
    }

    @Then("The burger menu with display its elements")
    public void theBurgerMenuWithDisplayItsElements() {
    }
}
