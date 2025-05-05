Feature: Login validation

  Scenario: Valid login
    Given I am on the login page
    When I enter valid credentials
    Then it works