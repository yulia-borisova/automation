package apisteps;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

//class contains all basic steps
public class BaseSteps {
    AppAuthSteps auth;

    // base Urls
    String baseAppTokenUrl = "https://accounts.spotify.com/api/token";
    String baseUrl = "https://api.spotify.com";
    String categoriesEndpoint = "/v1/browse/categories";
    String releasesEndpoint = "/v1/browse/new-releases";
    String newReleasesEndpoint = "/v1/browse/new-releases";
    String meEndpoint = "/v1/me";
    String playListEndpoint = "/v1/users/{user_id}/playlists";

    // variables
    public Response response;
    
    //Serenity global session variables
   public static final String RESPONSE_CODE = "responseCode";
   public static final String ACCESS_TOKEN = "access_token";
   public static final String ACCESS_MANUAL_TOKEN = "token";
    
    @Step("sending get request with manually retrieved token")
    public Response sendGetRequest(String endpoint) {
        String accessToken = Serenity.sessionVariableCalled(ACCESS_MANUAL_TOKEN).toString();
        response = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + endpoint);
        Serenity.setSessionVariable(RESPONSE_CODE).to(response.getStatusCode());
        return response;
    }

    @Step("sending get request with app token")
    public Response sendGetRequestWithAppToken(String endpoint) {
        String accessToken = Serenity.sessionVariableCalled(ACCESS_TOKEN).toString();
        System.out.println("Sending get request with this token" + accessToken);
        response = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + endpoint);
        Serenity.setSessionVariable(RESPONSE_CODE).to(response.getStatusCode());
        return response;
    }
}