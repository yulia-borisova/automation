package ShoppingStepDifinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import shopping.HomePage;
import shopping.LoginPage;
import shopping.MainTestBase;
import shopping.ResetPasswordPage;

public class ResetPasswordSteps {
    WebDriver driver;
    MainTestBase testBase;
    HomePage homePage;
    LoginPage loginPage;
    ResetPasswordPage resetPassPage;

    @Given("User is on Home page")
    public void getHomePage() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("User clicks Sign-in button")
    public void clickSignInButton() {
        homePage = new HomePage(driver);
        homePage.clickSignIn();
        System.out.println("Step 2: User clicks signin button");
    }

    @When("User clicks Forgot your passoword link")
    public void clickForgotLink() {
        loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();
        System.out.println("Step 3: User clicks forgot pass link");
    }

    @When("User inputs {word}")
    public void inputEmail(String email) {
        resetPassPage = new ResetPasswordPage(driver);
        resetPassPage.inputEmail(email);
        System.out.println("Step 4: User is on home page");
    }

    @When("User clicks Retrieve password")
    public void clickRetrivePassword() {
        resetPassPage = new ResetPasswordPage(driver);
        resetPassPage.clickRetrievePasswordButton();
        System.out.println("Step 5: clicks retrive");
    }

    @Then("User gets a confirmation message")
    public void getConfirmationMessage() {
        System.out.println("Step 6: Getting confirmation message");
        resetPassPage = new ResetPasswordPage(driver);
        resetPassPage.getConfirmationMessage();
        assertTrue("message: Reset Password Test failed",
                resetPassPage.getConfirmationMessage().contains("email has been sent"));
    }
}