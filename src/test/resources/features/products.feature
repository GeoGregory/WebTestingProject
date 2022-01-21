Feature: As a user, I want to be able to view products and add or remove products from the cart

  Scenario: As a user, I want to be able to view the products
    Given I have logged in
    When I view the products page
    Then All (6) products should be shown correctly (with corresponding image, price and description)

  Scenario: As a user, I want to be able to add items to my cart
    Given that I am on the products page
    When I click on the add to cart button
    Then the cart icon is incremented and the button for that product changes to remove

  Scenario: As a user, I want to be able to add an item to my cart
    Given that I am on the product page
    When I click on the add to cart button for the single product
    Then the cart icon is incremented and the button for that product changes to remove from the product page

  Scenario Outline: : As a user, I want to be able to sort the products by one of the <sortingMethods>.
    Given that I am on the products page
    When I sort by <sortingMethods>
    Then The products are ordered correctly
    Examples:
      | A - Z     |
      | Z - A     |
      | Price Asc |
      | Price Des |

  Scenario: As a user, I want to inspect each product on its own page
    Given that I am on the products page
    When I click on a specific product
    Then I should go to {product page}
