package shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends PageObject {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	// Elements on the Page
	@FindBy(how = How.LINK_TEXT, using = "Forgot your password?")
	WebElement forgotPass;

	// Method
	public ResetPasswordPage clickForgotPassword() {
		this.forgotPass.click();
		return new ResetPasswordPage(driver);
	}
}