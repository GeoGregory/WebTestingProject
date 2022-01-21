package org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart extends PageWithHeaderAndFooter {

    private static final By checkoutButton = new By.ById("checkout");
    private static final By continueShoppingButton = new By.ById("continue-shopping");

    private static final By removeBikeLight = new By.ById("remove-sauce-labs-bike-light");
    private static final By removeBoltTShirt = new By.ById("remove-sauce-labs-bolt-t-shirt");
    private static final By removeOnesie = new By.ById("remove-sauce-labs-onesie");
    private static final By removeRedTShirt = new By.ById("remove-test.allthethings()-t-shirt-(red)");
    private static final By removeBackpack = new By.ById("remove-sauce-labs-backpack");
    private static final By removeFleece = new By.ById("remove-sauce-labs-fleece-jacket");

    private static final By findBikeLight = new By.ById("item_0_title_link");
    private static final By findBoltTShirt = new By.ById("item_1_title_link");
    private static final By findOnesie = new By.ById("item_2_title_link");
    private static final By findRedTShirt = new By.ById("item_3_title_link");
    private static final By findBackpack = new By.ById("item_4_title_link");
    private static final By findFleece = new By.ById("item_5_title_link");

    public enum Products {
        BIKE_LIGHT,
        BOLT_T_SHIRT,
        ONESIE,
        RED_T_SHIRT,
        BACKPACK,
        FLEECE,
    }

    public Cart(WebDriver driver) {
        super(driver);
    }

    public CheckoutYourInfo goToCheckout() {
        driver.findElement(checkoutButton).click();
        return new CheckoutYourInfo(driver);
    }

    public org.framework.pom.Products goToProducts() {
        driver.findElement(continueShoppingButton).click();
        return new org.framework.pom.Products(driver);
    }

    public void removeProduct(Products product) {
        switch (product) {
            case BIKE_LIGHT:
                driver.findElement(removeBikeLight).click();
                break;
            case BOLT_T_SHIRT:
                driver.findElement(removeBoltTShirt).click();
                break;
            case ONESIE:
                driver.findElement(removeOnesie).click();
                break;
            case RED_T_SHIRT:
                driver.findElement(removeRedTShirt).click();
                break;
            case BACKPACK:
                driver.findElement(removeBackpack).click();
                break;
            case FLEECE:
                driver.findElement(removeFleece).click();
                break;
        }
    }

    public void findProduct(Products product) {
        switch (product) {
            case BIKE_LIGHT:
                driver.findElement(findBikeLight);
                break;
            case BOLT_T_SHIRT:
                driver.findElement(findBoltTShirt);
                break;
            case ONESIE:
                driver.findElement(findOnesie);
                break;
            case RED_T_SHIRT:
                driver.findElement(findRedTShirt);
                break;
            case BACKPACK:
                driver.findElement(findBackpack);
                break;
            case FLEECE:
                driver.findElement(findFleece);
                break;
        }
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(By.className("cart_item"));
    }
}