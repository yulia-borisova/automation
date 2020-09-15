package apiSerenityCucumberStepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class SpotifyGetCategories {

    @Steps
    SpotifyApiStep apiStep;

    @Given("User has app token")
    public void user_has_app_token() {
        System.out.println("getting token");
        apiStep.getAppToken();
    }

    @When("User sends  valid Get request")
    public void user_sends_valid_Get_request() {
        String endpoint = "/v1/browse/categories";
        apiStep.sendGetRequestWithAppToken(endpoint);

    }

    @Then("response is received")
    public void response_is_received() {
        int expectedResult = 200;
        int actualResult = apiStep.getResponseStatusCode();
        assertEquals("message: Status code is wrong", expectedResult, actualResult);
    }

    @And("fields present in the response")
    public void data_is_correct() {
        System.out.println("step to be done");
        String reqField = "id";
        boolean actualResult = apiStep.checkPresenseOfRequiredFields(reqField);
        assertTrue("message: no required field in the response.", actualResult);
    }

    @When("Request exceeds max limit")
    public void getRequestMaxLimit() {
        String endpoint = "/v1/browse/categories?limit=100";
        apiStep.sendGetRequestWithAppToken(endpoint);
    }

    @Then("Status code400 is received")
    public void error_message_is_received() {
        int expectedResult = 400;
        int actualResult = apiStep.getResponseStatusCode();
        assertEquals("message: Status code is wrong", expectedResult, actualResult);
    }

    @When("request is sent with invalid token")
    public void sendRequestWithInvalidToken() {
        String endpoint = "/v1/browse/categories";
        apiStep.invalidateAccessToken();
        apiStep.sendGetRequest(endpoint);
    }

    @Then("Status code401 is received")
    public void request_is_sent_with_invalid_token() {
        int expected = 401;
        int actual = apiStep.getResponseStatusCode();
        assertEquals("message: Status code is wrong, expected 401", expected, actual);
    }
}