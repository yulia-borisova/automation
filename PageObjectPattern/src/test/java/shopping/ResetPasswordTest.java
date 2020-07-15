package shopping;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordTest extends MainTestBase {

	@Test
	public void checkPasswordReset() {

		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		ForgotPasswordPage forgotPass = PageFactory.initElements(driver, ForgotPasswordPage.class);
		forgotPass.clickForgotPassword();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ResetPasswordPage resetPass = PageFactory.initElements(driver, ResetPasswordPage.class);
		resetPass.inputEmail("testshopping@mailinator.com");
		resetPass.clickResetButton();

		// assert
		assertTrue(resetPass.getConfirmationMessage().contains("email has been sent"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
