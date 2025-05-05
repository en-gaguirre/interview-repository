Feature: Add product and checkout flow

  Scenario: Complete checkout as a logged-in user
    Given I login and add a product to the cart
    When I proceed to checkout and enter shipping and payment details
    Then I should see the thank you page