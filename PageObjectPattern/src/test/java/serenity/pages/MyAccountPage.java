package serenity.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.steps.UIInteractionSteps;
// To locate element after successful login
import net.serenitybdd.screenplay.ensure.BooleanEnsure;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

public class MyAccountPage extends UIInteractionSteps {
    MainPage page;

    By myInfo = By.xpath("//*[@class='myaccount-link-list']");

    @Step("Check successfull login")
    public BooleanEnsure loginCheck() {

        BooleanEnsure result = Ensure.that($(this.myInfo).isDisplayed());
        return result;
    }
}