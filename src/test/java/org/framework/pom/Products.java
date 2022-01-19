package test.java.org.framework.pom;

import io.cucumber.messages.types.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Products extends PageWithHeaderAndFooter{

    private final By PRODUCT;
    private List<WebElement> products;

    public Products(WebDriver driver) {
        super(driver);
        PRODUCT = new By.ByClassName("inventory_item");
        products = getAllProducts();
    }

    public List<WebElement> getAllProducts(){
        return new ArrayList<>(driver.findElements(PRODUCT));
    }

    public Product goToProductPage(int index){
        getButton(index).click();
        return new Product(driver);
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


}
