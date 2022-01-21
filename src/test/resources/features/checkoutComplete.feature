@checkoutComplete @all
Feature: As a user, I want to return home after I’ve finished my purchase, so I can spend MORE money.
  Scenario: Returning to products page after completing purchase
    Given I am on the checkout complete page after a purchase
    When I click the BACK HOME button
    Then I should be taken to the main products page