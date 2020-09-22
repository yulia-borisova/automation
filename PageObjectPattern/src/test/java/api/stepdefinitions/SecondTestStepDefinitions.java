package api.stepdefinitions;

import apiSerenityStep.AppAuthStep;
import apiSerenityStep.TestBaseStep;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class SecondTestStepDefinitions {

    @Steps
    TestCommonStepDefinitions commonStep;

    @Steps
    AppAuthStep auth;

    @Steps
    TestBaseStep step;

    @When("user sends request to categories endpoint")
    public void getRequest() {
        String endpoint = "/v1/browse/categories";
        step.sendGetRequest(endpoint);
    }
}