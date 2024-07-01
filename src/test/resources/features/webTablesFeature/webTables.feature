Feature: Web tables submenu

  Background:
    Given I go to the "elements" page
    And I click on the "Web Tables" submenu

  @Testing @TC01 @WebTables
  Scenario: Verify the display of the Web Tables screen
    Then I verify the display of the Web Tables view

  @Testing @TC02 @WebTables
  Scenario: Verify user can open Registration Form by clicking on the Add button on the Web Tables view
    When I click on the Add button
    Then I verify the display of the Registration Form

  @Testing @TC17 @WebTables
  Scenario: Verify user can add new user by Registration Form with the valid user information
    When I click on the Add button
    And I add all the valid information and click on the Submit button
    Then I verify the new user is added
  
  @Testing @TC03 @WebTables
  Scenario: Verify the message "No rows found" appears when the user searches with no matching key.
    When I input "No matching" key on the search space.
    Then I verify the displaying message

  @Testing @TC04 @WebTables
  Scenario: Verify the matching result when user searches with the matich key.
    When I input "er" key on the search space.
    Then I verify the first names of all rows containing the "er".

  @Testing @TC18 @WebTables
  Scenario: Verify user can not add new user by Registration Form if missing any informationz
    When I click on the Add button
    And I enter information but left one of "firstName", "LastName", "Email","Age","Salary", and "Department" missing.
    Then I verify user is still in the Registration form.

    Examples:
      | FirstName | LastName | Email            | Age | Salary | Department |
      |           | Doe      | johndoe@test.com |  30 |  50000 | IT         |
      | Jane      |          | janedoe@test.com |  25 |  60000 | HR         |
      |           | Smith    |                  |  40 |  70000 | Finance    |
      | Mike      | Johnson  |                  |     |  80000 | Marketing  |
      | Emily     | Brown    | emily@test.com   |  35 |        | Sales      |
      | Anna      | Wilson   | anna@test.com    |  28 |  10000 |            |
      |           |          |                  |     |        |            |
