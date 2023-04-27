package step_definitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;


import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterForgotPasswordPage;
import pages.CraterLoginPage;
import pages.CraterPasswordResetPage;
import pages.GmailEmailPage;
import pages.GmailSignInPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class forgotLoginRestLinkSteps {

	CraterForgotPasswordPage forgotPage;
	CraterLoginPage loginPage;
	BrowserUtils utils;
	GmailSignInPage GSIPage;
	GmailEmailPage GEPage;
	CraterPasswordResetPage ResetPage;
	Robot robert;
	
	
	@When("I enter dummy email to the email rest field")
	public void i_enter_dummy_email_to_the_email_rest_field() {
		forgotPage = new CraterForgotPasswordPage();
		utils = new BrowserUtils();
		try {
			utils.waitUntilElementVisible(forgotPage.ForgotPasswordEnterEmailTextBox);
			utils.actionsSendKeys(forgotPage.ForgotPasswordEnterEmailTextBox, DataReader.getProperty("dummyUser"));
		}catch (org.openqa.selenium.StaleElementReferenceException e) {
			utils.waitUntilElementVisible(forgotPage.ForgotPasswordEnterEmailTextBox);
			utils.actionsSendKeys(forgotPage.ForgotPasswordEnterEmailTextBox, DataReader.getProperty("dummyUser"));
			}
		}
	
	@When("I click Send Reset Link button")
	public void i_click_send_reset_link_button() {
		forgotPage = new CraterForgotPasswordPage();
		forgotPage.ForgotPasswordSendRestBTN.click();
	}
	
	@Then("I should see a popup alert Success!")
	public void i_should_see_a_popup_alert_success() {
		forgotPage = new CraterForgotPasswordPage();
		utils = new BrowserUtils();
		try {
			Assert.assertTrue(forgotPage.ForgotPasswordSUMessPopUp.isDisplayed());
		}catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertTrue(forgotPage.ForgotPasswordERRMessPopUp.isDisplayed());
		}
	}  
	
	@When("I go to gmail.com")
	public void i_go_to_gmail_com() throws AWTException, InterruptedException {
		robert = new Robot();
		robert.keyPress(KeyEvent.VK_CONTROL);
		robert.keyPress(KeyEvent.VK_T);
		Thread.sleep(1000);
		robert.keyRelease(KeyEvent.VK_T);
		robert.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		
		StringSelection selection = new StringSelection(DataReader.getProperty("gmailUrl"));
		Clipboard clipy = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipy.setContents(selection, selection);
		
		robert.keyPress(KeyEvent.VK_CONTROL);
		robert.keyPress(KeyEvent.VK_V);
		robert.keyRelease(KeyEvent.VK_V);
		robert.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		
		robert.keyPress(KeyEvent.VK_ENTER);
		robert.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		
		Set <String> windowIds = Driver.getDriver().getWindowHandles();
		Iterator<String> ids = windowIds.iterator();
		ids.next();
		String NewWindowID = ids.next();
		Driver.getDriver().switchTo().window(NewWindowID);
		
		
		utils = new BrowserUtils();
		GSIPage = new GmailSignInPage();
		utils.waitUntilElementVisible(Driver.getDriver().findElement(By.xpath("//a[text()='Sign in']")));
		Driver.getDriver().findElement(By.xpath("//a[text()='Sign in']")).click();
		try {
			utils.waitUntilElementVisible(GSIPage.GMSigninText);
			GSIPage.GmailLogin();	
		}catch (org.openqa.selenium.StaleElementReferenceException e) {
			utils.waitUntilElementVisible(GSIPage.GMSigninText);
			GSIPage.GmailLogin();	
		}
	}
	
	@When("I open an email with the subject Rest Password Notification")
	public void i_open_an_email_with_the_subject_rest_password_notification() {
		utils = new BrowserUtils();
		GEPage = new GmailEmailPage();
		try {
		utils.waitUntilElementVisible(GEPage.GMResetEmail);
		GEPage.GMResetEmail.click();
		}catch (org.openqa.selenium.StaleElementReferenceException e) {
			utils.waitUntilElementVisible(GEPage.GMResetEmail);
			GEPage.GMResetEmail.click();
		}
		
	}
	
	@Then("I should see an email reset link")
	public void i_should_see_an_email_reset_link() {
		utils = new BrowserUtils();
		GEPage = new GmailEmailPage();
		
		try {
			utils.scrollTo(GEPage.GMRestPasswordBTNLink);
			utils.waitUntilElementVisible(GEPage.GMRestPasswordBTNLink);
			Assert.assertTrue(GEPage.GMRestPasswordBTNLink.isDisplayed());
			}catch (org.openqa.selenium.StaleElementReferenceException e) {
				utils.scrollTo(GEPage.GMRestPasswordBTNLink);
				utils.waitUntilElementVisible(GEPage.GMRestPasswordBTNLink);
				Assert.assertTrue(GEPage.GMRestPasswordBTNLink.isDisplayed());
			}		
	}
	
	@When("I click the password reset link")
	public void i_click_the_password_reset_link() {
		utils = new BrowserUtils();
		GEPage = new GmailEmailPage();
		
		try {
			utils.waitUntilElementVisible(GEPage.GMRestPasswordBTNLink);
			GEPage.GMRestPasswordBTNLink.click();
			}catch (org.openqa.selenium.StaleElementReferenceException e) {
				utils.waitUntilElementVisible(GEPage.GMRestPasswordBTNLink);
				GEPage.GMRestPasswordBTNLink.click();
			}	
	}
	
	@Then("I should be directed to the password reset page")
	public void i_should_be_directed_to_the_password_reset_page() {
		Set <String> windowIds2 = Driver.getDriver().getWindowHandles();
		Iterator<String> ids2 = windowIds2.iterator();
		ids2.next();
		ids2.next();
		String NewWindowID2 = ids2.next();
		Driver.getDriver().switchTo().window(NewWindowID2);
		
		utils = new BrowserUtils();
		ResetPage = new CraterPasswordResetPage();
		utils.waitUntilElementVisible(ResetPage.passResetResetBTN);
		Assert.assertTrue(ResetPage.passResetResetBTN.isDisplayed());
	}
	
	@Then("I should see three text fields")
	public void i_should_see_three_text_fields() {
		Assert.assertTrue(ResetPage.passResetEmailFeild.isDisplayed());
		Assert.assertTrue(ResetPage.passResetPassField.isDisplayed());
		Assert.assertTrue(ResetPage.passResetRetypeField.isDisplayed());
	}

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*----------*/// Valid test case Steps	
																
	@When("I enter a valid email to the email reset field")
	public void i_enter_a_valid_email_to_the_email_reset_field() {
		ResetPage = new CraterPasswordResetPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(ResetPage.passResetEmailFeild, DataReader.getProperty("dummyUser"));
	}
	
	@When("I enter a valid password to the password reset field")
	public void i_enter_a_valid_password_to_the_password_reset_field() {
		ResetPage = new CraterPasswordResetPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(ResetPage.passResetPassField, DataReader.getProperty("dummyPass"));
	}
	
	@When("I enter a valid retype password to the retype password reset field")
	public void i_enter_a_valid_retype_password_to_the_retype_password_reset_field() {
		ResetPage = new CraterPasswordResetPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(ResetPage.passResetRetypeField, DataReader.getProperty("dummyPass"));
	}
		
	@Then("I should not see any reset password error messages")
	public void i_should_not_see_any_reset_password_error_messages() {
		ResetPage = new CraterPasswordResetPage();
		try {
			Assert.assertTrue(ResetPage.passResetNoErrorERRPopUp.isDisplayed());
		}catch(org.openqa.selenium.NoSuchElementException e) {
			Assert.assertTrue(ResetPage.passResetNoErrorSCPupUp.isDisplayed());	
		}
	}
	
	@When("I click Reset Password button")
	public void i_click_reset_password_button() {
		ResetPage = new CraterPasswordResetPage();
		utils = new BrowserUtils();
		utils.waitUntilElementVisible(ResetPage.passResetResetBTN);
		ResetPage.passResetResetBTN.click();
	}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/*----------*/// Invalid test case steps													//taco@tuesday@gmail.com
																							//Taco2ue
	@When("I enter an invalid email to the email reset field")								//Taco2uesday123
	public void i_enter_an_invalid_email_to_the_email_reset_field() {
		ResetPage = new CraterPasswordResetPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(ResetPage.passResetEmailFeild, "tacotuesday@gmail.com");
	}
	
	@When("I enter an invalid password to the password reset field")
	public void i_enter_an_invalid_password_to_the_password_reset_field() {
		ResetPage = new CraterPasswordResetPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(ResetPage.passResetPassField, "Taco2ue");
	}

	@When("I enter an invalid retype password to the retype password reset field")
	public void i_enter_an_invalid_retype_password_to_the_retype_password_reset_field() {
		ResetPage = new CraterPasswordResetPage();
		utils = new BrowserUtils();
		utils.actionsSendKeys(ResetPage.passResetRetypeField, "Taco2uesday123");
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*----------*/// Error Message steps	
	
	@Then("I should not be directed to the Login Page")
	public void i_should_not_be_directed_to_the_login_page() {
		Assert.assertTrue(ResetPage.passResetEmailFeild.isDisplayed());
	}
	
	@Then("I should see an invalid email message")
	public void i_should_see_an_invalid_email_message() {
		utils.waitUntilElementVisible(ResetPage.passResetIncorrectEmailMess);
		Assert.assertTrue(ResetPage.passResetIncorrectEmailMess.isDisplayed());
	}
	
	@Then("I should see an invalid password message")
	public void i_should_see_an_invalid_password_message() {
		utils.waitUntilElementVisible(ResetPage.passResetPassMustBe8Mess);
		Assert.assertTrue(ResetPage.passResetPassMustBe8Mess.isDisplayed());
	}
	
	@Then("I should see an invalid retype password message")
	public void i_should_see_an_invalid_retype_password_message() {
		utils.waitUntilElementVisible(ResetPage.passResetPassMustMatchMess);
		Assert.assertTrue(ResetPage.passResetPassMustMatchMess.isDisplayed());		
	}
	
	@Then("I should see a popup alert Error Somathing Went Wrong")
	public void i_should_see_a_popup_alert_error_somathing_went_wrong() {
		utils.waitUntilElementVisible(ResetPage.passResetNoErrorERRPopUp);
		Assert.assertTrue(ResetPage.passResetNoErrorERRPopUp.isDisplayed());

	}	
}
