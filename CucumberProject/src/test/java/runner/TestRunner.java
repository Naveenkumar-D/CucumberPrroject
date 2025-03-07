package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".//Features", glue = { "stepDefination", "hooks" }, plugin = {
		"html:reports/myreport.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false, monochrome = true, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
