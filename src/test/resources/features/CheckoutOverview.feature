Feature: As a user, I want to know the total cost of my cart, so I can know how much money my purchase will cost.

  Background:
      #-----------------------------------------------
      #
      #Steps for getting to the checkout Overview page
      #
      #------------------------------------------------

    Given I am on the CheckoutOverview Page

 Scenario: I want to see the total of my purchases
    When I check the <total> of my purchases
    Then It should be the <subtotal> plus the <tax>

   Scenario: I want to go back to products
     When I click the cancel button
     Then I go back to the products page

     Scenario: I want to go to finish my order
       When I click the finish button
       Then I go to the Checkout Complete Page

       Scenario: I want to see the products I am purchasing
         When I look at my items
         Then I see all the things I am purchasing
