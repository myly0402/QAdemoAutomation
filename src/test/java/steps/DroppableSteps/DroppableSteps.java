package steps.DroppableSteps;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Droppable.Droppable;
import utils.WebDriverManager;

public class DroppableSteps {

    Droppable droppable = new Droppable(WebDriverManager.getDriver());
    Actions action = new Actions(WebDriverManager.getDriver());

    @When("I tab on {string} tab")
    public void I_tab_on_tab(String tabName) {
        droppable.waitElemtToVisible(droppable.droppableHeader, 10);
        droppable.clickTab(tabName);
    }

    @When("I drag the Drag me container to the Drop here container")
    public void I_drag_the_Drag_me_container_to_the_Drop_here_container() {
        // action = new Actions(WebDriverManager.getDriver());
        action.dragAndDrop(droppable.simpleDragContainer, droppable.simpleDropContainer).build().perform();

    }

    @When("I drag the Acceptable container to the Drop here container")
    public void I_drag_the_Acceptable_container_to_the_Drop_here_container() throws InterruptedException {
        Thread.sleep(1000);
        action.dragAndDrop(droppable.acceptableDragContainer, droppable.acceptableDropContainer).build().perform();
    }


    @Then("I verify the header of Drop here container on the {string} tab changed to Dropped!")
    public void I_verify_the_header_of_Drop_here_container_on_the_tab_changed_to_Dropped(String tab) {
        Assert.assertEquals(droppable.dropContainer(tab).getText(), "Dropped!");
    }

    @When("I drag the Not Acceptable container to the Drop here container")
    public void I_drag_the_Not_Acceptable_container_to_the_Drop_here_container() throws InterruptedException {
       action.dragAndDrop(droppable.notAcceptableDragContainer, droppable.acceptableDropContainer).build().perform();
    }

    @Then("I verify the header of Drop here container still the same.")
    public void I_verify_the_header_of_Drop_here_container_still_the_same() {
        Assert.assertEquals(droppable.acceptableDropContainer.getText(),"Drop here");

    }
   
}
