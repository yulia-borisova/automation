package apiSerenityStep;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.*;

public class SpotifyApiStep {
    String baseUrl = "https://api.spotify.com";
    String baseAppTokenUrl = "https://accounts.spotify.com/api/token";
    String userEmail = "yulia.borisowa.qa@gmail.com";
    String accessToken = "BQCoROD3yXhukxLeIlNj0iP8zve6-Lbbc_t19WBkDecjHosz3WwT1mEfCPn5WfL5xHC3QoqKQx5_vcVXwVgNJJJqwrTD2Bm-VbPH3CSrWesZKRzz4PyawpCrMd8jXx44Hh1Vz0zgQ-_IMHLFmTuS9RaqNLDWDYlxCLJV5uRZWtZ52NVmizokBOJos4aO9ZJGHRIYsUwOnWtygMPVKFhe54_ccIXp9y08pnf9Vx7mLA92uozxTphUpLNPGYo-E-9NG2fdsbuLlOveb2SMhWLO";
    String client_id = "07110c2def0d410d8a7894b92b6deca0";
    String client_secret = "cb71cb414028401086f78986e943636e";
    String appToken;
    Response responseGet;
    Response responsePost;
    String playListName;

    // useless step for now to implement later TO DO
    @Step("authorization, token generated manually on website")
    public String getAuthorized() {
        String accessToken = this.accessToken;
        return accessToken;

    }

    @Step("retrieve app access token")
    public String getAppToken() {
        Response responseToken = RestAssured.given().auth().preemptive().basic(client_id, client_secret)
                .param("grant_type", "client_credentials").param("application", "application/x-www-form-urlencoded")
                .when().post(baseAppTokenUrl).andReturn().then().body("$", hasKey("access_token")).extract().response();
        appToken = responseToken.path("access_token").toString();
        return appToken;
    }

    @Step("sending get request")
    public void sendGetRequest(String endpoint) {
        responseGet = SerenityRest.given().auth().oauth2(accessToken).get(baseUrl + endpoint);

    }

    @Step("sending get request with app token")
    public void sendGetRequestWithAppToken(String endpoint) {
        responseGet = SerenityRest.given().auth().oauth2(appToken).get(baseUrl + endpoint);
    }

    @Step("check Get response status")
    public int getResponseStatusCode() {
        int responseCode = responseGet.then().extract().statusCode();
        return responseCode;
    }

    @Step("check post response status code")
    public int getPostResponseStatusCode() {

        int responseCode = responsePost.then().extract().statusCode();
        return responseCode;
    }

//to check one field in response
    @Step("check valid data in Get response")
    public void checkIfDataIsValidGet(String requiredField, String responseData) {

        responseGet.then().assertThat().body(requiredField, equalTo(responseData));

    }

    @Step("sending POST request to create Playlist")
    public void createPlayList(String endpoint, String playListName) {

        responsePost = SerenityRest.given()
                .body("{\n" + " \"name\":\"" + playListName + "\",\n" + " \"public\":\"true\"\n" + "}")
                .header("Authorization", "Bearer " + accessToken).header("Accept", "string").post(baseUrl + endpoint);

    }

//to check one field in response
    @Step("check Post response and return boolean result")
    public boolean checkResponseAfterPost(String playListName) {

        String fieldName = responsePost.getBody().jsonPath().getString("name");
        boolean result;
        result = (fieldName.equals(playListName));
        return result;
    }

//to check many fields in response
    @Step("check multiple fields in Post response")
    public void checkFieldsInPostResponse(String playListName) {

        responsePost.then().assertThat().body("name", equalTo(playListName)).body("owner.id", equalTo("czc11mg48dvwd16aeq0jofr3j")).body("owner.display_name",
                equalTo("Yulia")).body("tracks.limit", equalTo(100));

    }

    @Step("check presense of required fields")
    public boolean checkPresenseOfRequiredFields(String requiredField) {

        ResponseBody body = responseGet.getBody();
        String bodyStringValue = body.asString();
        boolean result;
        result = (bodyStringValue.contains(requiredField));
        return result;

    }

    @Step("invalidate access token")
    public void invalidateAccessToken() {
        this.accessToken = "123";
    }
}