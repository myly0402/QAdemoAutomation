package pages.Droppable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lazy.Lazy;
import pages.PageObject;

public class Droppable extends PageObject {


    public Droppable(WebDriver driver) {
        super(driver);

    }

    @Lazy
    @FindBy(xpath = "//h1[text() = 'Droppable']")
    public WebElement droppableHeader;

    @Lazy
    @FindBy(id = "droppableExample-tab-simple")
    public WebElement simpleTab;

    @FindBy(xpath = "//div[@id='simpleDropContainer']//div[@id='draggable']")
    public WebElement simpleDragContainer;

    @FindBy(xpath = "//div[@id='simpleDropContainer']//div[@id='droppable']")
    public WebElement simpleDropContainer;

    @FindBy(id = "droppableExample-tab-accept")
    public WebElement acceptTab;

    @FindBy(xpath = "//div[@id='acceptable']")
    public WebElement acceptableDragContainer;

    @FindBy(id = "notAcceptable")
    public WebElement notAcceptableDragContainer;

    @FindBy(xpath = "//div[@id='acceptDropContainer']//div[@id='droppable']")
    public WebElement acceptableDropContainer;

   
    @FindBy (id= "dragBox")
    public WebElement preventPropogationDragContainer ;
   
   
    @FindBy (id= "notGreedyInnerDropBox")
    public WebElement preventPropogationNotGreedyInnerDropContainer ;
   
   
    @FindBy (xpath = "//div[@id = 'notGreedyDropBox']//p[contains(text(),'Outer droppable')or  contains (text(), 'Dropped!')]")
    public WebElement preventPropogationnotGreedyOuterDropContainer ;
   
    
    @FindBy (xpath = "//div[@id = 'greedyDropBox']//p[contains(text(),'Outer droppable') or contains (text(), 'Dropped!')]")
    public WebElement preventPropogationGreedyOuterDropContainer ;
   
   
    @FindBy (id= "greedyDropBoxInner")
    public WebElement preventPropogationGreedyInnerDropContainer ;

    @FindBy(id = "droppableExample-tab-revertable")
    public WebElement revertableTab;

    @FindBy(id = "revertable")
    public WebElement revertableDragContainer;

    @FindBy(id = "notRevertable")
    public WebElement notRevertableDragContainer;

    @FindBy(xpath = "//div[@id='revertableDropContainer']//div[@id='droppable']")
    public WebElement revertableDropContainer;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public Point revertablePosition;

    public Point nonrevertablePosition;

    public WebElement dropContainer(String tab) {
        WebElement dropContainer = driver
                .findElement(By.xpath("//div[@id='" + tab + "DropContainer']//div[@id='droppable']"));
        return dropContainer;

    }

    public void clickTab(String tabName) {

        WebElement tab = driver.findElement(By.id("droppableExample-tab-" + tabName));
        wait.until(ExpectedConditions.elementToBeClickable(tab));
        tab.click();
    }


    public void storeInitialPositionOfDraggales() {
        revertablePosition = revertableDragContainer.getLocation();
        nonrevertablePosition = notRevertableDragContainer.getLocation();
    }

  

}
