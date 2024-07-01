package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {
    public static WebDriver getDriver() {
        Properties properties = PropertiesLoader.loadProperties("config.properties");
        String browser = properties.getProperty("browser");
        switch (browser) {
            case "chrome":
                String driverPath = properties.getProperty("webdriver.chrome.driver");
                System.setProperty("webdriver.chrome.driver", driverPath);
                return new ChromeDriver();

            default:
                throw new IllegalArgumentException("Property 'browser' hasn't set properly");

        }
    }

}
