package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait;

    public void clickMenuButton(String buttonCaption) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subMenu = driver.findElement(By.xpath("//span[contains(text(),'" + buttonCaption + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subMenu);
        wait.until(ExpectedConditions.elementToBeClickable(subMenu));
        subMenu.click();
    }

   
}
