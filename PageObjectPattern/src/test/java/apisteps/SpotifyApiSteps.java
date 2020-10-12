package apisteps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

//responseGet changed to response
// This class is used to customize api calls
public class SpotifyApiSteps extends BaseSteps {

    @Step("sending POST request to create Playlist, endpoint: /v1/users/{user_id}/playlists")
    public Response postPlayList(String id, String playListName) {
        String accessToken = Serenity.sessionVariableCalled("token").toString();
        System.out.println("sending POST request with this token" + accessToken);
        Map<String, Object> map = new HashMap<>();
        map.put("name", playListName);
        map.put("public", true);
        response = SerenityRest.given().body(map).header("Authorization", "Bearer " + accessToken)
                .header("Accept", "string").pathParam("user_id", id).post(baseUrl + playListEndpoint);
        Serenity.setSessionVariable("responseCode").to(response.getStatusCode());
        return response;

    }

    @Step("sending GET request to newReleases endpoint with app token")
    public Response getNewReleases() {
        String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
        response = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + releasesEndpoint);
        Serenity.setSessionVariable("responseCode").to(response.getStatusCode());
        return response;
    }

    @Step("sending GET request to categories endpoint with app token")
    public Response getCategories() {
        String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
        response = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + categoriesEndpoint);
        Serenity.setSessionVariable("responseCode").to(response.getStatusCode());
        return response;
    }

    @Step("sending GET categories request with app token and MAX Limit = {0}")
    public Response getRequestWithMaxLimit(int limit) {
        String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
        response = SerenityRest.given().auth().oauth2(accessToken).param("limit", limit)
                .get(baseUrl + categoriesEndpoint);
        Serenity.setSessionVariable("responseCode").to(response.getStatusCode());
        return response;
    }

    @Step("sending GET request with simple token to me endpoint")
    public Response getRequestToMe() {
        String accessToken = Serenity.sessionVariableCalled("token").toString();
        response = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + meEndpoint);
        Serenity.setSessionVariable("responseCode").to(response.getStatusCode());
        return response;
    }
}