package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

import org.testng.Assert;
import lazy.Lazy;

public class UploadAndDownload extends PageObject {

    
 public UploadAndDownload(WebDriver driver) {
        super(driver);
    }

    @Lazy
    @FindBy (xpath = "//h1[contains(text(),'Upload and Download')]")
    public WebElement headerUploadAndDownLoad;


    @Lazy
    @FindBy (id = "downloadButton")
    public WebElement downloadBtn;


    @Lazy
    @FindBy (xpath =  "//label[contains(text(),'Select a file')]")
    public WebElement selectAFileString;

    @Lazy
    @FindBy (id = "uploadFile")
    public WebElement chooseFileBtn;

    public String downloadDir = System.getProperty("user.home") + "/Downloads";
    public String downloadedFileName = "sampleFile.jpeg"; // Replace with the actual file name


    public void verifyTheDisplayOfTheUploadAndDownLoadPage(){
        Assert.assertEquals(headerUploadAndDownLoad.getText(),"Upload and Download");
        Assert.assertTrue(downloadBtn.isDisplayed());
        Assert.assertEquals(selectAFileString.getText(),"Select a file");
        Assert.assertTrue(chooseFileBtn.isDisplayed());

    }

   








}
