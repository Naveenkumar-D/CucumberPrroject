package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id=\"email_create\"]")
	WebElement enterMail;

	@FindBy(xpath = "//span[normalize-space()='Create an account']")
	WebElement clickCreateButton;

	@FindBy(xpath = "//div//span//input[@id=\"id_gender1\"]")
	WebElement selectGender;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//button[@id='submitAccount']")
	WebElement clickRegister;

	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement getConformationMsg;

	public void enterMailAddress(String email) {
		enterMail.sendKeys(email);
	}

	public void clickCreateAccountButton() {
		clickCreateButton.click();
	}

	public void selectGender() {
		selectGender.click();
	}

	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickRegisterButton() {
		clickRegister.click();
	}

	public String getConformationMsag() {
		try {
			return getConformationMsg.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
