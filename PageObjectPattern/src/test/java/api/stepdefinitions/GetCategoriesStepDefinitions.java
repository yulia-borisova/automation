package api.stepdefinitions;

import static org.junit.Assert.assertFalse;

import apiSerenityStep.AppAuthSteps;
import apiSerenityStep.SpotifyApiSteps;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class GetCategoriesStepDefinitions {

    @Steps
    AppAuthSteps auth;

    @Steps
    SpotifyApiSteps apiStep;

    @Given("User has app token")
    public void getAppToken() {
        System.out.println("getting token");
        auth.getAppToken();
    }

    @When("User sends  valid Get request")
    public void sendGetRequestToCategories() {
        apiStep.getCategories();
    }

    @And("field total with not null value is present in the response")
    public void checkResponse() {
        System.out.println("checking total in the response");
        String result = apiStep.responseGet.thenReturn().getBody().jsonPath().getString("categories.total");
        assertFalse("message: Field is Empty", result.isEmpty());
    }

    @When("Request equal or exceeds max limit {}")
    public void getRequestWithMaxLimit(int limit) {
        apiStep.getRequestWithMaxLimit(limit);
    }

    @When("request is sent with invalid token")
    public void sendRequestWithInvalidToken() {
        auth.invalidateAccessToken();
        apiStep.getCategories();
    }
}