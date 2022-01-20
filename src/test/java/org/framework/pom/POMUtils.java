package org.framework.pom;

public class POMUtils {
    public static void setDriverLocation(String pathToDriver) {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
    }
}
