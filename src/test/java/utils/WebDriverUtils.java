package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {
    public static WebDriver getDriver() {
        String browser = System.getProperty("browser");
        switch (browser) {
            case "chrome":
                return new ChromeDriver();
        
            default:
                throw new IllegalArgumentException("Property 'browser' hasn't set properly");
                
        }
    }
}
