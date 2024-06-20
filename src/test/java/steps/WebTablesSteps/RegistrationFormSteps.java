package steps.WebTablesSteps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pages.WebTables.RegistrationForm;
import utils.WebDriverManager;

public class RegistrationFormSteps {


     @Then("I verify the display of the Registration Form")
    public void I_verify_the_display_of_the_Registration_Form() {

        WebDriverWait wait = new WebDriverWait(WebDriverManager.getDriver(), Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-form-modal")));

        RegistrationForm registrationForm = new RegistrationForm(WebDriverManager.getDriver());

        Assert.assertEquals(registrationForm.headerRegistrationForm.getText(),"Registration Form");
        Assert.assertTrue(registrationForm.firstName.isDisplayed());
        Assert.assertTrue(registrationForm.lastName.isDisplayed());
        Assert.assertTrue(registrationForm.age.isDisplayed());
        Assert.assertTrue(registrationForm.department.isDisplayed());
        Assert.assertTrue(registrationForm.salary.isDisplayed());
        Assert.assertTrue(registrationForm.lastName.isEnabled());

    }


}
