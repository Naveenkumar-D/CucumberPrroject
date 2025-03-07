package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[@class=\"login\"]")
	WebElement signIn;
	
	@FindBy(xpath = "//div[@id=\"contact-link\"]//a")
	 WebElement contactUs;
	
	public void login() {
		signIn.click();
	}
	public void contact() {
		contactUs.click();
	}
}
