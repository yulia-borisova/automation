package shopping;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;

public class CreateUserTest extends MainTestBase {

	@Test
	public void checkCreateUser() throws IOException {
		driver.get(baseUrl);
		HomePage homePage = new HomePage(driver);
		homePage.clickSignIn();

		LoginPage loginPage = new LoginPage(driver);
		String newRegisterEmail = emailGenerator.getRandomEmail();
		emailGenerator.saveEmail(newRegisterEmail);
		loginPage.createNewUser(newRegisterEmail); // input email address
		loginPage.clickCreateButton();

		// Sign-in Form
		SignInFormPage newUserForm = new SignInFormPage(driver);
		newUserForm.enterMainCredentials("Ivan", "Ivanoff", "Test1234");
		newUserForm.setDOB("10", "March", "1990");
		newUserForm.enterAddress("Ivan", "Ivanoff", "Oxford str", "New York", "NY", "10009", "123123123",
				"aliasAddress");
		newUserForm.clickRegisterButton();

		// Page after form submit
		UserPage userPage = new UserPage(driver);

		// assert
		assertEquals("MY ACCOUNT", userPage.getHeader());
	}
}