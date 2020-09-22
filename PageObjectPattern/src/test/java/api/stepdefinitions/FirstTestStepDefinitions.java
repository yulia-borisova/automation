package api.stepdefinitions;

import apiSerenityStep.AppAuthStep;
import apiSerenityStep.TestBaseStep;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class FirstTestStepDefinitions {

    @Steps
    TestCommonStepDefinitions commonStep;

    @Steps
    AppAuthStep auth;

    @Steps
    TestBaseStep step;

    @When("user sends request to new-releases endpoint")
    public void getRequest() {
        String endpoint = "/v1/browse/new-releases";
        step.sendGetRequest(endpoint);
    }
}