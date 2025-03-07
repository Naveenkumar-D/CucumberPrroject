package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;
	public static Properties config;
	
	@Before
	public void setup() throws IOException {
		driver=BaseTest.initiateBrowser();
		config=BaseTest.getProperties();
		
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@After
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		//if(scenario.isFailed()) {
			byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());
		//}
	}
}
