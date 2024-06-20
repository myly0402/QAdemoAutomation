Feature: Droppable

  Background:
    Given I go to the "interaction" page
    And I click on the "Droppable" submenu

  @Testing @TC08
  Scenario: I verify the droppable function on Simple tab
    When I tab on "simple" tab
    And I drag the Drag me container to the Drop here container
    Then I verify the header of Drop here container on the "simple" tab changed to Dropped!

  @Testing @TC09
  Scenario: I verify the droppable function on Accept tab using Acceptable container
    When I tab on "accept" tab
    And I drag the Acceptable container to the Drop here container
    Then I verify the header of Drop here container on the "accept" tab changed to Dropped!

  @Testing @TC10
  Scenario: I verify the droppable function on Accept tab using Not Acceptable container
    When I tab on "accept" tab
    And I drag the Not Acceptable container to the Drop here container
    Then I verify the header of Drop here container still the same.


 @Testing @TC11
  Scenario: I verify the droppable function on preventPropogation tab
    When I tab on "preventPropogation" tab
    And I drag the Drag me container to the Inner droppable (not greedy) container
    Then I verify the header of outer and inner drop container