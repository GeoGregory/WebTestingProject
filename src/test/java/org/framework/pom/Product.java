package test.java.org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Product extends PageWithHeaderAndFooter{

    private WebDriver driver;
    private final By productName = new By.ByClassName("inventory_details_name large_size");
    private final By productImage = new By.ByClassName("inventory_details_img");
    private final By productDescription = new By.ByClassName("inventory_details_desc large_size");
    private final By productPrice = new By.ByClassName("inventory_details_price");
    private By.ById addToCartButton = new By.ById("add-to-cart-sauce-labs-backpack");
    private By.ById removeToCartButton = new By.ById("remove-sauce-labs-backpack");
    private By.ById backToProductsButton = new By.ById("back-to-products");
    private String sProductName;
    private String sProductImage;
    private String sProductDescription;
    private String sProductPrice;

    public Product(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        sProductName = driver.findElement(productName).getText();
        sProductImage = driver.findElement(productImage).getAttribute("alt");
        sProductDescription = driver.findElement(productDescription).getText();
        sProductPrice = driver.findElement(productPrice).getText();
    }

    public String getsProductName() {
        return sProductName;
    }

    public String getsProductImage() {
        return sProductImage;
    }

    public String getsProductDescription() {
        return sProductDescription;
    }

    public String getsProductPrice() {
        return sProductPrice;
    }

    public void goToProducts() {
        //go to the products page
        driver.findElement(backToProductsButton).click();
    }

    public void toggleAddOrRemoveToCart() {
        int originalCartCount = getCartCount();
        if(driver.findElement(addToCartButton).isEnabled()) {
            driver.findElement(removeToCartButton).click();
            //decrement the counter on cart to the cart icon
        } else {
            driver.findElement(addToCartButton).click();
            //increment counter on the cart to the cart icon
        }

        if (originalCartCount != getCartCount()) {
            //cart count has successfully updated
            System.out.println("Success");
        } else {
            //cart count has not updated. Display error message.
            System.out.println("Fail cart count not updated");
        }

    }

}
