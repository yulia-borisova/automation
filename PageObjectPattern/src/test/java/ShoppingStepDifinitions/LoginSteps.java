package ShoppingStepDifinitions;

import io.cucumber.java.en.*;
import shopping.LoginPage;
import shopping.UserPage;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;

public class LoginSteps {
    WebDriver driver;

    @Given("User is on login page")
    public void getLoginPage() {
        System.out.println("Step 1: User is on login page");
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("User inputs valid {word} and {word}")
    public void inputCredentials(String email, String password) {
        System.out.println("Step 2: User inputs login and passowrd");
        LoginPage login = new LoginPage(driver);
        login.enterCredentials(email, password);
    }

    @And("clicks Login button")
    public void clickLoginButton() {
        System.out.println("Step 3: User clicks login button");
        LoginPage login = new LoginPage(driver);
        login.clickLoginButton();
    }

    @Then("User is navigated to My Account page")
    public void getUserAccountPage() {
        System.out.println("Step4: User is on login page");
        UserPage userPage = new UserPage(driver);
        assertEquals("assert:User Login failure", "MY ACCOUNT", userPage.getHeader());
    }
}