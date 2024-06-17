package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebDriverManager;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Setting up scenario: " + scenario.getName());
        driver = WebDriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        // Check if scenario is failed
        if (scenario.isFailed()) {
            // Take screenshot and embed it in the report
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        // Quit WebDriver after each scenario
        WebDriverManager.quitDriver();
    }
}
