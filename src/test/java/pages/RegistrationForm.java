package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lazy.Lazy;

public class RegistrationForm extends PageObject {

    public RegistrationForm(WebDriver driver) {
        super(driver);
    }

    @Lazy
    @FindBy (id = "registration-form-modal")
    public WebElement headerRegistrationForm;
    @Lazy
    @FindBy (id = "firstName")
    public WebElement firstName;
    @Lazy
    @FindBy (id = "lastName")
    public WebElement lastName;

    @Lazy
    @FindBy (id = "userEmail")
    public WebElement userEmail;

    @Lazy
    @FindBy (id = "age")
    public WebElement age;

    @Lazy
    @FindBy (id = "salary")
    public WebElement salary;

    @Lazy
    @FindBy (id = "department")
    public WebElement department;

    @Lazy
    @FindBy (id = "submit")
    public WebElement submitBtn;




}
