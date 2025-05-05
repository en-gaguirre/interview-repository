Feature: Access control for login and dashboard

  Scenario: Login and logout flow
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the dashboard
    Given I click on the logout button
    Then I should see the login screen again