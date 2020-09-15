package apiSerenityStep;

import static org.hamcrest.Matchers.hasKey;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TokenGenerator {
    String client_id = "07110c2def0d410d8a7894b92b6deca0";
    String client_secret = "cb71cb414028401086f78986e943636e";
    String baseUrl = "https://accounts.spotify.com/api/token";
    Response responseToken;
    Response responseGet;
    String access_token;

    @Step("retrieve access token")
    public String getToken() {
        Response responseToken = RestAssured.given().auth().preemptive().basic(client_id, client_secret)
                .param("grant_type", "client_credentials").param("application", "application/x-www-form-urlencoded")
                .contentType("application/json").when().post(baseUrl).andReturn().then()
                .body("$", hasKey("access_token")).extract().response();
        access_token = responseToken.path("access_token").toString();
        return access_token;
    }

    @Step("sending get request")
    public void sendGetRequest(String endpoint) {
        responseGet = SerenityRest.given().auth().oauth2(this.access_token).get("https://api.spotify.com" + endpoint);
    }

    @Step("checking status")
    public void checkOkStatus() {
        responseGet.then().statusCode(200);
    }
}