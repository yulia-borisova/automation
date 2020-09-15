package serenitycucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {
        "pretty" }, features = "classpath:features/apitest/spotifyPOST.feature", glue = "apiSerenityStep")
public class OneTestRunner {

}