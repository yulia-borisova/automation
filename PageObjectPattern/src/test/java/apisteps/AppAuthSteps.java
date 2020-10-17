package apisteps;

import static org.hamcrest.Matchers.hasKey;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

//Shared class for authentication, only app Token is working properly
public class AppAuthSteps {
    String appToken;
    String baseAppTokenUrl = "https://accounts.spotify.com/api/token";

    // credentials and token variables
    String client_id = "07110c2def0d410d8a7894b92b6deca0";
    String client_secret = "cb71cb414028401086f78986e943636e";
    String accessToken = "BQBbLPke63ub47d-kmY9DTQzSFEo8M_eF8zVZDZobjF0f1i2w_ujl3LwzXuSdSbYNdfQZJf2z8ikqhPxXT55Grx7TT3ZOnpsvbK1WFHC_4U0PnbPm5zu1talRuLzN_noIw-FfAAoy9MXNPXJyiSmRayZWzYxJoPOvUddsfY4O_mTakDJE2gyrmZLVomtLyQcP0tPK9FusfvFqq8xgZk1j9fBhDxQtAuEJPHwV4yrvhHZHp7H8DhTl0fSVMk69KYlD6PvlqbQQnIn02q2qJkk";

    @Step("retrieve app access token")
    public String getAppToken() {
        Response responseToken = RestAssured.given().auth().preemptive().basic(client_id, client_secret)
                .param("grant_type", "client_credentials").param("application", "application/x-www-form-urlencoded")
                .when().post(baseAppTokenUrl).andReturn().then().body("$", hasKey("access_token")).extract().response();
        appToken = responseToken.path("access_token").toString();
        Serenity.setSessionVariable(BaseSteps.ACCESS_TOKEN).to(this.appToken);
        return appToken;
    }

    // TO DO: useless step for now to implement later
    @Step("authorization, token generated manually on website")
    public String getAuthorized() {
        String accessToken = this.accessToken;
        System.out.println("IT IS TOKEN :" + accessToken);
        Serenity.setSessionVariable(BaseSteps.ACCESS_MANUAL_TOKEN).to(this.accessToken);
        return accessToken;
    }

    @Step("invalidate access token")
    public String invalidateAccessToken() {
        appToken = "123";
        Serenity.setSessionVariable(BaseSteps.ACCESS_TOKEN).to(this.appToken);
        System.out.println("Invalid token is" + accessToken);
        return accessToken;
    }
}