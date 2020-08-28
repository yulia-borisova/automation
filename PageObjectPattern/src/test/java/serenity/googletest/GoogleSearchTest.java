package serenity.googletest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class GoogleSearchTest {

    @Managed
    WebDriver driver;

    @Test
    public void search() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("serenity-bdd", Keys.ENTER);
        assertTrue(("message: something went wrong"), driver.findElement(By.id("result-stats")).isDisplayed());
    }
}