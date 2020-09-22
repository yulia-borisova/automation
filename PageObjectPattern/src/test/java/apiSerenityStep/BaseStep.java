package apiSerenityStep;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

//class contains all basic steps
public class BaseStep {
    AppAuthStep auth;
    
    // base Urls
    String baseAppTokenUrl = "https://accounts.spotify.com/api/token";
    String baseUrl = "https://api.spotify.com";
    String categoriesEndpoint = "/v1/browse/categories";

    // variables
    public Response responseGet;
    public Response responsePost;

    @Step("sending get request with manually retrieved token")
    public void sendGetRequest(String endpoint) {
        String accessToken = Serenity.sessionVariableCalled("token").toString();
        responseGet = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + endpoint);
    }

    @Step("sending get request with app token")
    public void sendGetRequestWithAppToken(String endpoint) {
        String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
        System.out.println("Sending get request with this token" + accessToken);
        responseGet = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + endpoint);
    }

    @Step("receiving Get response status")
    public int getResponseStatusCode() {
        int responseCode = responseGet.then().extract().statusCode();
        return responseCode;
    }

    @Step("check post response status code")
    public int getPostResponseStatusCode() {
        int responseCode = responsePost.then().extract().statusCode();
        return responseCode;
    }

    @Step("returning response after Post")
    public Response returnPostResponse() {
        Response response = (Response) responsePost.then().extract();
        return response;
    }

    @Step("returning Get response")
    public Response returnGetResponse() {
        Response response = (Response) responseGet.then().extract();
        return response;
    }

    @Step("sending POST request")
    public void postRequest(String endpoint, String playListName) {
        // For post manually retrieved token is used
        String accessToken = Serenity.sessionVariableCalled("token").toString();
        responsePost = SerenityRest.given().header("Authorization", "Bearer " + accessToken).header("Accept", "string")
                .post(baseUrl + endpoint);
    }
}