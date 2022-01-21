package org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CheckoutComplete extends PageWithHeaderAndFooter {

    private By back = new By.ById("back-to-products");

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public Products goToPastPage(){
        driver.findElement(back).click();
        return new Products(driver);
    }

    public static class CheckoutOverview extends PageWithHeaderAndFooter{

        public CheckoutOverview(WebDriver driver) {
            super(driver);
        }

        private final By finish = new By.ById("finish");
        private final By cancel = new By.ById("cancel");
        private final By cartItems = new By.ByClassName("cart_items");
        private final By subTotal = new By.ByClassName("summary_subtotal_label");
        private final By tax = new By.ByClassName("summary_tax_label");
        private final By total = new By.ByClassName("summary_total_label");

        public CheckoutComplete goToFinish(){
            driver.findElement(finish).click();
            return new CheckoutComplete(driver);
        }
        public Products goToCancel(){
            driver.findElement(cancel).click();
            return new Products(driver);
        }

        public List<WebElement> getCartItems() {
            return driver.findElements(cartItems);
        }

        public String getSubtotal(){
            return driver.findElement(subTotal).getText();
        }

        public double getMoneyAsDouble(String value) {
            String amount[] = value.split(" ");
            return Double.parseDouble(amount[1].substring(1));
        }

        public double getSubtotalAsDouble(){
            String[] amount = getSubtotal().split(" ");
            return Double.parseDouble(amount[2].substring(1));
        }

        public String getTax(){
            return driver.findElement(tax).getText();
        }

        public String getTotal(){
            return driver.findElement(total).getText();
        }


    }
}
