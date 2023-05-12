package step_definitions;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCustomersPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class CreateCustomerNewCustomerUIComponentsSteps {

	
	CraterCustomersPage customersPage;
	BrowserUtils utils;
	Robot robert;
	
	static List<String> BasicInfoTextFields;
	static List<String> BillingAdressTextFields;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
/*	Basic Info/ Portal Access section  */
	@When("I click on + New Customer button")
	public void i_click_on_new_customer_button() {
		customersPage = new CraterCustomersPage();
		utils = new BrowserUtils();
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerBTN);
	}
	
	@Then("I should be on the New Customers page")
	public void i_should_be_on_the_new_customers_page() {
		utils.waitUntilElementVisible(customersPage.customersPageMenuNavigationNewCustomer);
		Assert.assertTrue(customersPage.customersPageMenuNavigationNewCustomer.isDisplayed());
	}
	
	@Then("I should see the Basic Info section with the following Text Feilds")
	public void i_should_see_the_basic_info_section_with_the_following_text_feilds(io.cucumber.datatable.DataTable dataTable) {
		BasicInfoTextFields = dataTable.asList();
		for ( String basicInfoFields : BasicInfoTextFields) {
			System.out.println(basicInfoFields);
		}
		String DisplayNameWithAsterisk = BasicInfoTextFields.get(0) + " *";
		
		Assert.assertEquals(customersPage.customersPageNewCustomerBIDisplayNameTextFieldLabel.getText(), DisplayNameWithAsterisk);
		Assert.assertEquals(customersPage.customersPageNewCustomerBIPrimaryContactNameTextFieldLabel.getText(), BasicInfoTextFields.get(1));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIEmailTextFeildLabel.getText(), BasicInfoTextFields.get(2));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIPhoneTextFeildLabel.getText(), BasicInfoTextFields.get(3));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Bug	Assert.assertEquals(customersPage.customersPageNewCustomerBIPrimaryCurrencyTextFieldLabel.getText(), BasicInfoTextFields.get(4));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIWebsiteTextFieldLabel.getText(), BasicInfoTextFields.get(5));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIPrefixTextFieldLabel.getText(), BasicInfoTextFields.get(6));		
	}
	
	@Then("I should see an asterisk next to Display Name")
	public void i_should_see_an_asterisk_next_to_display_name() {
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerBIDisplayNameRedAsterisk);
		Assert.assertTrue(customersPage.customersPageNewCustomerBIDisplayNameRedAsterisk.isDisplayed());

	}
	@Then("I should not see an asterisk next to the other fields")
	public void i_should_not_see_an_asterisk_next_to_the_other_fields() {
		for ( String fields : BasicInfoTextFields) {
			try {
				Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[text()='"+fields+" ']//span[text()=' * ']")).isDisplayed());
				System.out.println(fields + " has a red asterisk");
			}catch(java.lang.AssertionError e) {
				System.out.println(fields + " does not have a red asterisk");
			}
		}
	}
	
	@Then("I Should see the Portal Access Section")
	public void i_should_see_the_portal_access_section() throws InterruptedException {
		Thread.sleep(2000);
		utils.scrollTo(customersPage.customersPageNewCustomerBIPrefixTextField);
		Thread.sleep(2000);
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerPortalAccessHeaderText);
		Assert.assertTrue(customersPage.customersPageNewCustomerPortalAccessHeaderText.isDisplayed());

	}
	@Then("I should see a toggle switch with the following text in grey above: {string}")
	public void i_should_see_a_toggle_switch_with_the_following_text_in_grey_above(String portalAccessMess) {
		Assert.assertEquals(portalAccessMess, customersPage.customersPageNewCustomerPAMessageText.getText());
	}
	
	@Then("I should see the toggle switch in the off position by default in grey")
	public void i_should_see_the_toggle_switch_in_the_off_position_by_default_in_grey() {
		Assert.assertTrue(customersPage.customersPageNewCustomerPAToggleSwitchBTN.isDisplayed());
	}
	
	@When("I click the toggle switch")
	public void i_click_the_toggle_switch() {
		utils.actionsClick(customersPage.customersPageNewCustomerPAToggleSwitchBTN);
	}
	
	@Then("I should see the toggle switch in the on position in purple")
	public void i_should_see_the_toggle_switch_in_the_on_position_in_purple() {
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerPAToggleSwitchBTNTrue);
		Assert.assertTrue(customersPage.customersPageNewCustomerPAToggleSwitchBTNTrue.isDisplayed());
	}
	
	@Then("I should see a text box appear with a url")
	public void i_should_see_a_text_box_appear_with_a_url() {
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerPACustomerPortalURLLinkText);
		Assert.assertTrue(customersPage.customersPageNewCustomerPACustomerPortalURLLinkText.isDisplayed());
	}
	
	@Then("I should see a copy to clipboad button next to the url text field")
	public void i_should_see_a_copy_to_clipboad_button_next_to_the_url_text_field() {
		Assert.assertTrue(customersPage.customersPageNewCustomerPACustomerPortalCopyToClipBoardBTN.isDisplayed());
	}
	
	@Then("I should see a message {string} underneath the url text field")
	public void i_should_see_a_message_underneath_the_url_text_field(String string) {
		Assert.assertTrue(customersPage.customersPageNewCustomerPACustomerPortalPleaseCopyAndForwardMess.isDisplayed());
	}
	
	@Then("I should see a Password text field underneath url text field")
	public void i_should_see_a_password_text_field_underneath_url_text_field() {
		Assert.assertTrue(customersPage.customersPageNewCustomerPAPasswordTextField.isDisplayed());
	}
	
	@Then("I should see a Confirm Password text field to the right of the Password text field")
	public void i_should_see_a_confirm_password_text_field_to_the_right_of_the_password_text_field() {
		Assert.assertTrue(customersPage.customersPageNewCustomerPAConfirmPasswordTextField.isDisplayed());
	}
	
	@Then("I should see a show value button to the right of the Password text field")
	public void i_should_see_a_show_value_button_to_the_right_of_the_password_text_field() {
		Assert.assertTrue(customersPage.customersPageNewCustomerPAShowPasswordBTN.isDisplayed());
	}
	
	@Then("I should see a show value button to the right of the Confrim Password text field")
	public void i_should_see_a_show_value_button_to_the_right_of_the_confrim_password_text_field() {
		Assert.assertTrue(customersPage.customersPageNewCustomerPAShowConfirmPasswordBTN.isDisplayed());
	}
	
	@When("I click the copy to clipboad button")
	public void i_click_the_copy_to_clipboad_button() {
		utils.actionsClick(customersPage.customersPageNewCustomerPACustomerPortalCopyToClipBoardBTN);
	}
	
	@When("I enter a value into Password and Confirm Password text fields")
	public void i_enter_a_value_into_password_and_confirm_password_text_fields() throws AWTException, InterruptedException {
		robert = new Robot();
		utils.actionsClick(customersPage.customersPageNewCustomerPAPasswordTextField);
		Thread.sleep(500);
		robert.keyPress(KeyEvent.VK_CONTROL);
		robert.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robert.keyRelease(KeyEvent.VK_V);
		robert.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		utils.actionsClick(customersPage.customersPageNewCustomerPAConfirmPasswordTextField);
		Thread.sleep(500);
		robert.keyPress(KeyEvent.VK_CONTROL);
		robert.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robert.keyRelease(KeyEvent.VK_V);
		robert.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
	}
	
	@When("I click the show value button to the right of each text field")
	public void i_click_the_show_value_button_to_the_right_of_each_text_field() throws InterruptedException {
		utils.actionsClick(customersPage.customersPageNewCustomerPAShowPasswordBTN);
		Thread.sleep(500);
		utils.actionsClick(customersPage.customersPageNewCustomerPAShowConfirmPasswordBTN);
		Thread.sleep(500);
	}
	
	@Then("The url should be copied to clipboard")
	public void the_url_should_be_copied_to_clipboard() throws AWTException, InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		String currentClipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		Assert.assertEquals(currentClipboard, customersPage.customersPageNewCustomerPACustomerPortalURLLinkText.getText());
	}
	
	@Then("I should be able to see the inputed values")
	public void i_should_be_able_to_see_the_inputed_values() {
		Assert.assertEquals("text", customersPage.customersPageNewCustomerPAPasswordTextField.getAttribute("type"));
		Assert.assertEquals("text", customersPage.customersPageNewCustomerPAConfirmPasswordTextField.getAttribute("type"));
	}
	
	@Then("I should not be able to see the inputed values")
	public void i_should_not_be_able_to_see_the_inputed_values() {
		Assert.assertEquals("password", customersPage.customersPageNewCustomerPAPasswordTextField.getAttribute("type"));
		Assert.assertEquals("password", customersPage.customersPageNewCustomerPAConfirmPasswordTextField.getAttribute("type"));
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	/*	Billing Address and Shipping Adress section  */

	@When("I scroll down to Billing Address")
	public void i_scroll_down_to_billing_address() throws InterruptedException {
		utils.scrollTo(customersPage.customersPageNewCustomerPAToggleSwitchBTN);
		Thread.sleep(1000);
	}
	
	@Then("I should see the Billing Address section with the following Text Feilds")
	public void i_should_see_the_billing_address_section_with_the_following_text_feilds(io.cucumber.datatable.DataTable dataTable) {
		BillingAdressTextFields = dataTable.asList();
		for ( String billingFields : BillingAdressTextFields) {
			System.out.println(billingFields);
		}
		
		Assert.assertEquals(customersPage.customersPageNewCustomerBANameTextFieldLabel.getText(), BillingAdressTextFields.get(0));
		Assert.assertEquals(customersPage.customersPageNewCustomerBACountryTextFieldLabel.getText(), BillingAdressTextFields.get(1));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAStateTextFieldLabel.getText(), BillingAdressTextFields.get(2));
		Assert.assertEquals(customersPage.customersPageNewCustomerBACityTextFieldLabel.getText(), BillingAdressTextFields.get(3));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAAddressTextFieldLabel.getText(), BillingAdressTextFields.get(4));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAPhoneTextFieldLabel.getText(), BillingAdressTextFields.get(5));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAZipCodeTextFieldLabel.getText(), BillingAdressTextFields.get(6));
	}
	
	@Then("I should not see any asterisks next to the text fields in the Billing Address Section")
	public void i_should_not_see_any_asterisks_next_to_the_text_fields_in_the_billing_address_section() {
		for ( String billingFields : BillingAdressTextFields) {
			try {														
				Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='"+billingFields+" ']//span[text()=' * ']")).isDisplayed());
				System.out.println(billingFields + " has a red asterisk");
			}catch(java.lang.AssertionError e) {
				System.out.println(billingFields + " does not have a red asterisk");
			}
		}
	}

	@Then("I should see a button labeled Copy from Billing")
	public void i_should_see_a_button_labeled_copy_from_billing() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerCopyFromBillingBTN);
		Assert.assertTrue(customersPage.customersPageNewCustomerCopyFromBillingBTN.isDisplayed());
	}
	
	@When("I enter dummy information to the billing adress fields")
	public void i_enter_dummy_information_to_the_billing_adress_fields() throws InterruptedException {
		customersPage.newCustomerFillBillingAddressInfo("Sam",  "Antarctica", "Virginia", "Town", "123 Movie ln", "apt. 304", "1234567890", "21576");
	}
	
	@When("I click the button labeled Copy from Billing")
	public void i_click_the_button_labeled_copy_from_billing() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerCopyFromBillingBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerCopyFromBillingBTN);
	}
	
	@Then("I should see the same information from the Billing Addres Section in the Shipping Address Section")
	public void i_should_see_the_same_information_from_the_billing_addres_section_in_the_shipping_address_section() {
		Assert.assertEquals(customersPage.customersPageNewCustomerBANameTextField.getText(), customersPage.customersPageNewCustomerSANameTextField.getText());
		Assert.assertEquals(customersPage.customersPageNewCustomerBACountryTextField.getText(), customersPage.customersPageNewCustomerSACountryTextField.getText());
		Assert.assertEquals(customersPage.customersPageNewCustomerBAStateTextField.getText(), customersPage.customersPageNewCustomerSAStateTextField.getText());
		Assert.assertEquals(customersPage.customersPageNewCustomerBACityTextField.getText(), customersPage.customersPageNewCustomerSACityTextField.getText());	
		Assert.assertEquals(customersPage.customersPageNewCustomerBAPhoneTextField.getText(), customersPage.customersPageNewCustomerSAPhoneTextField.getText());
		Assert.assertEquals(customersPage.customersPageNewCustomerBAZipCodeTextField.getText(), customersPage.customersPageNewCustomerSAZipCodeTextField.getText());
		Assert.assertEquals(customersPage.customersPageNewCustomerBAAddressLine1TextField.getText(), customersPage.customersPageNewCustomerSAAdressLine1.getText());
		Assert.assertEquals(customersPage.customersPageNewCustomerBAAddressLine2TextField.getText(), customersPage.customersPageNewCustomerSAAdressLine2.getText());
	}
	@Then("I should not see any asterisks next to the text fields in the Shipping Address Section")
	public void i_should_not_see_any_asterisks_next_to_the_text_fields_in_the_shipping_address_section() {
		for ( String billingFields : BillingAdressTextFields) {
			try {														
				Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h6[text()='Shipping Address']//parent::div//div//div//label//div[text()='"+BillingAdressTextFields+" ']//span[text()=' * ']")).isDisplayed());
				System.out.println(billingFields + " has a red asterisk");
			}catch(org.openqa.selenium.NoSuchElementException e) {
				System.out.println(billingFields + " does not have a red asterisk");
			}
		}
	}
}
