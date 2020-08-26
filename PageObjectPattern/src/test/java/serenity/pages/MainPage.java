package serenity.pages;

import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://automationpractice.com/")
public class MainPage extends PageObject {
    public MainPage(WebDriver driver) {
        super(driver);
    }
}