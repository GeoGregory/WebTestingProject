Feature: As a user, I want to be able to view products and add or remove products from the cart

  Background: I want to come from the login page
    Given I am on the login page
    When I logged in
    Then I should be logged in

  Scenario: As a user, I want to be able to view the products
    Given I have logged in
    When I view the products page
    Then All products should be shown correctly (with corresponding image, price and description)

  Scenario Outline: As a user, I want to be able to add items to my cart
    Given that I am on the products page
    When I click on a "<product>" and add to cart button
    Then the cart icon is incremented and the button for that product changes to remove
    Examples:
      | product                           |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario Outline: As a user, I want to be able to add an item to my cart
    Given that I am on the "<product>" page
    When I click on the add to cart button for the single "<product>"
    Then the cart icon is incremented and the button changes to remove
    Examples:
      | product                           |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario Outline: : As a user, I want to be able to sort the products in different orders of relevance.
    Given that I am starting on the products page
    When I sort by "<sortingMethods>"
    Then The products are ordered correctly "<firstProduct>" is first
    Examples:
      | sortingMethods          | firstProduct                      |
      | Name (A to Z)           | Sauce Labs Backpack               |
      | Name (Z to A)           | Test.allTheThings() T-Shirt (Red) |
      | Price (low to high)     | Sauce Labs Onesie                 |
      | Price (high to low)     | Sauce Labs Fleece Jacket          |


#  Scenario Outline: As a user, I want to inspect each product on its own page
#    Given that I am on the products page
#    When I click on a specific "<product>"
#    Then I should go to "<product>" page
#    Examples:
#      | product                           |
#      | Sauce Labs Backpack               |
#      | Sauce Labs Bike Light             |
#      | Sauce Labs Bolt T-Shirt           |
#      | Sauce Labs Fleece Jacket          |
#      | Sauce Labs Onesie                 |
#      | Test.allTheThings() T-Shirt (Red) |
