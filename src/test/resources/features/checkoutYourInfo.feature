Feature: Checkout: Your Info page

  Background:
    Given I am logged in and on the checkout your info page

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
