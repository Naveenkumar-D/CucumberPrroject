package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties config;
	public static Logger log;
	
	public static WebDriver initiateBrowser() throws IOException {
		config=getProperties();
		String browser= config.getProperty("browser");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		return driver;
	}
	
	public static Properties getProperties() throws IOException {
		config= new Properties();
		fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		return config;
	}
	public static Logger getLogger() {
		log= LogManager.getLogger();
		return log;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static String randomAlphaNumeric() {
		String str= RandomStringUtils.randomAlphabetic(10);
		String ram= RandomStringUtils.randomAlphanumeric(5);
		return str+ram;
	}
}
