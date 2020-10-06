package api.stepdefinitions;

import static org.hamcrest.Matchers.equalTo;

import apiSerenityStep.AppAuthSteps;
import apiSerenityStep.SpotifyApiSteps;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

// Token is generated manually
public class GetMeStepDefinitions {

    @Steps
    AppAuthSteps auth;

    @Steps
    SpotifyApiSteps apiStep;

    @When("User sends Get request to me endpoint")
    public void sendGetRequestToMe() {
        System.out.println("Step2: sending request");
        apiStep.getRequestToMe();
    }

    @And("required fields with valid data are present in the response: {}, {}, {}")
    public void checkPersonalData(String birthdate, String country, String mail) {
        ValidatableResponse response = apiStep.responseGet.then()
                .assertThat()
                .body("birthdate", equalTo(birthdate))
                .body("country", equalTo(country))
                .body("email", equalTo(mail));
    }
}