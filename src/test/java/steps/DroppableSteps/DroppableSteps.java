package steps.DroppableSteps;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.Point;
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

    Point innitialLocationOfWillRevertContainer = droppable.revertableDragContainer.getLocation();
    Point innitialLocationOfNotRevertContainer = droppable.notRevertableDragContainer.getLocation();

    @When("I tab on {string} tab")
    public void I_tab_on_tab(String tabName) {
        droppable.waitElemtToVisible(droppable.droppableHeader, 10);
        droppable.clickTab(tabName);
    }

    @When("I drag the Drag me container to the Drop here container")
    public void I_drag_the_Drag_me_container_to_the_Drop_here_container() {
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
        Assert.assertEquals(droppable.acceptableDropContainer.getText(), "Drop here");

    }

    @Then("I verify both headers of outer and inner drop container are changed to Dropped")
    public void I_verify_both_headers_of_outer_and_inner_drop_container_are_changed_to_Dropped() {
        Assert.assertEquals(droppable.preventPropogationNotGreedyInnerDropContainer.getText(), "Dropped!");
        Assert.assertEquals(droppable.preventPropogationnotGreedyOuterDropContainer.getText(), "Dropped!");
    }

    @When("I drag the Drag me container to the Inner droppable - not greedy container")
    public void I_drag_the_Drag_me_container_to_the_Inner_droppable_not_greedy_container() {
        action.dragAndDrop(droppable.preventPropogationDragContainer,
                droppable.preventPropogationNotGreedyInnerDropContainer).build().perform();
    }

    @Then("I verify the header of the outer container is Dropped! and the header of the inner container is no changed")
    public void I_verify_the_header_of_the_outer_container_is_Dropped_and_the_header_of_the_inner_container_is_no_changed() {

        Assert.assertEquals(droppable.preventPropogationNotGreedyInnerDropContainer.getText(),
                "Inner droppable (not greedy)");
        Assert.assertEquals(droppable.preventPropogationnotGreedyOuterDropContainer.getText(), "Dropped!");

    }

    @When("I drag the Drag me container to the Outer droppable - not greedy container")
    public void I_drag_the_Drag_me_container_to_the_Outer_droppable_not_greedy_container() {
        action.dragAndDrop(droppable.preventPropogationDragContainer,
                droppable.preventPropogationnotGreedyOuterDropContainer).build().perform();
    }

    @When("I drag the Drag me container to the Inner droppable - greedy container")
    public void I_drag_the_Drag_me_container_to_the_Inner_droppable_greedy_container() {
        action.dragAndDrop(droppable.preventPropogationDragContainer,
                droppable.preventPropogationGreedyInnerDropContainer).build().perform();
    }

    @Then("I verify the Greedy header of the inner container is Dropped! and the header of the outer container is no changed")
    public void I_verify_the_Greedy_header_of_the_inner_container_is_Dropped_and_the_header_of_the_outer_container_is_no_changed() {
        Assert.assertEquals(droppable.preventPropogationGreedyInnerDropContainer.getText(), "Dropped!");
        Assert.assertEquals(droppable.preventPropogationnotGreedyOuterDropContainer.getText(), "Outer droppable");
    }

    @When("I drag the Drag me container to the Outer droppable - greedy container")
    public void I_drag_the_Drag_me_container_to_the_Outer_droppable_greedy_container() {
        action.dragAndDrop(droppable.preventPropogationDragContainer,
                droppable.preventPropogationGreedyOuterDropContainer).build().perform();
    }

    @Then("I verify the Greedy header of the outer container is Dropped! and the header of the inner container is no changed")
    public void I_verify_the_Greedy_header_of_the_outer_container_is_Dropped_and_the_header_of_the_inner_container_is_no_changed() {

        Assert.assertEquals(droppable.preventPropogationGreedyInnerDropContainer.getText(), "Inner droppable (greedy)");
        Assert.assertEquals(droppable.preventPropogationnotGreedyOuterDropContainer.getText(), "Dropped!");

    }

    @When("I check the current position of Drag containers")
    public void I_check_the_current_position_of_Drag_containers() {
        droppable.storeInitialPositionOfDraggales();
    }

    @When("I drag the Will revert container to the Drop here container")
    public void I_drag_the_Will_revert_container_to_the_Drop_here_container() {
        action.dragAndDrop(droppable.revertableDragContainer, droppable.revertableDropContainer).build().perform();

    }

    @Then("I verify the header of the drop container is Dropped! and the Will revert container moves to the initial location.")
    public void I_verify_the_header_of_the_drop_container_is_Dropped_and_the_Will_revert_container_moves_to_the_initial_location()
            throws InterruptedException {

        Assert.assertEquals(droppable.revertableDropContainer.getText(), "Dropped!");
        Thread.sleep(2000);
        Assert.assertEquals(droppable.revertableDragContainer.getLocation(), droppable.revertablePosition);
    }

    @Then("I verify the header of the outer container is Dropped! and the Not revert container still in the Drop here container.")
    public void I_verify_the_header_of_the_outer_container_is_Dropped_and_the_Nott_container_still_in_the_Drop_here_container() {
        Assert.assertEquals(droppable.revertableDropContainer.getText(), "Dropped!");
        Assert.assertNotEquals(droppable.notRevertableDragContainer.getLocation(), droppable.nonrevertablePosition);
    }

    @When("I drag the Not revert container to the Drop here container")
    public void I_drag_the_Not_revert_container_to_the_Drop_here_container() {
        action.dragAndDrop(droppable.notRevertableDragContainer, droppable.revertableDropContainer).build().perform();
       

    }

    @Then("I verify the header of the outer greedy container is Dropped! and the header of the inner container is no changed")
    public void I_verify_the_header_of_the_outer_greedy_container_is_Dropped_and_the_header_of_the_inner_container_is_no_changed() {
        Assert.assertEquals(droppable.preventPropogationGreedyOuterDropContainer.getText(),"Dropped!");
        Assert.assertEquals(droppable.preventPropogationGreedyInnerDropContainer.getText(),"Inner droppable (greedy)");
    }

}
