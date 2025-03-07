package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement enterPassword;

	@FindBy(xpath = "//span[normalize-space()='Sign in']")
	WebElement clickSignIn;

	@FindBy(xpath = "//h1[normalize-space()='My account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement signOut;

	public void enterEmailAddress(String email) {
		enterEmail.sendKeys(email);
	}

	public void enterPassword(String passwd) {
		enterPassword.sendKeys(passwd);
	}

	public void clickSignInButton() {
		clickSignIn.click();
	}

	public boolean isMyAccountExist() {
		return myAccount.isDisplayed();
	}

	public void cickSignOut() {
		signOut.click();
	}

}
