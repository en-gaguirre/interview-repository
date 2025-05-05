Feature: Login Feature

  Scenario Failed login attempts
    Given the login page is open
    When I enter <user> and <password>
    Then an error message is displayed

    Examples:
      | user  | password     |
      | admin | wrongpass123 |
      | guest | guest123     |
