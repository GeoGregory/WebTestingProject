@yourInfo @all
Feature: As a user, I want to be able to enter my information

  Background:
    Given I am logged in as a standard user and on the checkout your info page

  Scenario: Filling in all text fields
    And I fill in all available text fields
    When I click the CONTINUE button
    Then I should be taken to the checkout overview page

    Scenario: Filling in no text fields
      When I click the CONTINUE button
      Then I should receive an error message

      Scenario: Filling in everything but the Postal Code field
        And I have filled in the First Name field
        And I have filled in the Last Name field
        When I click the CONTINUE button
        Then I should receive an error prompting me to fill in the Postal Code field

        Scenario: Filling in everything but the Last Name field
          And I have filled in the First Name field
          And I have filled in the Postal Code field
          When I click the CONTINUE button
          Then I should receive an error prompting me to fill in the Last Name field

          Scenario: Filling in everything but the First Name field
            And I have filled in the Postal Code field
            And I have filled in the Last Name field
            When I click the CONTINUE button
            Then I should receive an error prompting me to fill in the First Name field

            Scenario: Clicking the cancel button
              When I click the CANCEL button
              Then I should be taken to the cart page
