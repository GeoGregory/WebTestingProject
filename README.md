# Web Testing
This project is a testing framework, created for testing the SwagLabs demo website (https://www.saucedemo.com/). 

## Contents
- [How to use](#how-to-use)
- [Testing Framework](#testing-framework)
- [Contributors](#contributors)

## How to use
- Run testRunner.java

## Testing Framework
Each web page from the website has a corresponding POM file with each file designed to provide methods that can be used whenever interacting with the UI of that page.

Cucumber facilitated for a BDD layer of abstraction which meant that user stories (acceptance criteria) could be tested in line with the POM files in our framework.

**Example user story:<br>**
**Given** I have a valid username and password<br>
**When** I type both in<br>
**And** press login<br>
**Then** I should be logged in and moved to the main page

Within the stepDef file, under the corresponding given, when and then statements, methods from the loginPage POM file are called to complete the test. For the example, this can be seen below:

```
@Given("I have a valid username and password")
public void iHaveAValidUsernameAndPassword() {
    username = UserOptions.STANDARD.getUserOption();
    password = "secret_sauce";
}

@When("I type both in")
public void iTypeBothIn() {
    loginPage.inputLoginFields(username, password);
}

@And("press login")
public void pressLogin() {
    loginPage.clickLoginButton();
}

@Then("I should be logged in and moved to the main page")
public void iShouldBeLoggedInAndMovedToTheMainPage() {
    Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
}
```

## Contributors
George Gregory<br> 
Callum Davies-Keogh<br>
Harry Jones<br>
Louis Clement-Harris<br>
Melvin Thomas<br>
Tony Parsons<br>
Pavle Svrdlin
