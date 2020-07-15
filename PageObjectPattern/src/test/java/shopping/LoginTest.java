package shopping;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class LoginTest extends MainTestBase {

	@Test
	public void checkValidLogin() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterCredentials("testshopping@mailinator.com", "Test1234");
		loginPage.clickLoginButton();

		UserPage userPage = PageFactory.initElements(driver, UserPage.class);

		// assert
		assertEquals("MY ACCOUNT", userPage.getHeader());

	}

}
