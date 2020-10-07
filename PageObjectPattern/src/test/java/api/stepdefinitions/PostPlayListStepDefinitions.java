package api.stepdefinitions;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;

import apiSerenityStep.AppAuthSteps;
import apiSerenityStep.SpotifyApiSteps;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PostPlayListStepDefinitions {

    @Steps
    AppAuthSteps auth;

    @Steps
    SpotifyApiSteps api;

    @When("post request is sent to playList endpoint with user id{} and name{}")
    public void createPlayList(String id,String playListName) {
        api.postPlayList(id, playListName);
    }

    @And("field name is not empty in the response")
    public void checkResponseFieldsNotNull() {
        String result = api.responsePost.then().extract().body().jsonPath().getString("name");
        assertFalse(result.isEmpty());
    }

    @And("new {} name and required fields are present in the response: {}, {}, {}")
    public void checkPostResponseData(String playListName, String id, int limit, String displayName) {
        ValidatableResponse result = api.responsePost.then().assertThat()
                .body("name", equalTo(playListName))
                .body("owner.id", equalTo(id))
                .body("owner.display_name", equalTo(displayName))
                .body("tracks.limit", equalTo(limit));   
    }
}