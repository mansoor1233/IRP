package IRP3;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "Feature" },
		 //glue = "Stepdefinition",
		//tags = "@DecisionMaker,@Table", 
				publish = true,
				plugin = { "html:target/Appian3.html" }, monochrome = true

)
public class TestRunner {  

}
