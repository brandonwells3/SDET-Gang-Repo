package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty",
				"html:test_results/cucmber_report.html",
				"json:test_results/cucumber_report.json"},
		features = "./src/test/resources/features",
		glue = "step_definitions",
		tags = "@createCustomerNewCustomerUIComponentValidationBasicInfoANDPortalAcess"
		)



public class TestRunner {

	
	
	
}
