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
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.DataReader;

public class LoginToApplicationSteps {

	HomePage home;
	LoginPage login = new LoginPage(BaseTest.getDriver());
	List<HashMap<String, String>> datamap;

	@Given("The user navigate to login page")
	public void the_user_navigate_to_login_page() {
		home = new HomePage(BaseTest.getDriver());
		home.login();

	}

	@When("The user enter Email address and Password by using excel {string}")
	public void the_user_enter_email_address_and_password_by_using_excel(String rows) throws IOException {
		datamap = DataReader.data("D:\\Selenium Projects\\CucumberProject\\src\\test\\resources\\excel\\Testdata.xlsx",
				"Login");

		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("username");
		String pass = datamap.get(index).get("password");
		//String res = datamap.get(index).get("res");

		login.enterEmailAddress(email);
		login.enterPassword(pass);
		//login.clickSignInButton();


	}

	@Then("The user click on sign in button")
	public void the_user_click_on_sign_in_button() {

		login.clickSignInButton();
	}

	@And("The user should be redirect to the my account page")
	public void the_user_should_be_redirect_to_the_my_account_page() {
		boolean status = login.isMyAccountExist();
		System.out.println(status);
		Assert.assertEquals(status, true);
	}

	@And("the user get the title of the login page")
	public void the_user_get_the_title_of_the_login_page() {

		String actualTitle = BaseTest.getDriver().getTitle();
		System.out.println(actualTitle);
	}

}
