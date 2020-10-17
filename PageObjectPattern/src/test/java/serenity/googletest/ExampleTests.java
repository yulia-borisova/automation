package serenity.googletest;

import org.junit.Test;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.thucydides.core.annotations.Step;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

//log().all() - brings full response with data
//preemptive - used when credentials must be sent to the server without waiting
// !! created for investigation DON"T CHECK :)

public class ExampleTests {
    String accessToken = "BQCSzI2DP5T7KO1I4hf6OL9qxUQhiiCtjM1DWrrj9dnesQRc0uK-8FrFfhLKNDUNGfIZQ4G4eXleRu4Wdn85QyZXMGqjfVEEzkd5pEqPIuhRid28n1sIycptc8fe3o5cQxNj66jMCzbXYF-Q-xg30qpI08-E0f7FIq_GzsthlLcgMXLvfQu5TiC7jND0xkp8bWgRP3p4dvFTM3-Q3_3khxvbHVKUAbFy-yf2V8MHPR7thd3ANGSCUCGtbAcyqxXP9wJhFY6BbTlT-PkAcp34";
    String client_id = "07110c2def0d410d8a7894b92b6deca0";
    String client_secret = "cb71cb414028401086f78986e943636e";
    String grant_type = "client_credentials";
    String user_id = "czc11mg48dvwd16aeq0jofr3j";
    String redirect_uri = "http:open.spotify.com ";

    String url = "https://accounts.spotify.com/api/token"; // for application

    //@Test
    //validation not working
    public void getSimple() {
        given().auth().oauth2(accessToken).when().get("https://api.spotify.com/v1/me").andReturn().then()
                .statusCode(200).body("$", equalTo("Yulia"))
                .log().all();

    }
   
    // @Test 
     //app token is working for this request
    public void getRelease() {
        given()
        .auth()
        .oauth2(accessToken)
        .when()
        .get(
                "https://api.spotify.com/v1/browse/new-releases")
                .andReturn().then().statusCode(200)
                .log().all();
    }

    // @Test
    public void getTokenUser() {
        given().param("client_id", user_id).param("response_type", "token").param("redirect_uri", redirect_uri)
                .param("scope", "user-read-email").when().get("https://accounts.spotify.com/authorize").andReturn()
                .then().statusCode(200).log().all();

    }

   //  @Test
    public void getTokenOne() {
        given().auth().preemptive().basic(client_id, client_secret).param("grant_type", "client_credentials")
                .param("application", "application/x-www-form-urlencoded").when()
                .post("https://accounts.spotify.com/api/token").then()
                .log().all();

    }

   // @Test
    public void extractTokenApp() {
        Response response = RestAssured.given().auth().preemptive().basic(client_id, client_secret)
                .param("grant_type", "client_credentials").param("application", "application/x-www-form-urlencoded")
                .when().post("https://accounts.spotify.com/api/token").andReturn().then()
                .body("$", hasKey("access_token")).extract().response();
        String access_token = response.path("access_token").toString();
        System.out.println(access_token);
    }

    // @Test
    public void exampe() {
        given().relaxedHTTPSValidation().auth().basic("name", "password").param("grant_type", "client_credentials")
                .when().post("https://test_url/oauth/token").then().statusCode(200);
    }

    // @Test
    public void createPlayList() {
        // RestAssured.baseURI =
        // "https://api.spotify.com/v1/users/czc11mg48dvwd16aeq0jofr3j/playlists";
        String bodyData = "{\\\"name\\\":\\\"New Playlist\\\",\\\"description\\\":\\\"New playlist description\\\",\\\"public\\\":false}";
        RestAssured.given().contentType("application/json").header("Authorization", "Bearer" + accessToken)
                .header("Accept", "string").body(bodyData).when()
                .post("https://api.spotify.com/v1/users/czc11mg48dvwd16aeq0jofr3j/playlists").then().statusCode(200);
    }

    //@Test
    public void postExample() {
        RestAssured.baseURI = "https://api.spotify.com/v1/users/czc11mg48dvwd16aeq0jofr3j/playlists";
        RestAssured.given().body("{\n"+" \"name\":\"TEST1\",\n" +" \"public\":\"true\"\n"+"}")
        .header("Authorization", "Bearer " + accessToken).header("Accept","string")
                .post().then().statusCode(201).log().all();

    }
    @Test
    public void checkDataResponseRelease() {
        given()
        .auth()
        .oauth2(accessToken)
        .param("limit", "2")
        .when()
        .get(
                "https://api.spotify.com/v1/browse/new-releases")
                .andReturn().then().statusCode(200).body(".albums.items[0].artists[0].name", equalTo(".albums.items[0].artists[0].name"))
                .log().all();
    }
      // @Test
        public void checkDataResponseTwooo() {
            given().auth().oauth2(accessToken).param("limit", "100").when().get("https://api.spotify.com/v1/me").andReturn().then().body("email",
                    equalTo("yulia.borisowa.qa@gmail.com"));

        }
//weird way, TO DO
//        @Test("check presense of required fields") 
//        public boolean checkPresenseOfRequiredFields(String requiredField) {
//
//            ResponseBody body = responseGet.getBody();
//            String bodyStringValue = body.asString();
//            boolean result;
//            result = (bodyStringValue.contains(requiredField));
//            return result;
//
//        }


}

