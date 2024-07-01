package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.WebDriverManager;

public class HomePageSteps {
    WebDriver driver;

    @Given("I go to the {string} page")
    public void I_go_to_the_page(String subMenu) {
        driver = WebDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/" + subMenu);
    }

    @Then("I click on the {string} submenu")
    public void I_click_on_the_submenu(String buttonCaption) {
        HomePage homePage = new HomePage(driver);
        homePage.clickMenuButton(buttonCaption);
    }

}
