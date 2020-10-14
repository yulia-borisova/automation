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
    String accessToken = "BQCzUzh_6YGyXfv38pRtze3mHa-stWEGtem48MoKZOLulGepDZzKiYm4vBqMQ84LY8q0Cj0ag2-Bs4e809u0v4W7oHkLKJfT8zvjgaUsrzBnL1GSfZkqTgmC0fJ3rSdDBvCz8JTK561oVFmKitOfSCDm_wZ7s75LEwLIYsRJJis3R179oYDpd7iwloxMM5eHR65zTWsLpdLvzYajY7lBFCCqidcmba_LB_3C8dW5UStBL2CXK0DIZ80Vi8-IKlwF_1QkyBm8hipnyu1_2QCI";

    @Step("retrieve app access token")
    public String getAppToken() {
        Response responseToken = RestAssured.given().auth().preemptive().basic(client_id, client_secret)
                .param("grant_type", "client_credentials").param("application", "application/x-www-form-urlencoded")
                .when().post(baseAppTokenUrl).andReturn().then().body("$", hasKey("access_token")).extract().response();
        appToken = responseToken.path("access_token").toString();
        Serenity.setSessionVariable("accessToken").to(this.appToken);
        return appToken;
    }

    // TO DO: useless step for now to implement later
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