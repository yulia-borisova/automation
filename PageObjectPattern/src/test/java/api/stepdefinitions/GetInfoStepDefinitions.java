//done
package api.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;

import apiSerenityStep.AppAuthStep;
import apiSerenityStep.BaseStep;
import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class GetInfoStepDefinitions {
    @Steps
    AppAuthStep auth;

    @Steps
    BaseStep baseStep;

    @Steps
    SpotifyApiStep apiStep;

    @Given("User has app access token")
    public void getAccessAppToken() {
        System.out.println("Getting app access token");
        String newToken = auth.getAppToken();
        System.out.println("IT IS A NEW TOKEN" + newToken);
    }

    @When("User sends request to {word}")
    public void sendGetRequest(String endpoint) {
        System.out.println("Sending Get request...");
        apiStep.sendGetRequestWithAppToken(endpoint);
    }

    @Then("response 200Ok is received")
    public void checkOkStatus() {
        System.out.println("checking response status");
        int expectedStatus = 200;
        int actualStatus = apiStep.getResponseStatusCode();
        assertEquals("message: Failure. Status is incorrect", expectedStatus, actualStatus);
    }

    @Then("all required fields are present: artist.id, album type,name")
    public void all_required_items_are_present() {
        System.out.println("checking presense of required fields..");
        String albumId = "1uNFoZAHBGtllmzznpCI3s";
        String albumType = "single";
        String name = "Justin Bieber";
        ValidatableResponse response = apiStep.returnGetResponse().then().assertThat()
                .body("albums.items[0].artists[0].id", equalTo(albumId))
                .body("albums.items[0].album_type", equalTo(albumType))
                .body("albums.items[0].artists[0].name", equalTo(name));
    }
}