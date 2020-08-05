package shopping;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;

public class CreateUserTest extends MainTestBase {

    @Test
    public void checkCreateUser() throws IOException, InterruptedException {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        String newRegisterEmail = emailGenerator.getRandomEmail();
        loginPage.createNewUser(newRegisterEmail); // input email address
        loginPage.clickCreateButton();

        // Sign-in Form
        SignInFormPage newUserForm = new SignInFormPage(driver);
        newUserForm.enterMainCredentials(testUser.getFirstName(), testUser.getLastName(), testUser.getPassword());
        newUserForm.setDOB(testUser.getDay(), testUser.getMonth(), testUser.getYear());
        newUserForm.enterAddress(testUser.getFirstName(), testUser.getLastName(), testUser.getAddress(),
                testUser.getCity(), testUser.getState(), testUser.getZip(), testUser.getPhone(), testUser.getAlias());
        newUserForm.clickRegisterButton();

        // Page after form submit
        UserPage userPage = new UserPage(driver);

        // assert
        assertEquals("message:Create User Test failed", "MY ACCOUNT", userPage.getHeader());
    }
}