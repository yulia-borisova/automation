package apiSerenityStep;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

// Trying to use session variable + use shared CommonStepDefinitions class
public class TestBaseStep {
    AppAuthStep auth;
    Response responseGet;
    String baseUrl = "https://api.spotify.com";

    @Step("sending get request")
    public void sendGetRequest(String endpoint) {
        String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
        System.out.println("IT IS TOken in the GET STEP" + accessToken);
        responseGet = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + endpoint);
        // appToken = responseToken.path("access_token").toString();
        int codeResponse = responseGet.then().extract().statusCode();
        Serenity.setSessionVariable("codeResponse").to(codeResponse);
    }

    @Step("receiving Get response status")
    public int getResponseStatusCode() {
        System.out.println("This is call from get response step!!!");
        int responseCode = Serenity.sessionVariableCalled("codeResponse");
        // int responseCode = responseGet.then().extract().statusCode();
        return responseCode;
    }
}