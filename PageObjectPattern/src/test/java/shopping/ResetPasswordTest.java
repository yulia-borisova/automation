package shopping;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ResetPasswordTest extends MainTestBase {

	@Test
	public void checkPasswordReset() {
		driver.get(baseUrl + "/index.php?controller=authentication&back=my-account");
		ForgotPasswordPage forgotPass = new ForgotPasswordPage(driver);
		forgotPass.clickForgotPassword();

		ResetPasswordPage resetPass = new ResetPasswordPage(driver);
		resetPass.inputEmail("testshopping@mailinator.com");
		resetPass.clickResetButton();

		// assert
		assertTrue(resetPass.getConfirmationMessage().contains("email has been sent"));
	}
}