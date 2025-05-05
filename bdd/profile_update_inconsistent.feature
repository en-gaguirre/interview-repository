Feature: Profile management

  Scenario: Update user profile
    Given I am logged in
    When I go to the profile page
    Then I should see my profile information
    When I edit my profile name
    Then I should see a success message
    And I should see the updated name