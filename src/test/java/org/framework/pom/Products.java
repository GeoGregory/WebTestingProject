package test.java.org.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.java.org.framework.pom.Enums.SortOptions;

import java.util.ArrayList;
import java.util.List;

public class Products extends PageWithHeaderAndFooter {

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

    public void sortBy(SortOptions sortOptions) {
        driver.findElement(By.className("product_sort_container")).click();

        switch(sortOptions) {
            case A_TO_Z:
                driver.findElement(By.xpath("//option[@value='az']")).click();

            case Z_TO_A:
                driver.findElement(By.xpath("//option[@value='za']")).click();

            case LOW_TO_HIGH:
                driver.findElement(By.xpath("//option[@value='lohi']")).click();

            case HIGH_TO_LOW:
                driver.findElement(By.xpath("//option[@value='hilo']")).click();

            default:
                driver.findElement(By.xpath("//option[@value='az']")).click();
        }
    }
}
