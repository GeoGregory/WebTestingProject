package org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    private final By usernameField = By.ById("user-name");
    private final By passwordField = By.ById("password");
    private final By loginButton = By.ById("login-button");
    private final By errorMessageContainer = By.ByClassName("error-message-container");
    private final By errorMessageCloseButton = By.ByClassName("error-button");

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

    public void inputLogin(String usernameInput , String passwordInput) {
        driver.findElement(usernameField).sendKeys(usernameInput);
        driver.findElement(passwordField).sendKeys(passwordInput);
    }

    public Page clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public Page pressEnterKey() {
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
    }

    public Products quickLogin() {
        inputLogin(UserOptions.STANDARD, "secret_sauce");
        clickLoginButton();
        return new Products(driver);
    }

    public void getErrorMessage() {
        driver.findElement(errorMessageContainer).getText();
    }

    public void closeErrorMessage() {
        driver.findElement(errorMessageCloseButton).click();
    }

}
