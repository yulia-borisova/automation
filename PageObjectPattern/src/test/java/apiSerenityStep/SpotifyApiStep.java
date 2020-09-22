package apiSerenityStep;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.util.HashMap;
import java.util.Map;

// This class is used to customize api calls
public class SpotifyApiStep extends BaseStep {

    // getting one field
    @Step("getting one field from response")
    public String checkPresenseOfRequiredFields() {
        String oneString = responseGet.getBody().jsonPath().getString("albums.limit");
        return oneString;
    }

    @Step("sending POST request to create Playlist, endpoint: /v1/users/{userid}/playlists")
    public void postPlayList(String endpoint, String playListName) {
        String accessToken = Serenity.sessionVariableCalled("token").toString();
        System.out.println("sending POST request with this token" + accessToken);
        Map<String, Object> map = new HashMap<>();
        map.put("name", playListName);
        map.put("public", "true");
        responsePost = SerenityRest.given().body(map).header("Authorization", "Bearer " + accessToken)
                .header("Accept", "string").post(baseUrl + endpoint);
    }

    @Step("sending get request with app token and MAX Limit")
    public void getRequestWithMaxLimit(int limit) {
        String endpoint = "/v1/browse/categories";
        String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
        responseGet = SerenityRest.given().auth().oauth2(accessToken).param("limit", limit).get(baseUrl + endpoint);
    }
}