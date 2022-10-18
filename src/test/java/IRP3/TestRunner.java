package IRP3;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", dryRun = false, monochrome = true, plugin = {
		"html:target/IRP.html" }

)
public class TestRunner {

}
