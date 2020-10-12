//done
package api.stepdefinitions;

import static org.hamcrest.Matchers.notNullValue;

import apisteps.SpotifyApiSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class ReleasesStepDefinitions {

    @Steps
    SpotifyApiSteps apiStep;

    @When("User sends request to newreleases endpoint")
    public void sendGetRequest() {
        System.out.println("Sending Get request...");
        apiStep.getNewReleases();
    }

    @Then("Fields: id, type and name are not null")
    public void checkFieldsNotEmpty() {
        apiStep.response.then().assertThat()
                .body("albums.items[0].artists[0].id", notNullValue())
                .body("albums.items[0].artists[0].type", notNullValue())
                .body("albums.items[0].artists[0].name", notNullValue());
    }
}