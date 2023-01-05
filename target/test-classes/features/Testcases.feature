Feature: assignmnet

  @orangehrm
  Scenario: Search for a user in OrangeHRM
    Given user is on login page
    When user enters username "Admin" and password "admin123"
    And clicks on login button
    Then user is navigated to directory page
    And user types "ca" in name filed
    And selects name, location
    When clicks on search button
    Then verify the username
    And click on the profile icon
    And click on log out

  @orangehrm
  Scenario: Add salary and save data
    Given user is on landing page
    When logs in with user name and password
    Then click on admin
    And select pay grades under job
    And click on add button
    Then type value in name filed
    And verify success message after saving
    Then click on add in Assigned Currencies
    And select indian rupee in currency filed
    And select minimum salary and maximum salary
    And verify success message
    Then verify the given data
