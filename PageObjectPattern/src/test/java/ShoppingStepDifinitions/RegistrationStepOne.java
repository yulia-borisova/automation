package ShoppingStepDifinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import shopping.HomePage;
import shopping.LoginPage;
import shopping.SignInFormPage;

public class RegistrationStepOne {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignInFormPage formPage;

    @Given("New User is on Home Page")
    public void getHomePage() {
        System.out.println("Step 1: User is on login page");
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("Clicks SignIn")
    public void clickSignInButton() {
        homePage = new HomePage(driver);
        homePage.clickSignIn();
    }

    @And("New User Inputs {word}")
    public void inputEmail(String email) {
        loginPage = new LoginPage(driver);
        loginPage.createNewUser(email);
    }

    @And("Clicks Create an Account")
    public void clickCreateAccountButton() {
        loginPage = new LoginPage(driver);
        loginPage.clickCreateButton();
    }

    @Then("User is redirected to SignIn Form Page")
    public void getFormPage() {
        formPage = new SignInFormPage(driver);
        String actualURL = formPage.getUrl();
        String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        assertEquals("message: Registration Step 1 failed, wrong actual URL", expectedURL, actualURL);
    }
}