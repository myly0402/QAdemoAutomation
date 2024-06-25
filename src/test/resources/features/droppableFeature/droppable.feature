Feature: Droppable

  Background:
    Given I go to the "interaction" page
    And I click on the "Droppable" submenu

  @Testing @TC08 @Interaction
  Scenario: I verify the droppable function on Simple tab
    When I tab on "simple" tab
    And I drag the Drag me container to the Drop here container
    Then I verify the header of Drop here container on the "simple" tab changed to Dropped!

  @Testing @TC09 @Interaction
  Scenario: I verify the droppable function on Accept tab using Acceptable container
    When I tab on "accept" tab
    And I drag the Acceptable container to the Drop here container
    Then I verify the header of Drop here container on the "accept" tab changed to Dropped!

  @Testing @TC10 @Interaction
  Scenario: I verify the droppable function on Accept tab using Not Acceptable container
    When I tab on "accept" tab
    And I drag the Not Acceptable container to the Drop here container
    Then I verify the header of Drop here container still the same.

  @Testing @TC11 @Interaction
  Scenario: I verify the droppable function on preventPropogation tab
    When I tab on "preventPropogation" tab
    And I drag the Drag me container to the Inner droppable - not greedy container
    Then I verify both headers of outer and inner drop container are changed to Dropped

  @Testing @TC12 @Interaction
  Scenario: I verify the droppable function on preventPropogation tab
    When I tab on "preventPropogation" tab
    And I drag the Drag me container to the Outer droppable - not greedy container
    Then I verify the header of the outer container is Dropped! and the header of the inner container is no changed

  @Testing @TC13 @Interaction
  Scenario: I verify the droppable function on preventPropogation tab
    When I tab on "preventPropogation" tab
    And I drag the Drag me container to the Inner droppable - greedy container
    Then I verify the Greedy header of the inner container is Dropped! and the header of the outer container is no changed

  @Testing @TC14 @Interaction
  Scenario: I verify the droppable function on preventPropogation tab
    When I tab on "preventPropogation" tab
    And I drag the Drag me container to the Outer droppable - greedy container
    Then I verify the header of the outer greedy container is Dropped! and the header of the inner container is no changed

  @Testing @TC15 @Interaction
  Scenario: I verify the droppable function on preventPropogation tab
    When I tab on "revertable" tab
    And I check the current position of Drag containers
    And I drag the Will revert container to the Drop here container
    Then I verify the header of the drop container is Dropped! and the Will revert container moves to the initial location.

  @Testing @TC16 @Interaction
  Scenario: I verify the droppable function on preventPropogation tab
    When I tab on "revertable" tab
    And I check the current position of Drag containers
    And I drag the Not revert container to the Drop here container
    Then I verify the header of the outer container is Dropped! and the Not revert container still in the Drop here container.
