package shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPasswordPage extends PageObject {

	public ResetPasswordPage(WebDriver driver) {
		super(driver);
	}

	// Elements on the Page
	@FindBy(id = "email")
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"form_forgotpassword\"]//button")
	private WebElement submitButton;

	// element that appears after email submit
	@FindBy(how = How.XPATH, using = "//*[@class=\"alert alert-success\"]")
	WebElement successMessage;

	// Methods
	public void clickResetButton() {
		this.submitButton.click();
	}

	public void inputEmail(String email) {
		this.email.sendKeys(email);
	}

	public String getConfirmationMessage() {
		String confirmText = this.successMessage.getText();
		return confirmText;
	}
}