Feature: As a user I want to be able to login

  Scenario: Login after providing valid username and password
    Given I have a valid username and password
    When I type both in and press login
    Then I should be logged in and moved to the main page

#    Given I have a valid username and password
#    When I type both in and press enter
#    Then I should be logged in and moved to the main page

  Scenario: Triggering errors
    Given that my username or password are invalid
    When I type both in and press login
    Then an error should be displayed letting me know they are invalid

    Given I have a valid username and password
    When I leave the username field blank
    Then an error should be displayed letting me know what fields I didn't fill out

    Given I have a valid username and password
    When I leave the password field blank
    Then an error should be displayed letting me know what fields I didn't fill out

  Scenario: Getting rid of an error message by clicking the "x" button
    Given that I trigger an error message
    When I click the x on the error message
    Then the error message should go away