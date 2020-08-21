package ShoppingStepDifinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//To run Feature test suits with specified tags & save reports in different formats
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = { "ShoppingStepDifinitions" }, plugin = { "pretty",
        "json:target/JSONReports", "junit:target/JUnitReports" }, tags = "@smoketest")

public class TestRunner {
}