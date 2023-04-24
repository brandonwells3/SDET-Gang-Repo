package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterForgotPasswordPage;
import pages.CraterLoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;

public class forgotLoginRestLinkSteps {

	CraterForgotPasswordPage forgotPage;
	CraterLoginPage loginPage;
	BrowserUtils utils;
	
	
	
	@When("I enter dummy email")
	public void i_enter_dummy_email() {
		forgotPage = new CraterForgotPasswordPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(forgotPage.ForgotPasswordEnterEmailTextBox, DataReader.getProperty("dummyUser"));
	}
	
	@When("I go to gmail.com")
	public void i_go_to_gmail_com() {
		
		
	}
	@When("I open an email with the subject Rest Password Notification")
	public void i_open_an_email_with_the_subject_rest_password_notification() {
		
		
	}
	@Then("I should see an email reset link")
	public void i_should_see_an_email_reset_link() {
		
		
	}
	@When("I click the password reset link")
	public void i_click_the_password_reset_link() {
		
		
	}
	@Then("I should be directed to the password reset page")
	public void i_should_be_directed_to_the_password_reset_page() {
		
		
	}
	@Then("I should see three text fields")
	public void i_should_see_three_text_fields() {
		
		
	}

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Test Case 1 Steps	
	
	@When("I enter a valid email")
	public void i_enter_a_valid_email() {


	}
	@When("I enter a valid password")
	public void i_enter_a_valid_password() {


	}
	@When("I enter a valid retype password")
	public void i_enter_a_valid_retype_password() {


	}
	

	
	
	
	

	
	
}
