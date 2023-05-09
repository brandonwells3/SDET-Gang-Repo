package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterLoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class ValidateLoginFunctionality {

	CraterLoginPage loginPage;
	BrowserUtils utils;

	String emailAddress;
	String passwordValue;

	// Valid Login
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
		Driver.getDriver().get(DataReader.getProperty("craterUrl"));

	}

	@When("User enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String password) {
		loginPage =new CraterLoginPage();
		utils = new BrowserUtils();
		emailAddress = email;
		passwordValue = password;
		utils.actionsSendKeys(loginPage.craterLoginEmailField,email);
		utils.actionsSendKeys(loginPage.craterLoginPassField, password);

	}

	@When("User click on login button")
	public void user_click_on_login_button() {

		loginPage.craterLoginLoginButton.click();

	}

	@Then("User should be directed on the Dashboard page.")
	public void user_should_be_directed_on_the_dashboard_page() {
		Assert.assertTrue(loginPage.accountSettingsHeader.isDisplayed());

	}

	// Invalid Login
	@When("User enters invalid {string} and invalid {string}")
	public void user_enters_invalid_and_invalid(String email, String password) throws InterruptedException {
		utils = new BrowserUtils();
		loginPage = new CraterLoginPage();
		utils.actionsSendKeys(loginPage.craterLoginEmailField, email);
		utils.actionsSendKeys(loginPage.craterLoginPassField, password);

	}

	@Then("User should see an error message {string} with a close button on the right")
	public void user_should_see_an_error_message(String errorMessage) {
		utils.waitUntilElementVisible(loginPage.invalidLoginErrorMessage);
		Assert.assertTrue(loginPage.invalidLoginErrorMessage.isDisplayed());
	}

	@Then("I click the X next on the right side of error message")
	public void i_click_the_x_next_on_the_right_side_of_error_message() {
		utils.waitUntilElementToBeClickable(loginPage.invalidLoginErrorMessageXBtn);
		utils.actionsClick(loginPage.invalidLoginErrorMessageXBtn);
	}

	@Then("The flash message should disapear in less than or equal to five seconds")
	public void the_flash_message_should_disapear_in_less_than_or_equal_to_five_seconds() throws InterruptedException {
		try {
			try {
				try {
					try {
						Assert.assertFalse("Error", loginPage.invalidLoginErrorMessageXBtn.isDisplayed());
					} catch (java.lang.AssertionError e) {
						Thread.sleep(3000);
						Assert.assertFalse("Error", loginPage.invalidLoginErrorMessageXBtn.isDisplayed());
						System.out.println("3 sec");
					}
				} catch (java.lang.AssertionError e) {
					Thread.sleep(1000);
					Assert.assertFalse("Error", loginPage.invalidLoginErrorMessageXBtn.isDisplayed());
					System.out.println("4 sec");
				}
			} catch (java.lang.AssertionError e) {
				Thread.sleep(1000);
				Assert.assertFalse("Error", loginPage.invalidLoginErrorMessageXBtn.isDisplayed());
				System.out.println("5 sec");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Element no longer present");
		}

	}

	@Then("User should not be logged in")
	public void user_should_not_be_logged_in() {
		Assert.assertTrue(loginPage.craterLoginPassField.isDisplayed());
	}

	// Invalid login, leaving empty email and password field
	@When("User leaves empty email {string} and password {string} field")
	public void user_leaves_empty_email_and_password_field(String email, String password) {
		utils = new BrowserUtils();
		loginPage = new CraterLoginPage();
		utils.actionsSendKeys(loginPage.craterLoginEmailField, email);
		utils.actionsSendKeys(loginPage.craterLoginPassField, password);

	}

	@Then("User should see the following {string} and  {string}")
	public void user_should_see_the_following_and(String string, String string2) {
		Assert.assertTrue(loginPage.fieldIsRequiredMessage.isDisplayed());

	}

}