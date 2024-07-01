package pages.WebTables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class RegistrationForm extends PageObject {

    public RegistrationForm(WebDriver driver) {
        super(driver);
    }

    
    @FindBy (id = "registration-form-modal")
    public WebElement headerRegistrationForm;
    
    @FindBy (id = "firstName")
    public WebElement firstName;
    
    @FindBy (id = "lastName")
    public WebElement lastName;

    @FindBy (id = "userEmail")
    public WebElement userEmail;

    
    @FindBy (id = "age")
    public WebElement age;

   
    @FindBy (id = "salary")
    public WebElement salary;

 
    @FindBy (id = "department")
    public WebElement department;

    
    @FindBy (id = "submit")
    public WebElement submitBtn;

  




}
