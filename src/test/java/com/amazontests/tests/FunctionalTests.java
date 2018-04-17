package com.amazontests.tests;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target//cucumber/TestResult.json","html:target//cucumber-html-reports/"},
        features = "target//test-classes/features/",
        glue = {"com.amazontests.steps", "com.amazon.utils"}, tags = {"@Functional"}, monochrome = true)

public class FunctionalTests {


}
