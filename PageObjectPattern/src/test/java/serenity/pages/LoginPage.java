package serenity.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginPage extends UIInteractionSteps {
    MainPage mainPage;

    By emailAddressField = By.name("email");
    By passwordField = By.id("passwd");
    By signInButton = By.id("SubmitLogin");
    By forgotPasswordLink = By.xpath("//*[@title=\"Recover your forgotten password\"]");

    @Step("Open Login page")
    public void openLoginPage() {
        this.openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Step("User provides credentials")
    public void inputCredentials(String login, String password) {
        this.$(emailAddressField).sendKeys(login);
        this.$(passwordField).sendKeys(password);
    }

    @Step("User clicks SignIn button")
    public void clickSignIn() {
        $(this.signInButton).click();
    }

    @Step("User clicks Forgot Password link")
    public void clickForgotPasswordLink() {
        $(this.forgotPasswordLink).click();
    }
}