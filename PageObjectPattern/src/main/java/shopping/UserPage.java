package shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends PageObject {

	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements on the Page
	@FindBy(tagName = "h1")
	private WebElement userPageHeader;

	// Method to get a header of a logged-in User
	public String getHeader() {
		return userPageHeader.getText();
	}
}