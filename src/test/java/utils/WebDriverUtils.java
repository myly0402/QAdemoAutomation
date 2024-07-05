package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverUtils {
    public static WebDriver getDriver() {
        Properties properties = PropertiesLoader.loadProperties("config.properties");
        String browser = properties.getProperty("browser");
        String driverPath;
        switch (browser) {

            case "chrome":
                driverPath = properties.getProperty("webdriver.chrome.driver");
                System.setProperty("webdriver.chrome.driver", driverPath);
                return new ChromeDriver();
            case "edge":
                driverPath = properties.getProperty("webdriver.edge.driver");
                System.setProperty("webdriver.edge.driver", driverPath);
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Property 'browser' hasn't set properly");

        }
    }

}
