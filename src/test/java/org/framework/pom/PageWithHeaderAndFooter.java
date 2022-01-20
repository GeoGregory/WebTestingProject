package test.java.org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.org.framework.pom.Enums.BurgerLinks;

public abstract class PageWithHeaderAndFooter extends Page{

    protected By cart;

    public PageWithHeaderAndFooter(WebDriver driver) {
        super(driver);
        cart = new By.ByClassName("shopping_cart_link");
    }

    public String getTwitter(){
        return "https://twitter.com/saucelabs";
    }

    public String getFacebook(){
        return "https://www.facebook.com/saucelabs";
    }

    public String getLinkedIn(){
        return "https://www.linkedin.com/company/sauce-labs/";
    }

    public Cart goToCart() {
        driver.findElement(cart).click();
        return new Cart(driver);
    }

    public Page goToBurgerLink(BurgerLinks burgerLink){
        switch(burgerLink) {
            case BurgerLinks.ALL_ITEMS:
                driver.get("https://www.saucedemo.com/inventory.html");
                return new Products(driver);
                break;

            case BurgerLinks.ABOUT:
                driver.get("https://saucelabs.com/");
                return null;
            break;

            case BurgerLinks.LOGOUT:
                driver.get("https://www.saucedemo.com/");
                return new Login(driver);
            break;

            case BurgerLinks.RESET_APP_STATE:
                driver.get(driver.getCurrentUrl());
                return this;
            break;

            default: return null;
        }
    }
}
