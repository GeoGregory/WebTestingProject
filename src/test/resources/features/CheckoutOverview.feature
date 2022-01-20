Feature: As a user, I want to know the total cost of my cart, so I can know how much money my purchase will cost.

  Background:
      #-----------------------------------------------
      #
      #Steps for getting to the checkout Overview page
      #
      #------------------------------------------------

    Given I am on the CheckoutOverview Page

  Scenario: I want to see the total of my purchases
    When I check the total of my purchases
    Then They should be calculated together with tax added on

  Scenario: I want to see the added tax
    When I check the tax
    Then I see what the tax is
