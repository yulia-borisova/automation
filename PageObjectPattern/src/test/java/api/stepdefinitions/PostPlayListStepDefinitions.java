package api.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Assert;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import apiSerenityStep.AppAuthStep;
import apiSerenityStep.BaseStep;
import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class PostPlayListStepDefinitions {

    @Steps
    AppAuthStep auth;

    @Steps
    SpotifyApiStep api;

    @Given("User has Auth token")
    public void getToken() {
        System.out.println("Step1: Getting token");
        auth.getAuthorized();
    }

    @When("post request is sent to {word} with {}")
    public void createPlayList(String endpoint, String playListName) {
        api.postPlayList(endpoint, playListName);
    }

    @Then("response with {} is received")
    public void getResponseStatusCode(int expectedResult) {
        int actualResult = api.getPostResponseStatusCode();
        assertEquals(expectedResult, actualResult);
    }

    @Then("new {} name and all required fields are present in the response: id, limit, display_name")
    public void checkIfDataIsValid(String playListName) {
        // api.returnPostResponseBody().getBody().jsonPath().getString("name");
        ValidatableResponse result = api.returnPostResponse().then().assertThat().body("name", equalTo(playListName))
                .body("owner.id", equalTo("czc11mg48dvwd16aeq0jofr3j")).body("owner.display_name", equalTo("Yulia"))
                .body("tracks.limit", equalTo(100));
    }
}