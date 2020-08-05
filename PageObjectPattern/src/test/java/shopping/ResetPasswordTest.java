package shopping;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ResetPasswordTest extends MainTestBase {

    @Test
    public void checkPasswordReset() {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();

        ForgotPasswordPage forgotPass = new ForgotPasswordPage(driver);
        forgotPass.clickForgotPassword();

        ResetPasswordPage resetPass = new ResetPasswordPage(driver);
        resetPass.inputEmail(emailGenerator.getCreatedEmail());
        resetPass.clickResetButton();

        // assert
        assertTrue("message: Reset Password Test failed",
                resetPass.getConfirmationMessage().contains("email has been sent"));
    }
}