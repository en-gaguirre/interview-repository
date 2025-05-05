Feature: Login Feature

  Scenario: Successful login with correct credentials
    Given I navigate to the login screen
    When I provide correct username and password
    Then I should land in the dashboard