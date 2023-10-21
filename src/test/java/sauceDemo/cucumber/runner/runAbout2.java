package sauceDemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sauceDemo/cucumber/features/about2.feature",
        glue = "sauceDemo.cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"}
)

public class runAbout2 {
}