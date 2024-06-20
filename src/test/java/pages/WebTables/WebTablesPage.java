package pages.WebTables;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import lazy.Lazy;
import pages.PageObject;

public class WebTablesPage extends PageObject {
    

    @Lazy
    @FindBy(xpath = "//h1[contains(text(),'Web Tables')]")
    public WebElement webTablesHeader;
    @Lazy
    @FindBy(id = "addNewRecordButton")
    public WebElement addBtn;
    @Lazy
    @FindBy(id = "searchBox")
    public WebElement searchField;
    @Lazy
    @FindBy(xpath = "//div[text()='First Name']")
    public WebElement firstNameColunmHeader;
    @Lazy
    @FindBy(xpath = "//div[text()='Last Name']")
    public WebElement lastNameColunmHeader;
    @Lazy
    @FindBy(xpath = "//div[text()='Age']")
    public WebElement ageColunmHeader;
    @Lazy
    @FindBy(xpath = "//div[text()='Salary']")
    public WebElement salaryColunmHeader;
    @Lazy
    @FindBy(xpath = "//div[text()='Email']")
    public WebElement emailColunmHeader;
    @Lazy
    @FindBy(xpath = "//div[text()='Department']")
    public WebElement departmentColunmHeader;
    @Lazy
    @FindBy(xpath = "//div[text()='Action']")
    public WebElement actionColunmHeader;
    @Lazy
    @FindBy(xpath = "//button[contains(text(),'Previous')]")
    public WebElement previousButton;
    @Lazy
    @FindBy(xpath = "//span[@class='-pageInfo']")
    public  WebElement pageField;
    @Lazy
    @FindBy(xpath = "//div[@class = '-pageJump']")
    public WebElement pageNumber;
    @Lazy
    @FindBy(xpath = "//span[@class = '-totalPages']")
    public WebElement totalPage;
    @Lazy
    @FindBy(xpath = "//span[@class = 'select-wrap -pageSizeOptions']")
    public WebElement rowPerPage;
    @Lazy
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement nextButton;
    @Lazy
    @FindBy(xpath = "//div[contains(text(),'No rows found')]")
    public WebElement noRowsFoundMessage;

    

    public WebTablesPage(WebDriver driver) {
        super(driver);
        this.getRecordRows();
    }

    public List<WebElement> getRecordRows() {
        return driver.findElements(By.xpath("//div[(contains(@class, 'rt-tr -even') or contains(@class, 'rt-tr -odd')) and .//div[contains(@class, 'rt-td') and .//div[contains(@class, 'action-buttons')]]]"));
    }

    public String getFirstName(WebElement row) {
        List<WebElement> fields = row.findElements(By.className("rt-td"));
        String firstName = fields.get(0).getText();
        return firstName;
    }


    public void verifyWebElementsDisplayed() {
        Assert.assertTrue(webTablesHeader.isDisplayed(), "Web Tables header is displayed");
        Assert.assertTrue(addBtn.isEnabled(), "Add button is displayed");
        Assert.assertTrue(searchField.isDisplayed(), "Search field is displayed");
        Assert.assertEquals(firstNameColunmHeader.getText(), "First Name");
        Assert.assertEquals(lastNameColunmHeader.getText(), "Last Name");
        Assert.assertEquals(ageColunmHeader.getText(), "Age");
        Assert.assertEquals(salaryColunmHeader.getText(), "Salary");
        Assert.assertEquals(emailColunmHeader.getText(), "Email");
        Assert.assertEquals(departmentColunmHeader.getText(), "Department");
        Assert.assertEquals(actionColunmHeader.getText(), "Action");

    }

    public void clickAddBtn() {
        addBtn.click();

    }
   
    
}
