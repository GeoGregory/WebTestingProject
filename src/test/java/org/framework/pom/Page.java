package test.java.org.framework.pom;

import org.openqa.selenium.WebDriver;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
