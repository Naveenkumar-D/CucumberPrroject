package stepDefination;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import factory.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ContactUsPage;
import pageObject.HomePage;
import utilities.DataReader;

public class ContactUsSteps {

	HomePage home;
	ContactUsPage contact = new ContactUsPage(BaseTest.getDriver());
	List<HashMap<String, String>> datamap;

	@Given("The user navigate to contactus page")
	public void the_user_navigate_to_contactus_page() {
		home = new HomePage(BaseTest.getDriver());
		home.contact();
	}

	@When("The user enter Subject Heading, Email address, Order reference and Message by using excel {string}")
	public void the_user_enter_subject_heading_email_address_order_reference_and_message_by_using_excel(String rows)
			throws IOException {
		datamap = DataReader.data("D:\\Selenium Projects\\CucumberProject\\src\\test\\resources\\excel\\Testdata.xlsx",
				"Contactus");

		int index = Integer.parseInt(rows) - 1;
		String subject = datamap.get(index).get("subject");
		String email = datamap.get(index).get("email");
		String order = datamap.get(index).get("orderRef");
		String msg = datamap.get(index).get("message");

		contact.enterSubhectHeading(subject);
		contact.enterEmailAddress(email);
		contact.enterOrderReference(order);
		contact.enterMessage(msg);

	}

	@Then("The user click on send button")
	public void the_user_click_on_send_button() {
		contact.clickSendButton();
	}

	@And("The user get the conformation message")
	public void the_user_get_the_conformation_message() {
		String actConMsg = contact.getConformationMsag();
		System.out.println(actConMsg);
		Assert.assertEquals(actConMsg, "Your message has been successfully sent to our team.");
	}
}
