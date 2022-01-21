package org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInfo extends PageWithHeaderAndFooter {

    private final By cancelButton = new By.ById("cancel");
    private final By continueButton = new By.ById("continue");
    private final By errorMessage = new By.ByXPath("//h3[contains(.,'Error')]");

    public CheckoutYourInfo(WebDriver driver) {
        super(driver);
    }

    public String getTextField(TextFields textField){
        return driver.findElement(textField.field).getText();
    }

    public void setTextField(TextFields textFields, String text){
        driver.findElement(textFields.field).sendKeys(text);
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public CheckoutOverview goToCheckoutOverview(){
        driver.findElement(continueButton).click();
        return new CheckoutOverview(driver);
    }

    public Cart goToCartViaCancel(){
        driver.findElement(cancelButton).click();
        return new Cart(driver);
    }

    public enum TextFields{
        FIRSTNAME(new By.ById("first-name")),
        LASTNAME(new By.ById("last-name")),
        ZIPPOSTALCODE(new By.ById("postal-code"));

        private final By field;

        public By getBy(){return field;}

        TextFields(By field){
            this.field = field;
        }
    }

}
