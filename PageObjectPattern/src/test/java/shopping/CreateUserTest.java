package shopping;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import utils.TestDataGenerator;

public class CreateUserTest extends MainTestBase {

	@Test

	public void checkCreateUser() throws IOException {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickSignIn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		// Get & Save random email
		TestDataGenerator newEmail = new TestDataGenerator();
		newEmail.getRandomEmail();
		String newUserEmail = newEmail.getRandomEmail();
		newEmail.saveEmail(newUserEmail); // to save email into file

		loginPage.createNewUser(newUserEmail); // input email address
		loginPage.clickCreateButton();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Sign-in Form
		SignInFormPage newUserForm = PageFactory.initElements(driver, SignInFormPage.class);
		newUserForm.enterMainCredentials("Test", "Testoff", "Test1234");
		newUserForm.setDOB("10", "March", "1990");
		newUserForm.enterAddress("RandomName", "Last name", "any str", "New York", "NY", "10009", "123123123",
				"aliasAddress");
		newUserForm.clickRegisterButton();

		// Page after form submit
		UserPage page = PageFactory.initElements(driver, UserPage.class);

		// assert
		assertEquals("MY ACCOUNT", page.getHeader());

	}

}
