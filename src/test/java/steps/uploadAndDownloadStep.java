package steps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.sikuli.script.FindFailed;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UploadAndDownload;
import utils.WebDriverManager;
import org.sikuli.script.Screen;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class uploadAndDownloadStep {

    UploadAndDownload uploadAndDownload = new UploadAndDownload(WebDriverManager.getDriver());
    Screen screen;
 

    @Then("I verify the display of the Upload and Download page")
    public void I_verify_the_display_of_the_Upload_and_Download_Page(){
        uploadAndDownload.verifyTheDisplayOfTheUploadAndDownLoadPage();

    }

    @When("I tap on the download button")
    public void I_tap_on_the_download_button() {
        uploadAndDownload.downloadBtn.click();
    }

    @When("I click on save button on my computer")
    public void I_click_on_save_button_on_my_computer() throws FindFailed, AWTException {;
        Robot robot = new Robot();
        robot.setAutoDelay(1000);

        // Press Enter key to confirm the save operation
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Then("I verify the file is saved successfully")
    public void I_verify_the_file_is_saved_successfully() throws IOException {

        Path downloadedFilePath = Paths.get(uploadAndDownload.downloadDir, uploadAndDownload.downloadedFileName);
        Assert.assertTrue(Files.exists(downloadedFilePath), "File download failed!");

        // Optionally, clean up the downloaded file after verification
        if (Files.exists(downloadedFilePath)) {
            Files.delete(downloadedFilePath);
        }
    


    }
       






}
