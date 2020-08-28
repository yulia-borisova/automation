package serenityCucumberStepDefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import serenity.pages.ForgotPasswordPage;
import serenity.pages.HomePage;
import serenity.pages.LoginPage;

public class RetrievePassStepDefinitions {
    @Steps
    HomePage homePage;

    @Steps
    LoginPage loginPage;

    @Steps
    ForgotPasswordPage forgotPage;

    @Given("Unauthenticated User is on Home Page")
    public void getHomePage() {
        System.out.println("Step 1");
        homePage.openHomePage();
    }

    @When("User clicks SignIn button")
    public void clickSignInButton() {
        System.out.println("Step 2");
        homePage.clickSignInButton();
    }

    @And("Clicks Forgot Password Link on Login Page")
    public void clickForgotPasswordLink() {
        System.out.println("Step 3");
        loginPage.clickForgotPasswordLink();
    }

    @And("Inputs {word} on Forgot Password Page")
    public void inputEmail(String email) {
        System.out.println("Step 4");
        forgotPage.inputEmailAddress(email);
    }

    @And("Clicks Retrieve Password button")
    public void clickRetrievePasswordButton() {
        System.out.println("Step 5");
        forgotPage.clickRetrievePasswordButton();
    }

    @Then("Password is retrieved and Confirmation message is received")
    public void getConfirationMessage() {
        System.out.println("Step 6");
        forgotPage.checkMessage().isTrue();
    }
}