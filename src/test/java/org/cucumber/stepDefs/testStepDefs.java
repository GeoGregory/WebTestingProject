package test.java.org.cucumber.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class testStepDefs {

    @When("I do a test")
    public void iDoATest() {
        System.out.println("doing the test");
    }

    @Then("This assertion passes")
    public void thisAssertionPasses() {
        System.out.println("Passed!");
    }
}
