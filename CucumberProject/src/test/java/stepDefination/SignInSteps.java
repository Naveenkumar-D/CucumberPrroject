package stepDefination;

import java.util.Map;

import org.testng.Assert;

import factory.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.SignInPage;

public class SignInSteps {

	HomePage home;
	SignInPage signin = new SignInPage(BaseTest.getDriver());

	@Given("The user navigate to sign in page")
	public void the_user_navigate_to_sign_in_page() {
		home = new HomePage(BaseTest.getDriver());
		home.login();
	}

	@When("The User enter email address")
	public void the_user_enter_email_address() {
		signin.enterMailAddress(BaseTest.randomAlphaNumeric() + "@gami.com");
	}

	@Then("The user click on create an account button")
	public void the_user_click_on_button() {
		signin.clickCreateAccountButton();
	}

	@And("The user click on Gender")
	public void the_user_click_on_gender() {
		signin.selectGender();

	}

	@Then("The user enter details into bellow feilds")
	public void the_user_enter_details_into_bellow_feilds(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		signin.enterFirstName(data.get("firstName"));
		signin.enterLastName(data.get("lastName"));
		signin.enterPassword(data.get("password"));
	}

	@And("The user click on Register button")
	public void the_user_click_on_register_button() {
		signin.clickRegisterButton();
	}

	@And("the user get the title of the SignIn page")
	public void the_user_get_the_title_of_the_sign_in_page() {
		String actualMsg = signin.getConformationMsag();
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Your account has been created.");
	}
}
