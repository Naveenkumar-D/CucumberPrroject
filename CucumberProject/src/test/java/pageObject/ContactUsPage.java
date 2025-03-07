package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//select[@id='id_contact']")
	WebElement subjectHeading;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='id_order']")
	WebElement OrderReference;

	@FindBy(xpath = "//span[normalize-space()='Send']")
	WebElement clickSend;

	@FindBy(xpath = "//textarea[@id='message']")
	WebElement msg;

	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement getConformationMsg;

	public void enterSubhectHeading(String subject) {
		subjectHeading.sendKeys(subject);
	}

	public void enterEmailAddress(String email) {
		emailAddress.sendKeys(email);
	}

	public void enterOrderReference(String orderRef) {
		OrderReference.sendKeys(orderRef);
	}

	public void enterMessage(String message) {
		msg.sendKeys(message);
	}

	public void clickSendButton() {
		clickSend.click();
	}

	public String getConformationMsag() {
		try {
			return getConformationMsg.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
