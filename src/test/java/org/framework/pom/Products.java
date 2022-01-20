package org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Products extends PageWithHeaderAndFooter {

    private final By PRODUCT;
    private final By addBackpackButton = new By.ById("add-to-cart-sauce-labs-backpack");
    private final By removeBackpackButton = new By.ById("remove-sauce-labs-backpack");
    private final By addBikeLightsButton = new By.ById("add-to-cart-sauce-labs-bike-light");
    private final By removeBikeLightsButton = new By.ById("remove-sauce-labs-bike-light");
    private final By addBoltTShirtButton = new By.ById("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By removeBoltTShirtButton = new By.ById("remove-sauce-labs-bolt-t-shirt");
    private final By addFleeceJacketButton = new By.ById("add-to-cart-sauce-labs-fleece-jacket");
    private final By removeFleeceJacketButton = new By.ById("remove-sauce-labs-fleece-jacket");
    private final By addOnesieButton = new By.ById("add-to-cart-sauce-labs-onesie");
    private final By removeOnsieButton = new By.ById("remove-sauce-labs-onesie");
    private final By addRedShirtButton = new By.ById("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By removeRedShirtButton = new By.ById("remove-test.allthethings()-t-shirt-(red)");
    private int originalCartCount = 0;
    private List<WebElement> products;

    public Products(WebDriver driver) {
        super(driver);
        PRODUCT = new By.ByClassName("inventory_item");
        products = getAllProducts();
    }

    public List<WebElement> getAllProducts(){
        return new ArrayList<>(driver.findElements(PRODUCT));
    }

    public IndividualProduct goToProductPage(int index){
        getButton(index).click();
        return new IndividualProduct(driver);
    }

    public String getProductName(int index){
        By className = new By.ByClassName("inventory_item_name");
        return products.get(index).findElement(className).getText();
    }

    public String getProductDesc(int index){
        By className = new By.ByClassName("inventory_item_desc");
        return products.get(index).findElement(className).getText();
    }

    public String getProductImg(int index){
        By className = new By.ByClassName("inventory_item_img");
        return products.get(index).findElement(className).getText();
    }

    public String getProductPrice(int index){
        By className = new By.ByClassName("inventory_item_price");
        return products.get(index).findElement(className).getText();
    }

    public WebElement getButton(int index){
        By className = new By.ByClassName("btn");
        return products.get(index).findElement(className);
    }

    public void toggleAddOrRemoveToCart(By addToCartButton, By removeToCartButton) {
        //originalCartCount = getCartCount();
        if(driver.findElement(addToCartButton).isEnabled()) {
            driver.findElement(addToCartButton).click();
            //decrement the counter on cart to the cart icon
        } else {
            driver.findElement(removeToCartButton).click();
            //increment counter on the cart to the cart icon
        }
        originalCartCount = getCartCount() - 1;
    }

    public By getAddBackpackButton() {
        return addBackpackButton;
    }

    public By getRemoveBackpackButton() {
        return removeBackpackButton;
    }

    public By getAddBikeLightsButton() {
        return addBikeLightsButton;
    }

    public By getRemoveBikeLightsButton() {
        return removeBikeLightsButton;
    }

    public By getAddBoltTShirtButton() {
        return addBoltTShirtButton;
    }

    public By getRemoveBoltTShirtButton() {
        return removeBoltTShirtButton;
    }

    public By getAddFleeceJacketButton() {
        return addFleeceJacketButton;
    }

    public By getRemoveFleeceJacketButton() {
        return removeFleeceJacketButton;
    }

    public By getAddOnesieButton() {
        return addOnesieButton;
    }

    public By getRemoveOnsieButton() {
        return removeOnsieButton;
    }

    public By getAddRedShirtButton() {
        return addRedShirtButton;
    }

    public By getRemoveRedShirtButton() {
        return removeRedShirtButton;
    }

    public int getOriginalCartCount() {
        return originalCartCount;
    }
}
