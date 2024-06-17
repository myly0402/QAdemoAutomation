package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.WebDriverManager;

public class HomePageSteps {
    WebDriver driver;
      
    
    @When("I go to the Elements page")
    public void I_go_to_the_Elements_page() {
       driver = WebDriverManager.getDriver();
       driver.manage().window().maximize();
       driver.get("https://demoqa.com/elements");
    }


    @Then("I click on the {string} submenu")
    public void I_click_on_the_submenu(String buttonCaption) {
        HomePage homePage = new HomePage(driver);
        homePage.clickButton(buttonCaption);
    }











}
