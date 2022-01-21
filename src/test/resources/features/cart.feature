@cart @all
Feature: As a user, I want to use the functions of the cart

  Background: Logged in and on the cart page with the backpack added
    Given I am logged in and on the cart page with the backpack added

  Scenario: Trying to remove the backpack from the cart
    When I click REMOVE on the backpack
    Then The backpack will be removed from the cart

  Scenario: Checking out with items in the cart
    When I click the CHECKOUT button
    Then I should be taken to a page to enter my details

  Scenario: Returning to the products page
    When I click the CONTINUE SHOPPING button
    Then I should be taken to the main products page

