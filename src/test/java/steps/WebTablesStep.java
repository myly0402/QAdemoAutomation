package steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebTablesPage;
import utils.WebDriverManager;

public class WebTablesStep {

    WebTablesPage webTablePage = new WebTablesPage(WebDriverManager.getDriver());

    @Then("I verify the display of the Web Tables view")
    public void I_verify_the_display_of_the_Web_Tables_view() {


        Assert.assertTrue(webTablePage.webTablesHeader.isDisplayed(), "Web Tables header is displayed");
        Assert.assertTrue(webTablePage.addBtn.isEnabled(), "Add button is displayed");
        Assert.assertTrue(webTablePage.searchField.isDisplayed(), "Search field is displayed");
        Assert.assertEquals(webTablePage.firstNameColunmHeader.getText(), "First Name");
        Assert.assertEquals(webTablePage.lastNameColunmHeader.getText(), "Last Name");
        Assert.assertEquals(webTablePage.ageColunmHeader.getText(), "Age");
        Assert.assertEquals(webTablePage.salaryColunmHeader.getText(), "Salary");
        Assert.assertEquals(webTablePage.emailColunmHeader.getText(), "Email");
        Assert.assertEquals(webTablePage.departmentColunmHeader.getText(), "Department");
        Assert.assertEquals(webTablePage.actionColunmHeader.getText(), "Action");

    }

    @When("I click on the Add button")
    public void I_click_on_the_Add_button() {
        webTablePage.addBtn.click();
    }

   

    @When("I input {string} key on the search space.")
    public void I_input_key_on_the_search_space(String s) {
        webTablePage.searchField.click();
        webTablePage.searchField.clear();
        webTablePage.searchField.sendKeys(s);
    }

    @Then("I verify the displaying message")
    public void I_verify_the_displaying_message() {
        webTablePage.waitElemtToVisible(webTablePage.noRowsFoundMessage,5);
        Assert.assertEquals(webTablePage.noRowsFoundMessage.getText(),"No rows found");
        

    }

    @Then("I verify the first names of all rows containing the {string}.")
    public void I_verify_the_first_names_of_all_rows_containing_the_search_key(String s){
        List <WebElement> result = webTablePage.getRecordRows();
    
       for (WebElement row : result){
       String firstName = webTablePage.getFirstName(row);
       Assert.assertTrue(firstName.contains(s), s + " not found on " + firstName);
        
        }
    }









}

  
   
  