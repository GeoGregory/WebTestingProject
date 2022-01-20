package org.framework.pom;

import org.framework.pom.Enums.UserOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends Page {
    private final By usernameField = new By.ById("user-name");
    private final By passwordField = new By.ById("password");
    private final By loginButton = new By.ById("login-button");
    private final By errorMessageContainer = new By.ByClassName("error-message-container");
    private final By errorMessageCloseButton = new By.ByClassName("error-button");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.saucedemo.com");
    }

    public void clickUsernameField() {
        driver.findElement(usernameField).click();
    }

    public void clickPasswordField() {
        driver.findElement(passwordField).click();
    }

    public Page clickLoginButton() {
        driver.findElement(loginButton).click();
        return getPage();
    }

    public Page pressEnter() {
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
        return getPage();
    }

    public void clickErrorCloseButton() {
        driver.findElement(errorMessageCloseButton).click();
    }

    public void inputLoginFields(String usernameInput , String passwordInput) {
        driver.findElement(usernameField).sendKeys(usernameInput);
        driver.findElement(passwordField).sendKeys(passwordInput);
    }

    public Page loginWithClick(String usernameInput , String passwordInput) {
        inputLoginFields(usernameInput, passwordInput);
        driver.findElement(loginButton).click();
        return getPage();
    }

    public Page loginWithEnter(String usernameInput , String passwordInput) {
        inputLoginFields(usernameInput, passwordInput);
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
        return getPage();
    }

    public Products quickLogin() {
        inputLoginFields(UserOptions.STANDARD.getUserOption(), "secret_sauce");
        clickLoginButton();
        return new Products(driver);
    }

    public String getErrorMessage() {
        List<WebElement> errorMessageList = driver.findElements(errorMessageContainer);
        if (errorMessageList.size() != 0){
            return driver.findElement(errorMessageContainer).getText();
        } else {
            return "";
        }
    }

    private Page getPage() {
        if (loginHasHappened()){
            return new Products(driver);
        } else {
            return new LoginPage(driver);
        }
    }

    private boolean loginHasHappened() {
        List<WebElement> loginButtonList = driver.findElements(loginButton);
        return loginButtonList.size() == 0;
    }
}
