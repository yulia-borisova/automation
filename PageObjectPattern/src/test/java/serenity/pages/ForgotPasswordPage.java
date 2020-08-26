package serenity.pages;

import org.openqa.selenium.By;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.ensure.BooleanEnsure;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

//Elements and Methods on Forgot password page
public class ForgotPasswordPage extends UIInteractionSteps {

    MainPage mainPage;

    // Elements
    By userEmailField = By.id("email");
    By retrivePasswordButton = By.xpath("//*[@id='form_forgotpassword']//button");
    By successMessage = By.xpath("//*[@class='alert alert-success']");

    @Step("User inputs email address to retrieve password")
    public void inputEmailAddress(String email) {
        $(this.userEmailField).clear();
        $(this.userEmailField).sendKeys(email);
    }

    @Step("User clicks Retrieve Password button")
    public void clickRetrievePasswordButton() {
        $(this.retrivePasswordButton).click();
    }

    @Step("User gets confirmation message")
    public BooleanEnsure checkMessage() {
        BooleanEnsure message = Ensure.that($(this.successMessage).containsText("A confirmation email has been sent"));
        return message;
    }
}