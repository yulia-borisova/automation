package shopping;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LoginTest extends MainTestBase {

    @Test
    public void checkValidLogin() {
        driver.get(baseUrl + "/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterCredentials(emailGenerator.getCreatedEmail(), "Test1234");
        loginPage.clickLoginButton();

        UserPage userPage = new UserPage(driver);

        // assert
        assertEquals("message :User Login Failed", "MY ACCOUNT", userPage.getHeader());
    }
}