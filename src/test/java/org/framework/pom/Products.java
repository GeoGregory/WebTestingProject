package org.framework.pom;

import org.cucumber.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Products extends PageWithHeaderAndFooter {

    private static final long SECONDS = 5;
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
        //Declare and initialise a fluent wait
        FluentWait wait = new FluentWait(driver);
//Specify the timout of the wait
        wait.withTimeout(Duration.ofSeconds(5));
//Sepcify polling time
        wait.pollingEvery(Duration.ofSeconds(1));
//Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);
//This is how we specify the condition to wait on.
//This is what we will explore more in this chapter
        By xPath = new By.ByXPath("//a[@id='item_"+ index +"_title_link']/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(xPath));
        return wait.until((name) -> products.get(index).findElement(xPath).getText()).toString();
        //return products.get(index).findElement(xPath).getText();
        //driver.findElement(By.xpath("//option[@value='az']")).click();
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

    public boolean isCorrect(boolean isCorrect, int i) {
        if (!(CSVReader.getProducts()[i].contains(getProductName(i)))) {
            isCorrect = false;
        }
        return isCorrect;
    }

    public void checkSortOptions(String options) {

        driver.findElement(By.className("product_sort_container")).click();
        if (options.equals("Name (A to Z)")) {
            driver.findElement(By.xpath("//option[@value='az']")).click();
        }
        if (options.equals("Name (Z to A)")) {
            driver.findElement(By.xpath("//option[@value='za']")).click();
        }
        if (options.equals("Price (low to high)")) {
            driver.findElement(By.xpath("//option[@value='lohi']")).click();
        }
        if (options.equals("Price (high to low)")) {
            driver.findElement(By.xpath("//option[@value='hilo']")).click();
        }

    }

    public boolean getFirstProductOnThePage(String compareFirstProductName) {
        String firstProductNameOnPage = driver.findElement(By.className("inventory_item_name")).getText();
        if (compareFirstProductName.equals(firstProductNameOnPage)) {
            return true;
        }
        return false;
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



















//    public void sortBy(SortOptions sortOptions) {
//        driver.findElement(By.className("product_sort_container")).click();
//
//        switch(sortOptions) {
//            case A_TO_Z:
//                driver.findElement(By.xpath("//option[@value='az']")).click();
//
//            case Z_TO_A:
//                driver.findElement(By.xpath("//option[@value='za']")).click();
//
//            case LOW_TO_HIGH:
//                driver.findElement(By.xpath("//option[@value='lohi']")).click();
//
//            case HIGH_TO_LOW:
//                driver.findElement(By.xpath("//option[@value='hilo']")).click();
//
//            default:
//                driver.findElement(By.xpath("//option[@value='az']")).click();
//        }
//    }