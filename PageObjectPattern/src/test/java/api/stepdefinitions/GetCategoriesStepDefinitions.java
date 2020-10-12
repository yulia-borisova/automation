package api.stepdefinitions;

import static org.junit.Assert.assertFalse;

import apisteps.SpotifyApiSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class GetCategoriesStepDefinitions {

    @Steps
    SpotifyApiSteps apiStep;

    @When("User sends Get request to Categoires endpoint")
    public void sendGetRequestToCategories() {
        apiStep.getCategories();
    }

    @When("Request equals or exceeds max limit {}")
    public void getRequestWithMaxLimit(int limit) {
        apiStep.getRequestWithMaxLimit(limit);
    }

    @And("User sends Get request with invalid token to retrieve categories")
    public void sendRequestWithInvalidToken() {
        apiStep.getCategories();
    }

    @Then("field total with not null value is present in the response")
    public void checkTotalFieldsCorrectlyReturned() {
        System.out.println("checking total in the response");
        String result = apiStep.response.thenReturn().getBody().jsonPath().getString("categories.total");
        assertFalse("message: Field is Empty", result.isEmpty());
    }
}