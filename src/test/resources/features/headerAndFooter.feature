@headerAndFooter @all
Feature: As a user I want to be able to interact with the menu and social media links
  Background: Starting from a page with a header and footer
    Given I am on a page with a header and footer

#    Scenario: Clicking on the burger menu
#      When I click on the burger menu
#      Then The burger menu will display its elements

    Scenario: Clicking on the all items link after opening the burger menu
      Given I have opened the burger menu
      When I click on the all items link
      Then I will be taken to the all items page

    Scenario: Clicking on the about link after opening the burger menu
      Given I have opened the burger menu
      When I click on the about link
      Then I will be taken to the about page

    Scenario: Clicking on the logout link after opening the burger menu
      Given I have opened the burger menu
      When I click on the logout link
      Then I will be taken to the login page

    Scenario: Trolley icon will reflect the number of items in the basket
      When I have an item in my basket
      Then the trolley icon will display the number of items in the basket

    Scenario: Clicking the twitter icon
      When I click the twitter icon
      Then I wll be taken to the Swag twitter

    Scenario: Clicking on the facebook icon
      When I click the facebook icon
      Then I wll be taken to the Swag facebook

    Scenario: Clicking on the linkedin icon
     When I click the linkedin icon
     Then I wll be taken to the Swag linkedin

#    Scenario:
#      When I have an item in my basket
#      And I log out
#      And I log back in again
#      Then My cart will be the same as it was