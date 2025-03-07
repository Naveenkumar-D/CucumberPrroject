package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseTest;
import pageObject.ContactUsPage;
import pageObject.HomePage;

public class Test {
	public static WebDriver driver;
	public static Properties config;
	static List<HashMap<String, String>> datamap;
	public static void main(String[] args) throws IOException {
		driver=BaseTest.initiateBrowser();
		config=BaseTest.getProperties();
		
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage home=new HomePage(BaseTest.getDriver());
		   home.contact();
//		 LoginPage login=new LoginPage(BaseTest.getDriver());
//		 login.enterEmailAddress("pavanoltraining1@gmail.com");
//		 login.enterPassword("test@123");
//		 login.clickSignInButton();
		
		ContactUsPage contact= new ContactUsPage(BaseTest.getDriver());
		//contact.enterSubhectHeading("Customer service");
		try {
			datamap = DataReader.data("D:\\Selenium Projects\\CucumberProject\\src\\test\\resources\\excel\\Testdata.xlsx",
					"Contactus");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String subject = datamap.get(0).get("subject");
		String email = datamap.get(0).get("email");
		String order = datamap.get(0).get("orderRef");
		String msg = datamap.get(0).get("message");
		
		System.out.println(subject);
	}

}
