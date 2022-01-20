package org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.org.framework.pom.exceptions.IdNotFoundException;

import java.util.List;

public class Cart extends PageWithHeaderAndFooter {

    private static final By checkoutButton = new By.ById("checkout");
    private static final By continueShoppingButton = new By.ById("continue-shopping");

    private static final By removeBikeLight = new By.ById("remove-sauce-labs-bike-light");
    private static final By removeBoltTShirt = new By.ById("remove-sauce-labs-bolt-t-shirt");
    private static final By removeOnesie = new By.ById("remove-sauce-labs-onesie");
    private static final By removeRedTshirt = new By.ById("remove-test.allthethings()-t-shirt-(red)");
    private static final By removeBackpack = new By.ById("remove-sauce-labs-backpack");
    private static final By removeFleece = new By.ById("remove-sauce-labs-fleece-jacket");

    public enum products{
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

    public void goToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void goToProducts() {
        driver.findElement(continueShoppingButton).click();
    }

    public void removeProduct(products product) {
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
                driver.findElement(removeRedTshirt).click();
                break;
            case BACKPACK:
                driver.findElement(removeBackpack).click();
                break;
            case FLEECE:
                driver.findElement(removeFleece).click();
                break;
        }
    }

    public void removeProduct(int id) throws IdNotFoundException {
        switch (id) {
            case 0:
                driver.findElement(removeBikeLight).click();
                break;
            case 1:
                driver.findElement(removeBoltTShirt).click();
                break;
            case 2:
                driver.findElement(removeOnesie).click();
                break;
            case 3:
                driver.findElement(removeRedTshirt).click();
                break;
            case 4:
                driver.findElement(removeBackpack).click();
                break;
            case 5:
                driver.findElement(removeFleece).click();
                break;
            default: throw new IdNotFoundException();
        }
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(By.className("inventory_item"));
    }
}
