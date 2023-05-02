package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import pages.CraterLoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class LoginUIComponents {

	CraterLoginPage loginPage;
	BrowserUtils utils;

	@Given("As a user, I am on the Login Page of crater App.")
	public void as_a_user_i_am_on_the_login_page_of_crater_app() throws InterruptedException {
		Driver.getDriver().get(DataReader.getProperty("craterUrl"));

	}

	@Given("I should see Page Title {string}")
	public void i_should_see_page_title(String title) throws InterruptedException {
		loginPage = new CraterLoginPage();
		Assert.assertTrue(loginPage.craterTitle.isDisplayed());

	}

	@Given("I should be able to see a Text Box with the Label {string}")
	public void i_should_be_able_to_see_a_text_box_with_the_label(String email) {
		loginPage = new CraterLoginPage();
		Assert.assertTrue(loginPage.lableEmail.isDisplayed());

	}

	@Given("I sholud see a Text Box with the lable {string}")
	public void i_sholud_see_a_text_box_with_the_lable(String password) {
		loginPage = new CraterLoginPage();
		Assert.assertTrue(loginPage.lablePassword.isDisplayed());
	}

	@Given("I should see a link titled {string}")
	public void i_should_see_a_link_titled(String string) {
		loginPage = new CraterLoginPage();
		Assert.assertTrue(loginPage.crateHomePageForgotPasswordLink.isDisplayed());

	}

	@Given("I should see a primary button labled {string}")
	public void i_should_see_a_primary_button_labled(String string) {
		loginPage = new CraterLoginPage();
		Assert.assertTrue(loginPage.craterLoginLoginButton.isDisplayed());
	}

	@Given("I should see a Text area on the bottom left {string}")
	public void i_should_see_a_text_area_on_the_bottom_left(String string) {
		loginPage = new CraterLoginPage();
		Assert.assertTrue(loginPage.textAreaOnButtomLeft.isDisplayed());
	}

	@Given("I should see the first Heading with the following text {string}")
	public void i_should_see_the_first_heading_with_the_following_text(String string) {
		loginPage = new CraterLoginPage();
		Assert.assertTrue(loginPage.firstHeading.isDisplayed());

	}

	@Given("I should see the second Heading {string}")
	public void i_should_see_the_second_heading(String string) {
		loginPage = new CraterLoginPage();
		Assert.assertTrue(loginPage.secondHeading.isDisplayed());

	}

}
