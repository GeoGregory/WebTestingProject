package org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete extends PageWithHeaderAndFooter {
    WebDriver driver;
    private By back = new By.ById("back-to-products");

    public CheckoutComplete(WebDriver driver) {
        this.driver = driver;
    }

    public Products goToPastPage(){
        driver.findElement(back).click();
        return new Products(driver);
    }
}
