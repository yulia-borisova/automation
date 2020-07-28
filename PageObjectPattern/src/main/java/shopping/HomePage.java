package shopping;
//Test home page
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends PageObject {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	// Elements on the Page
	@FindBy(how = How.XPATH, using = "//*[@class=\"login\"]")
	WebElement buttonSignIn;

	public LoginPage clickSignIn() {
		this.buttonSignIn.click();
		return new LoginPage(driver);
	}
}