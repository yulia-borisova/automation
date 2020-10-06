package api.stepdefinitions;

import static org.junit.Assert.assertEquals;

import apiSerenityStep.AppAuthSteps;
import apiSerenityStep.BaseSteps;

import apiSerenityStep.SpotifyApiSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

//This class is to share common steps definitions
public class CommonStepDefinitions {

    @Steps
    AppAuthSteps auth;

    @Steps
    BaseSteps step;

    @Given("User is authorized")
    public void getAuthorized() {
        System.out.println("Step1: Get manually retrieved token");
        auth.getAuthorized();
    }

    @Given("User has app token on spotify website")
    public void getAppToken() {
        System.out.println("Getting app access token");
        String newToken = auth.getAppToken();
        System.out.println("IT IS A NEW TOKEN" + newToken);
    }

    @Then("status code {int} is received")
    public void getStatusCode(int expected) {
        Response get = Serenity.sessionVariableCalled("responseGet");
        int actualCode = get.then().extract().statusCode();
        assertEquals("message: ACTUAL CODE IS WRONG", expected, actualCode);
    }

    @Then("post status code {int} is received")
    public void getPostStatusCode(int expected) {
        Response post = Serenity.sessionVariableCalled("responsePost");
        int actualCode = post.then().extract().statusCode();
        assertEquals("message: ACTUAL CODE IS WRONG", expected, actualCode);
    }
}