package api.stepdefinitions;

import static org.junit.Assert.assertEquals;

import apiSerenityStep.AppAuthStep;
import apiSerenityStep.TestBaseStep;
import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

//This class is to share common steps definitions

public class TestCommonStepDefinitions {

    @Steps
    AppAuthStep auth;

    @Steps
    TestBaseStep step;

    @Given("User has app token on spotify website")
    public void user_has_app_token_on_spotify_website() {
        System.out.println("Getting app access token");
        String newToken = auth.getAppToken();
        System.out.println("IT IS A NEW TOKEN" + newToken);
    }

    @Then("status code {int} is received")
    public void status_code_is_received(int expected) {
        int actualCode = step.getResponseStatusCode();
        assertEquals("message: actual code is wrong", expected, actualCode);
    }
}