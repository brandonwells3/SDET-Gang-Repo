package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterForgotPasswordPage;
import pages.CraterLoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;

public class forgotLoginFunctionalitySteps {

	CraterForgotPasswordPage forgotPage;
	CraterLoginPage loginPage;
	BrowserUtils utils;
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	//Test Case 1 Steps
	
	@When("I enter an invalid email to the rest field")
	public void i_enter_an_invalid_email_to_the_rest_field() {
		String invalidEntry = "taco@tuesday@gmail.com";
		forgotPage = new CraterForgotPasswordPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(forgotPage.ForgotPasswordEnterEmailTextBox, invalidEntry);
	}
	
	@Then("I should see an error message titled Incorrect Email")
	public void i_should_see_an_error_message_titled_incorrect_email() {
		utils.waitUntilElementVisible(forgotPage.ForgotPasswordIncorrectEmailErrorMess);
		Assert.assertTrue(forgotPage.ForgotPasswordIncorrectEmailErrorMess.isDisplayed());
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Test Case 2 Steps
	
	@When("I enter an empty email to the reset field")
	public void i_enter_an_empty_email_to_the_reset_field() {
		forgotPage = new CraterForgotPasswordPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(forgotPage.ForgotPasswordEnterEmailTextBox, " ");
	}
	
	@Then("I should see an error message titled Field is required")
	public void i_should_see_an_error_message_titled_field_is_required() {
		utils.waitUntilElementVisible(forgotPage.ForgotPasswordFieldRequiredErrorMess);
		Assert.assertTrue(forgotPage.ForgotPasswordFieldRequiredErrorMess.isDisplayed());
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	//Test Case 3 Steps
	
	@When("I enter a valid email to the reset field")
	public void i_enter_a_valid_email_to_the_reset_field() {
		forgotPage = new CraterForgotPasswordPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(forgotPage.ForgotPasswordEnterEmailTextBox, DataReader.getProperty("dummyUser"));
	}
	
	@When("I click on Send Rest Link button")
	public void i_click_on_send_rest_link_button() {
		forgotPage = new CraterForgotPasswordPage();
		forgotPage.ForgotPasswordSendRestBTN.click();
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Test Case 4 Steps
	
	@When("I click Back to Login? link")
	public void i_click_back_to_login_link() {
		forgotPage = new CraterForgotPasswordPage();
		forgotPage.ForgotPasswordBackToLoginLink.click();
	}
	
	@Then("I should be directed to the Login Page")
	public void i_should_be_directed_to_the_login_page() {
		loginPage = new CraterLoginPage();
		utils = new BrowserUtils();
		utils.waitUntilElementVisible(loginPage.crateHomePageForgotPasswordLink);
		Assert.assertTrue(loginPage.crateHomePageForgotPasswordLink.isDisplayed());
	}
}
