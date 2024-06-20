Feature: Web tables submenu

Background: 
Given I go to the "elements" page
And I click on the "Web Tables" submenu

@Testing @TC01 
Scenario: Verify the display of the Web Tables screen
Then I verify the display of the Web Tables view

@Testing @TC02 
Scenario: Verify user can open Registration Form by clicking on the Add button on the Web Tables view
When I click on the Add button
Then I verify the display of the Registration Form

@Testing @TC03
Scenario: Verify the message "No rows found" appears when the user searches with no matching key.
When I input "No matching" key on the search space.
Then I verify the displaying message

@Testing @TC04
Scenario: Verify the matching result when user searches with the matich key.
When I input "er" key on the search space.
Then I verify the first names of all rows containing the "er".




