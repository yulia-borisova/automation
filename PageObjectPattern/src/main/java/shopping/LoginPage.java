package shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Elements on the Page
	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement submitButton;

	// Elements on the page to Create account

	@FindBy(id = "email_create")
	private WebElement emailCreate;

	@FindBy(id = "SubmitCreate")
	private WebElement submitCreateButton;

	// Methods used on the page to LOGIN

	public void enterCredentials(String email, String password) {
		this.email.sendKeys(email);
		this.password.sendKeys(password);
	}

	public UserPage clickLoginButton() {
		this.submitButton.click();
		return new UserPage(driver);
	}

	// Methods to CREATE account

	public void createNewUser(String emailCreate) {
		this.emailCreate.sendKeys(emailCreate);
	}

	public SignInFormPage clickCreateButton() {
		this.submitCreateButton.click();
		return new SignInFormPage(driver);
	}

}
