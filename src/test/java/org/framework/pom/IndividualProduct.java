package org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class IndividualProduct extends PageWithHeaderAndFooter{

    private final By productName = new By.ByClassName("inventory_details_name large_size");
    private final By productImage = new By.ByClassName("inventory_details_img");
    private final By productDescription = new By.ByClassName("inventory_details_desc large_size");
    private final By productPrice = new By.ByClassName("inventory_details_price");
    //private final By addToCartButton = new By.ById("add-to-cart-sauce-labs-backpack");
    //private final By removeToCartButton = new By.ById("remove-sauce-labs-backpack");
    private final By addToCartButton = new By.ByClassName("btn");
    private final By removeToCartButton = new By.ByClassName("btn");
    private final By backToProductsButton = new By.ById("back-to-products");
    private int originalCartCount = 0;

    public IndividualProduct(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductImageName() {
        return driver.findElement(productImage).getAttribute("alt");
    }

    public String getProductDescription() {
        return driver.findElement(productDescription).getText();
    }

    public String getsProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public void goToProducts() {
        //go to the products page
        driver.findElement(backToProductsButton).click();
    }

    public void toggleSingleProductAddOrRemoveToCart() {

        try {
            if (driver.findElement(removeToCartButton).isEnabled()) {
                driver.findElement(removeToCartButton).click();
                //increment counter on the cart to the cart icon
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        try {
            if(driver.findElement(addToCartButton).isEnabled()) {
                driver.findElement(addToCartButton).click();
                //decrement the counter on cart to the cart icon
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        originalCartCount = getCartCount() - 1;

    }

    public int getOriginalCartCount() {
        return originalCartCount;
    }
}
