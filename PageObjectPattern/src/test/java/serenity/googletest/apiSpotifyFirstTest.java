package serenity.googletest;

import org.junit.Test;

import io.cucumber.java.Before;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
//log().all() - brings full response with data
//simple test , investigation

public class apiSpotifyFirstTest {
    String accessToken = "BQCEMBrfI20NGIyfLChrukiPDOAOtThIV_FySnSqydTwuyTLgKPIkNKQza_iBYK2uv4yCk5GGjcbC_Dl6PUKvoYENk-6BdZ_I5WN-jIgW1wZK5zWHYZYSTNRFUlG5bz9OMI0Ixzd3gyWUAVnAh30Q32iSUucIniZ-8xXEJET8-UhlJpvfj7C0wcIPjhdUQZlx4vcz6Mv3xK8EjQADCx8PdkMFyeoDf_Ad4qVEpqLX-XLIByM4CjXlLTIQa5jWMXYBXMQsN2T22t3h6GsHQiE";

   
    @Test
    public void testOne() {
       
        given().auth().oauth2(accessToken).when().get("https://api.spotify.com/v1/me").andReturn().then()
                .statusCode(200).log().all();

    }

    @Test
    public void testTwo() {
        given().auth().oauth2(accessToken).when().get("https://api.spotify.com/v1/me").andReturn().then().body("email",
                equalTo("yulia.borisowa.qa@gmail.com"));

    }

   // @Test
    public void testThree() {
        given().auth().oauth2(accessToken).when().get("https://api.spotify.com/v1/me")
        .andReturn().then().body("$",hasKey("email"));
    }
}
