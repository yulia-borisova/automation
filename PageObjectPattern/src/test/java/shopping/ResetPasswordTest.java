package shopping;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ResetPasswordTest extends MainTestBase {

    @Test
    public void checkPasswordReset() {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();

        ResetPasswordPage resetPass = new ResetPasswordPage(driver);
        resetPass.inputEmail(emailGenerator.getCreatedEmail());
        resetPass.clickRetrievePasswordButton();

        // assert
        assertTrue("message: Reset Password Test failed",
                resetPass.getConfirmationMessage().contains("email has been sent"));
    }
}