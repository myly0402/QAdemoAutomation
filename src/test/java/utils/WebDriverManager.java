package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private static WebDriver driver;

    private WebDriverManager() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = WebDriverUtils.getDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void resetDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();  // Clear cookies to simulate a new session
        }
    }
}