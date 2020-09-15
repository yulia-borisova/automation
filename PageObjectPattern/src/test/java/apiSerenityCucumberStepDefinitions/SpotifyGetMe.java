package apiSerenityCucumberStepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

// Token is generated manually

public class SpotifyGetMe {
    @Steps
    SpotifyApiStep api;

    @Given("User is authorized")
    public void user_is_authorized() {
        System.out.println("Step1: Getting token");
        api.getAuthorized();
    }

    @When("User sends Get request to {word}")
    public void user_sends_Get_request(String endpoint) {
        System.out.println("Step2: sending request");
        api.sendGetRequest(endpoint);
    }

    @Then("Status code OK is received as {}")
    public void status_code_is_received(int expectedStatus) {
        System.out.println("Step3: Checking status code");
        int actualStatus = api.getResponseStatusCode();
        assertEquals("message: Status response failure", expectedStatus, actualStatus);
    }

    @And("all fields {} with valid data {} are present in the response")
    public void checkPersonalData(String requiredField, String responseData) {
        System.out.println("Step5: Check if personal data is correct");
        api.checkIfDataIsValidGet(requiredField, responseData);
    }
}