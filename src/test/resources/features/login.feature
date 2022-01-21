Feature: As a user I want to be able to login

  Scenario: Login with mouse after providing valid username and password
    Given I have a valid username and password
    When I type both in
    And press login
    Then I should be logged in and moved to the main page

  Scenario: Login with enter after providing valid username and password
    Given I have a valid username and password
    When I type both in
    And press enter
    Then I should be logged in and moved to the main page

  Scenario: Login after providing locked out username and password
    Given I have a locked out username and password
    When I try to log in
    Then an error should be displayed letting me know I am locked out

  Scenario: Login after providing a performance glitched username and password
    Given I have a performance glitched username and password
    When I time my log in
    Then it should take longer than a normal login

  Scenario: Invalid username or password error
    Given that my username or password are invalid
    When I try to log in
    Then an error should be displayed letting me know the username or password are invalid

  Scenario: Missing username error
    Given I have a valid username and password
    When I leave the username field blank
    And press enter
    Then an error should be displayed letting me know what fields I didn't fill out

  Scenario: Missing password error
    Given I have a valid username and password
    When I leave the password field blank
    And press login
    Then an error should be displayed letting me know what fields I didn't fill out

  Scenario: Getting rid of an error message by clicking the "x" button
    Given that I trigger an error message
    When I click the x on the error message
    Then the error message should go away

  Scenario: User "Bernie" logs in
    Given I log in with Bernie's username and password
    When I type both in
    And press login
    Then an error should be displayed letting me know the username or password are invalid
