//done
package api.stepdefinitions;

import static org.hamcrest.Matchers.equalTo;
import apiSerenityStep.AppAuthSteps;
import apiSerenityStep.SpotifyApiSteps;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class GetInfoStepDefinitions {

    @Steps
    AppAuthSteps auth;

    @Steps
    SpotifyApiSteps apiStep;

    @When("User sends request to newreleases endpoint")
    public void sendGetRequest() {
        System.out.println("Sending Get request...");
        apiStep.getNewReleases();
    }

    @Then("all required fields are present: {} {} {}")
    public void checkDataInResponse(String albumId, String albumType, String name) {
        System.out.println("checking presense of required fields..");
             ValidatableResponse result = apiStep.responseGet.then().assertThat()
                .body("albums.items[0].artists[0].id", equalTo(albumId))
                .body("albums.items[0].album_type", equalTo(albumType))
                .body("albums.items[0].artists[0].name", equalTo(name));
    }
}