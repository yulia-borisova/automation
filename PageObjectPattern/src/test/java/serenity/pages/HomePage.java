package serenity.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class HomePage extends UIInteractionSteps {

    MainPage page;

    By signInButton = By.xpath("//*[@title='Log in to your customer account']");

    @Step("Navigate to home page")
    public void openHomePage() {
        this.openUrl("http://automationpractice.com/index.php");
    }

    @Step("Click SignIn button")
    public void clickSignInButton() {
        $(this.signInButton).click();
    }
}