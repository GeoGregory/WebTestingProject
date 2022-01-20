Feature: As a user I want to be able to interact with the menu and social media links
  Background: Starting from a page with a header and footer
    Given I am on a page with a header and footer

    Scenario: Clicking on the burger menu
      When I click on the burger menu
      Then The burger menu with display its elements

    Scenario: Clicking the