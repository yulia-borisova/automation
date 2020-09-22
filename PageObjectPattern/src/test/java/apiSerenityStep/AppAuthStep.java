package apiSerenityStep;

import static org.hamcrest.Matchers.hasKey;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

//Shared class for authentication, only app Token is working properly
public class AppAuthStep {
    String appToken;
    String baseAppTokenUrl = "https://accounts.spotify.com/api/token";

    // credentials and token variables
    String client_id = "07110c2def0d410d8a7894b92b6deca0";
    String client_secret = "cb71cb414028401086f78986e943636e";
    String accessToken = "BQAsNpLTmLLRb-LzPk5Q8znn3uGG5SzrY3ZUqfleXtxmlzprr6CavuiKUSQ6bdeyjw0feM5DYRYHG2TnVGwrQ0jETPZ12D9ALhzKNI8bHNC1gG4VYkjSR1Gcmn5UXGK1Vk8UFAfcstxPYAnmgaz2vOijDLnobgOWchWTKD3wyeT4KKOfODedNBf3ev4OXHFvSXEsLp2RKUCWKm1jPWmQz3Wt59RnH9K9jJD7eHOq3qkSOVxaz8INw7t5s0VKPej-1I0t0xwKjjxFixZ45tpJ";

    @Step("retrieve app access token")
    public String getAppToken() {
        Response responseToken = RestAssured.given().auth().preemptive().basic(client_id, client_secret)
                .param("grant_type", "client_credentials").param("application", "application/x-www-form-urlencoded")
                .when().post(baseAppTokenUrl).andReturn().then().body("$", hasKey("access_token")).extract().response();
        appToken = responseToken.path("access_token").toString();
        Serenity.setSessionVariable("accessToken").to(this.appToken);
        return appToken;
    }

    // useless step for now to implement later TO DO //
    @Step("authorization, token generated manually on website")
    public String getAuthorized() {
        String accessToken = this.accessToken;
        System.out.println("IT IS TOKEN :" + accessToken);
        Serenity.setSessionVariable("token").to(this.accessToken);
        return accessToken;
    }

    @Step("invalidate access token")
    public String invalidateAccessToken() {
        appToken = "123";
        Serenity.setSessionVariable("accessToken").to(this.appToken);
        System.out.println("Invalid token is" + accessToken);
        return accessToken;
    }
}