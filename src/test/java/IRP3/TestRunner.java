package IRP3;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", dryRun = false, monochrome = true, plugin = {
		"html:target/cucumber-html-report.html" }

)
public class TestRunner {

}
