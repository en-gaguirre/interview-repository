Feature: Checkout flow for an online store

  Scenario: User completes a purchase
    Given I login and add a product to the cart
    When I proceed to checkout and fill in shipping details
    Then it works
    And the confirmation message should appear
    When I apply a discount code
    Then I see the discounted total