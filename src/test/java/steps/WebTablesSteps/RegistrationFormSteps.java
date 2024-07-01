package steps.WebTablesSteps;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebTables.RegistrationForm;
import utils.PropertiesLoader;
import utils.WebDriverManager;

public class RegistrationFormSteps {
    RegistrationForm registrationForm = new RegistrationForm(WebDriverManager.getDriver());

    @Then("I verify the display of the Registration Form")
    public void I_verify_the_display_of_the_Registration_Form() {

        WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-form-modal")));

        RegistrationForm registrationForm = new RegistrationForm(WebDriverManager.getDriver());

        Assert.assertEquals(registrationForm.headerRegistrationForm.getText(), "Registration Form");
        Assert.assertTrue(registrationForm.firstName.isDisplayed());
        Assert.assertTrue(registrationForm.lastName.isDisplayed());
        Assert.assertTrue(registrationForm.age.isDisplayed());
        Assert.assertTrue(registrationForm.department.isDisplayed());
        Assert.assertTrue(registrationForm.salary.isDisplayed());
        Assert.assertTrue(registrationForm.lastName.isEnabled());
    }

    @When("I add all the valid information and click on the Submit button")
    public void I_add_all_the_valid_information_and_click_on_the_Submit_button() {

        Properties properties = PropertiesLoader.loadProperties("config.properties");
        registrationForm.waitElemtToVisible(registrationForm.headerRegistrationForm, 5);
        registrationForm.firstName.sendKeys(properties.getProperty("firstName"));
        registrationForm.lastName.sendKeys(properties.getProperty("lastName"));
        registrationForm.age.sendKeys(properties.getProperty("age"));
        registrationForm.userEmail.sendKeys(properties.getProperty("email"));
        registrationForm.salary.sendKeys(properties.getProperty("salary"));
        registrationForm.department.sendKeys(properties.getProperty("department"));
        registrationForm.submitBtn.click();

    }

    @When("I enter information but left one of {string}, {string}, {string},{string},{string}, and {string} missing.")
    public void I_enter_information_but_left_one_of_and_missing(String firstName, String lastName, String email,String age,String salary,String department) {
        registrationForm.waitElemtToVisible(registrationForm.headerRegistrationForm, 5);
        registrationForm.firstName.sendKeys(firstName);
        registrationForm.lastName.sendKeys(lastName);
        registrationForm.age.sendKeys(age);
        registrationForm.userEmail.sendKeys(email);
        registrationForm.salary.sendKeys(salary);
        registrationForm.department.sendKeys(department);
        registrationForm.submitBtn.click();
    }


    @Then("I verify user is still in the Registration form.")
    public void I_verify_user_is_still_in_the_Registration_form() {
       Assert.assertEquals(registrationForm.headerRegistrationForm.getText(),"Registration Form");
    }

   

}
