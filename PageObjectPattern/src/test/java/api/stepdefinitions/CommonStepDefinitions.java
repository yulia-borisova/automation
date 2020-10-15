package api.stepdefinitions;

import static org.junit.Assert.assertEquals;

import apisteps.AppAuthSteps;
import apisteps.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

//This class is to share common steps definitions
public class CommonStepDefinitions {

    @Steps
    AppAuthSteps auth;

    @Steps
    BaseSteps step;

    @Given("User is authorized with manually retrieved token")
    public void getAuthorized() {
        System.out.println("Step1: Get manually retrieved token");
        auth.getAuthorized();
    }

    @Given("User has app token on spotify website")
    public void getAppToken() {
        System.out.println("Getting app access token");
        String newToken = auth.getAppToken();
        System.out.println("IT IS A NEW TOKEN" + newToken);
    }
    
    @When("app access token gets expired")
    public void sendRequestWithInvalidToken() {
        auth.invalidateAccessToken();
    }
    
    @Then("status code {int} is received")
    public void getStatusCode(int expected) {
      int actualCode = Serenity.sessionVariableCalled(BaseSteps.RESPONSE_CODE);
        assertEquals("message: ACTUAL CODE IS WRONG", expected, actualCode);
    }
}