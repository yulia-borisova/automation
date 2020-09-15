package apiSerenityCucumberStepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class SpotifyGetInfo {

    @Steps
    SpotifyApiStep apiStep;

    @Given("User has app access token")
    public void getAccessAppToken() {
        System.out.println("Getting app access token");
        String newToken = apiStep.getAppToken();
        System.out.println("IT IS A NEW TOKEN" + newToken);
    }

    @When("User sends request to {word}")
    public void sendGetRequest(String endpoint) {
        System.out.println("Sending Get request...");
        apiStep.sendGetRequestWithAppToken(endpoint);
    }

    @Then("{int} code is received")
    public void checkOkStatus(int expectedStatus) {
        System.out.println("checking response status");
        int actualStatus = apiStep.getResponseStatusCode();
        assertEquals("message: Failure. Status is incorrect", expectedStatus, actualStatus);
    }
    @Then("all required fields {} are present")
    public void all_required_items_are_present(String requiredField) {
       System.out.println("checking presense of required fields..");
       boolean actualResult = apiStep.checkPresenseOfRequiredFields(requiredField);
       assertTrue("message: no required field in the response.",actualResult);
       
    }
}