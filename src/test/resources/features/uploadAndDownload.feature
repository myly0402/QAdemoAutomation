Feature: Upload and download

Background: 
Given I go to the Elements page
And I click on the "Upload and Download" submenu

@Testing @TC05
Scenario: Verify the display of the Upload and Download page
Then I verify the display of the Upload and Download page

@Testing @TC06
Scenario: Verify user can download a file on Upload and Download page
When I tap on the download button
And I click on save button on my computer
Then I verify the file is saved successfully



