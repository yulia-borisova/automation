package apiSerenityStep;

import static org.hamcrest.Matchers.hasKey;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

//Shared class for authentication, only app Token is working properly
public class AppAuthSteps{
    String appToken;
    String baseAppTokenUrl = "https://accounts.spotify.com/api/token";

    // credentials and token variables
    String client_id = "07110c2def0d410d8a7894b92b6deca0";
    String client_secret = "cb71cb414028401086f78986e943636e";
    String accessToken = "BQCV1cu7IsgdZ1oNWqF-UqILI3xAxx_ShWu_CqydEhVJIAH_L7t8RAEhyG23R5Xbnl-YaAUNGAqg3Ni85YGde8mapPQT5X4cKx5Ws4r-3miy8Tunv0j_i7gVYjtcqTo-izzs-F5cPAqc-l9Yke0L8nMwy7BL01yN1lmoLtd26MErjqW5W9KnK6L-e8n3BLub038VqrZ6Jd4MAX95W2rT2uGBXOuOxP3tZ5G_Ajq6iSp_iZxGn27uKskrM0b2AHd7eZludbe8VfLx_vdSu711";

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