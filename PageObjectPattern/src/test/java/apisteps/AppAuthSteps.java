package apisteps;

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
    String accessToken = "BQCfB8ueLQovfCZ2a0A6rpAaiG9CEcyIBCb9U6hP8vlX8-ttJmn0H_qNoVaGbyGHqXuWnTMspiIYL7A8Ze2dGHQ41SIETM8yYSezXdL0wk8PBsxgsVkpIWvzSRM2hOcJyzBsfJgKV9Ty7FoQ7nfe2lokr467yxB9zxOnVK5TaphOFBMD_olDgh_9kfRrMQNgFjPCnwPWNNPuueDSqDKXSQRghAIji0tDYG54f00wXpWFqnU5pU3Su7YNf_4hf-Ii7xc0vaGnlmR3UNIwALEm";

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