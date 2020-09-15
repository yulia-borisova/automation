package apiSerenityCucumberStepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class SpotifyPostPlayList {

    @Steps
    SpotifyApiStep api;

    @Given("User is authorized and accessToken is received")
    public void getToken() {
        api.getAuthorized();
    }

    @When("post request is sent to {word} with {}")
    public void createPlayList(String endpoint, String playListName) {

        api.createPlayList(endpoint, playListName);
    }

    @Then("response with {} is received")
    public void getResponseStatusCode(int expectedResult) {
        int actualResult = api.getPostResponseStatusCode();
        assertEquals(expectedResult, actualResult);
    }

    @Then("new {} name and all required fields are present in the response: id, limit, display_name")
    public void checkIfDataIsValid(String playListName) {
       api.checkFieldsInPostResponse(playListName);   
    }
}