package org.framework.pom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.org.framework.pom.Enums.BurgerLinks;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class PageWithHeaderAndFooter extends Page{

    protected By cart;
    protected By cartCount;
    private final By twitterLink = new By.ByClassName("social_twitter");
    private final By facebookLink = new By.ByClassName("social_facebook");
    private final By linkedInLink = new By.ByClassName("social_linkedin");


    public PageWithHeaderAndFooter(WebDriver driver) {
        super(driver);
        cart = new By.ByClassName("shopping_cart_link");
        cartCount = new By.ByClassName("shopping_cart_badge");
    }

    public String getTwitter(){
        return getNewTabURL(driver.findElement(twitterLink));
    }

    public String getFacebook(){
        return getNewTabURL(driver.findElement(facebookLink));
    }

    public String getLinkedIn(){
        return getNewTabURL(driver.findElement(linkedInLink));
    }

    public Cart goToCart() {
        driver.findElement(cart).click();
        return new Cart(driver);
    }

    public int getCartCount(){
        return Integer.parseInt(driver.findElement(cartCount).getText());
    }

    public Page goToBurgerLink(BurgerLinks burgerLink){
        switch(burgerLink) {
            case ALL_ITEMS:
                driver.get("https://www.saucedemo.com/inventory.html");
                return new Products(driver);

            case ABOUT:
                driver.get("https://saucelabs.com/");
                return null;

            case LOGOUT:
                driver.get("https://www.saucedemo.com/");
                return new LoginPage(driver);

            case RESET_APP_STATE:
                driver.get(driver.getCurrentUrl());
                return this;

            default: return null;
        }
    }

    private String getNewTabURL(WebElement externalLink){
        String originalTab = driver.getWindowHandle();
        externalLink.click();
        Set<String> handles = driver.getWindowHandles();

        for (String tab: handles){
            if (!originalTab.equals(tab)){
                driver.switchTo().window(tab);
                break;
            }
        }

        String externalURL = driver.getCurrentUrl();

        driver.switchTo().window(originalTab);

        return externalURL;
    }
}
