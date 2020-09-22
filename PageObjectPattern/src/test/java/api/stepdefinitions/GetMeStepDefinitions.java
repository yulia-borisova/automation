package api.stepdefinitions;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import apiSerenityStep.AppAuthStep;
import apiSerenityStep.BaseStep;
import apiSerenityStep.SpotifyApiStep;
import io.cucumber.java.en.*;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

// Token is generated manually
//DONE

public class GetMeStepDefinitions {
    @Steps
    AppAuthStep auth;

    @Steps
    BaseStep baseStep;

    @Steps
    SpotifyApiStep api;

    @Given("User is authorized")
    public void user_is_authorized() {
        System.out.println("Step1: Getting token");
        auth.getAuthorized();
    }

    @When("User sends Get request to {word}")
    public void user_sends_Get_request(String endpoint) {
        System.out.println("Step2: sending request");
        api.sendGetRequest(endpoint);
    }

    @Then("Response status OK is received")
    public void status_code_is_received() {
        System.out.println("Step3: Checking status code");
        int expectedStatus = 200;
        int actualStatus = api.getResponseStatusCode();
        assertEquals("message: Status response failure", expectedStatus, actualStatus);
    }

    @And("required fields with valid data are present in the response: birthdate, country, email")
    public void checkPersonalData() {
        String birthdate = "1973-04-07";
        String country = "PL";
        String mail = "yulia.borisowa.qa@gmail.com";
        ValidatableResponse response = api.returnGetResponse().then().assertThat().body("birthdate", equalTo(birthdate))
                .body("country", equalTo(country)).body("email", equalTo(mail));
    }
}