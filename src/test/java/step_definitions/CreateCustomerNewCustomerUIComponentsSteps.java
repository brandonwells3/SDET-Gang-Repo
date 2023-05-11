package step_definitions;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCustomersPage;
import utilities.BrowserUtils;

public class CreateCustomerNewCustomerUIComponentsSteps {

	
	CraterCustomersPage customersPage;
	BrowserUtils utils;
	
	static List<String> BasicInfoTextFields;
	
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
		for ( String fields : BasicInfoTextFields) {
			System.out.println(fields);
		}
//		Assert.assertEquals(customersPage.customersPageNewCustomerBIDisplayNameTextFieldLabel.getText(), );s
		
		
	}
	@Then("I should see an asterisk next to Display Name")
	public void i_should_see_an_asterisk_next_to_display_name() {


	}
	@Then("I should not see an asterisk next to the other fields")
	public void i_should_not_see_an_asterisk_next_to_the_other_fields() {


	}
	@Then("I Should see the Portal Access Section")
	public void i_should_see_the_portal_access_section() {


	}
	@Then("I should see a toggle switch with the following text in grey above: {string}")
	public void i_should_see_a_toggle_switch_with_the_following_text_in_grey_above(String string) {


	}
	@Then("I should see the toggle switch in the off position by default in grey")
	public void i_should_see_the_toggle_switch_in_the_off_position_by_default_in_grey() {


	}
	@When("I click the toggle switch")
	public void i_click_the_toggle_switch() {


	}
	@Then("I should see the toggle switch in the on position in purple")
	public void i_should_see_the_toggle_switch_in_the_on_position_in_purple() {


	}
	@Then("I should see a text box appear with a url")
	public void i_should_see_a_text_box_appear_with_a_url() {


	}
	@Then("I should see a copy to clipboad button next to the url text field")
	public void i_should_see_a_copy_to_clipboad_button_next_to_the_url_text_field() {


	}
	@Then("I should see a message {string} underneath the url text field")
	public void i_should_see_a_message_underneath_the_url_text_field(String string) {


	}
	@Then("I should see a Password text field underneath url text field")
	public void i_should_see_a_password_text_field_underneath_url_text_field() {


	}
	@Then("I should see a Confirm Password text field to the right of the Password text field")
	public void i_should_see_a_confirm_password_text_field_to_the_right_of_the_password_text_field() {


	}
	@Then("I should see a show value button to the right of the Password text field")
	public void i_should_see_a_show_value_button_to_the_right_of_the_password_text_field() {


	}
	@Then("I should see a show value button to the right of the Confrim Password text field")
	public void i_should_see_a_show_value_button_to_the_right_of_the_confrim_password_text_field() {


	}
	@When("I click the copy to clipboad button")
	public void i_click_the_copy_to_clipboad_button() {


	}
	@Then("The url should be copied to clipboard")
	public void the_url_should_be_copied_to_clipboard() {


	}
	@When("I enter a value into Password and Confirm Password text fields")
	public void i_enter_a_value_into_password_and_confirm_password_text_fields() {


	}
	@When("I click the show value button to the right of each text field")
	public void i_click_the_show_value_button_to_the_right_of_each_text_field() {


	}
	@Then("I should be able to see the inputed values")
	public void i_should_be_able_to_see_the_inputed_values() {


	}
	@Then("I should not be able to see the inputed values")
	public void i_should_not_be_able_to_see_the_inputed_values() {


	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	/*	Billing Address and Shipping Adress section  */

	@When("I scroll down to Billing Address")
	public void i_scroll_down_to_billing_address() {


	}
	@Then("I should see the Billing Address section with the following Text Feilds")
	public void i_should_see_the_billing_address_section_with_the_following_text_feilds(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should not see any asterisks next to the text fields in the Billing Address Section")
	public void i_should_not_see_any_asterisks_next_to_the_text_fields_in_the_billing_address_section() {


	}
	@Then("I should see a button labeled Copy from Billing")
	public void i_should_see_a_button_labeled_copy_from_billing() {


	}
	@When("I click the button labeled Copy from Billing")
	public void i_click_the_button_labeled_copy_from_billing() {


	}
	@Then("I should see the same information from the Billing Addres Section in the Shipping Address Section")
	public void i_should_see_the_same_information_from_the_billing_addres_section_in_the_shipping_address_section() {


	}
	@Then("I should not see any asterisks next to the text fields in the Shipping Address Section")
	public void i_should_not_see_any_asterisks_next_to_the_text_fields_in_the_shipping_address_section() {


	}
}
