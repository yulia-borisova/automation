package api.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import apiSerenityStep.AppAuthStep;
import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class GetCategoriesStepDefinitions {
    @Steps
    AppAuthStep auth;

    @Steps
    TestCommonStepDefinitions commonStep;

    @Steps
    SpotifyApiStep apiStep;

    @Given("User has app token")
    public void user_has_app_token() {
        System.out.println("getting token");
        auth.getAppToken();
    }

    @When("User sends  valid Get request")
    public void user_sends_valid_Get_request() {
        String endpoint = "/v1/browse/categories";
        apiStep.sendGetRequestWithAppToken(endpoint);
    }

    @Then("response status code200 {int} is received")
    public void response_is_received(int expectedResult) {
        int actualResult = apiStep.getResponseStatusCode();
        assertEquals("message: Status code is wrong", expectedResult, actualResult);
    }

    @And("field total with not null value is present in the response")
    public void data_is_correct() {
        System.out.println("checking total in the response");
        String response = apiStep.returnGetResponse().getBody().jsonPath().getString("categories.total");
        assertFalse(response.isEmpty());
    }

    @When("Request equal or exceeds max limit {}")
    public void getRequestMaxLimit(int limit) {
        apiStep.getRequestWithMaxLimit(limit);
    }

    @Then("Status code400 {int} is received")
    public void error_message_is_received(int expectedResult) {
        int actualResult = apiStep.getResponseStatusCode();
        assertEquals("message: Status code is wrong", expectedResult, actualResult);
    }

    @When("request is sent with invalid token")
    public void sendRequestWithInvalidToken() {
        String endpoint = "/v1/browse/categories";
        auth.invalidateAccessToken();
        apiStep.sendGetRequestWithAppToken(endpoint);
    }

    @Then("Status code401 {int} is received")
    public void request_is_sent_with_invalid_token(int expectedResult) {
        int actual = apiStep.getResponseStatusCode();
        assertEquals("message: Status code is wrong, expected 401", expectedResult, actual);
    }
}