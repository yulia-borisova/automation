package serenityCucumberStepDefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import serenity.pages.LoginPage;
import serenity.pages.MyAccountPage;

//Cucumber glue code, using regex
public class LoginStepDefinitions {

    @Steps
    LoginPage loginPage;

    @Steps
    MyAccountPage userPage;

    @Given("^Unauthenticated User is on Login Page$")
    public void getPage() {
        System.out.println("Step 1");
        loginPage.openLoginPage();
    }

    @When("^User inserts (.+) , (.+)$")
    public void inputCredentials(String login, String password) {
        System.out.println("Step 2");
        loginPage.inputCredentials(login, password);
    }

    @And("^Clicks Login button$")
    public void clickSignInButton() {
        System.out.println("Step 3");
        loginPage.clickSignIn();
    }

    @Then("^User gets logged in$")
    public void user_gets_logged_in() {
        System.out.println("Step 4");
        userPage.loginCheck().isTrue();
    }
}