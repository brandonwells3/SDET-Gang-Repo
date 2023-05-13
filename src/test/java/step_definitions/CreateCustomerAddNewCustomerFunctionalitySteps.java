package step_definitions;

import java.awt.Robot;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCustomersPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;

public class CreateCustomerAddNewCustomerFunctionalitySteps {

	
	CraterCustomersPage customersPage;
	BrowserUtils utils;
	DButils dbutils;
	Robot robert;
	
	List<String> basicInfoFields;
	List<String>  billingAddressFields;
	
	
	@When("I input the following data into the Basic Info Section")
	public void i_input_the_following_data_into_the_basic_info_section(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		customersPage = new CraterCustomersPage();
		basicInfoFields = dataTable.asList();
		for ( String InfoFields : basicInfoFields) {
			System.out.println(InfoFields);
		}
		customersPage.newCustomerFillBasicInfo(basicInfoFields.get(0), basicInfoFields.get(1), basicInfoFields.get(2), basicInfoFields.get(3), basicInfoFields.get(4), basicInfoFields.get(5), basicInfoFields.get(6));	
	}
	
	@Then("I should see the inputed data in the Basic Info fields")
	public void i_should_see_the_inputed_data_in_the_basic_info_fields() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(basicInfoFields.get(0), customersPage.customersPageNewCustomerBIDisplayNameTextField.getAttribute("value"));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIPrimaryContactNameTextField.getAttribute("value"), basicInfoFields.get(1));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIEmailTextFeild.getAttribute("value"), basicInfoFields.get(2));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIPhoneTextFeild.getAttribute("value"), basicInfoFields.get(3));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIPrimaryCurrencyTextField.getAttribute("value"), basicInfoFields.get(4));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIWebsiteTextField.getAttribute("value"), basicInfoFields.get(5));
		Assert.assertEquals(customersPage.customersPageNewCustomerBIPrefixTextField.getAttribute("value"), basicInfoFields.get(6));
	}
	
	@When("I click the grey toggle button in the Portal Access section")
	public void i_click_the_grey_toggle_button_in_the_portal_access_section() {
		utils = new BrowserUtils();
		utils.scrollTo(customersPage.customersPageNewCustomerBIPrefixTextField);
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerPAToggleSwitchBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerPAToggleSwitchBTN);
	}
	
	@Then("I should be able to see the Portal Access section")
	public void i_should_be_able_to_see_the_portal_access_section() {
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerPACustomerPortalURLLinkText);
		Assert.assertTrue(customersPage.customersPageNewCustomerPACustomerPortalURLLinkText.isDisplayed());
	}
	
	@Then("I input the following data into the Portal Access password and confrim password fields")
	public void i_input_the_following_data_into_the_portal_access_password_and_confrim_password_fields() throws InterruptedException {
	    utils.waitUntilElementVisible(customersPage.customersPageNewCustomerPAPasswordTextField);
	    utils.actionsSendKeys(customersPage.customersPageNewCustomerPAPasswordTextField, "password123");
	    Thread.sleep(500);
	    utils.waitUntilElementVisible(customersPage.customersPageNewCustomerPAConfirmPasswordTextField);
	    utils.actionsSendKeys(customersPage.customersPageNewCustomerPAConfirmPasswordTextField, "password123");
	}
	
	@Then("I should see the inputed data in the password fields")
	public void i_should_see_the_inputed_data_in_the_password_fields() throws InterruptedException {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerPAShowPasswordBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerPAShowPasswordBTN);
		Thread.sleep(500);
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerPAShowConfirmPasswordBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerPAShowConfirmPasswordBTN);
		Thread.sleep(500);
	}
	
	@When("I input the following data into the Billing Address section")
	public void i_input_the_following_data_into_the_billing_address_section(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		utils.scrollTo(customersPage.customersPageNewCustomerPAConfirmPasswordTextField);
		billingAddressFields = dataTable.asList();
		for ( String InfoFields : billingAddressFields) {
			System.out.println(InfoFields);
		}
		customersPage.newCustomerFillBillingAddressInfo(billingAddressFields.get(0), billingAddressFields.get(1), billingAddressFields.get(2), billingAddressFields.get(3), billingAddressFields.get(4), billingAddressFields.get(5), billingAddressFields.get(6),billingAddressFields.get(7));
	}
	
	@Then("I should see the input data in the Billing Address section")
	public void i_should_see_the_input_data_in_the_billing_address_section() {
		Assert.assertEquals(customersPage.customersPageNewCustomerBANameTextField.getAttribute("value"), billingAddressFields.get(0));
//		Assert.assertEquals(customersPage.customersPageNewCustomerBACountryTextFieldCurrentSelected.getAttribute("value"), billingAddressFields.get(1));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAStateTextField.getAttribute("value"), billingAddressFields.get(2));
		Assert.assertEquals(customersPage.customersPageNewCustomerBACityTextField.getAttribute("value"), billingAddressFields.get(3));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAAddressLine1TextField.getAttribute("value"), billingAddressFields.get(4));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAAddressLine2TextField.getAttribute("value"), billingAddressFields.get(5));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAPhoneTextField.getAttribute("value"), billingAddressFields.get(6));
		Assert.assertEquals(customersPage.customersPageNewCustomerBAZipCodeTextField.getAttribute("value"), billingAddressFields.get(7));
	}
	
	@When("I click on the Copy from Billing button")
	public void i_click_on_the_copy_from_billing_button() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerCopyFromBillingBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerCopyFromBillingBTN);
	}
	
	@Then("The Billing Address info should be copied to the Shipping Address section")
	public void the_billing_address_info_should_be_copied_to_the_shipping_address_section() {
		Assert.assertEquals(billingAddressFields.get(0), customersPage.customersPageNewCustomerSANameTextField.getAttribute("value"));
//		Assert.assertEquals(billingAddressFields.get(1), customersPage.customersPageNewCustomerSACountryTextField.getAttribute("value"));
		Assert.assertEquals(billingAddressFields.get(2), customersPage.customersPageNewCustomerSAStateTextField.getAttribute("value"));
		Assert.assertEquals(billingAddressFields.get(3), customersPage.customersPageNewCustomerSACityTextField.getAttribute("value"));
		Assert.assertEquals(billingAddressFields.get(4), customersPage.customersPageNewCustomerSAAdressLine1.getAttribute("value"));
		Assert.assertEquals(billingAddressFields.get(5), customersPage.customersPageNewCustomerSAAdressLine2.getAttribute("value"));
		Assert.assertEquals(billingAddressFields.get(6), customersPage.customersPageNewCustomerSAPhoneTextField.getAttribute("value"));
		Assert.assertEquals(billingAddressFields.get(7), customersPage.customersPageNewCustomerSAZipCodeTextField.getAttribute("value"));
	}

	@Then("There are no validation errors")
	public void there_are_no_validation_errors() {
		try {
			Driver.getDriver().findElement(By.xpath("//span[@class='block mt-0.5 text-sm text-red-500']"));
			System.out.println("**ERROR**");
		}catch(org.openqa.selenium.NoSuchElementException e) {
			System.out.println("There are no validation errors");
		}
	}
	
	@When("I click on the Save Customer button")
	public void i_click_on_the_save_customer_button() throws InterruptedException {
		
		utils.scrollTo(customersPage.customersPageNewCustomerHeaderText);
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerHeaderText);
		Thread.sleep(1000);
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerSaveCustomerBTN);
		Thread.sleep(1000);
		utils.actionsClick(customersPage.customersPageNewCustomerSaveCustomerBTN);
		
		
	}
	
	@Then("I am directed to the Customer Sales & Expenses page")
	public void i_am_directed_to_the_customer_sales_expenses_page() {
		utils.waitUntilElementVisible(customersPage.customersPageSalesAndExpensesHeaderText);
		Assert.assertTrue(customersPage.customersPageSalesAndExpensesHeaderText.isDisplayed());
	}
	
	@Then("I see a flash message saying: {string} with a close button to the right.")
	public void i_see_a_flash_message_saying_with_a_close_button_to_the_right(String string) {
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerSuccessMess);
		Assert.assertTrue(customersPage.customersPageNewCustomerSuccessMess.isDisplayed());
	}
	
	@Then("I should see the flash message disappear within {int} seconds or less")
	public void i_should_see_the_flash_message_disappear_within_seconds_or_less(Integer int1) throws InterruptedException {
		
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			if(utils.isElementPresent(customersPage.customersPageNewCustomerSuccessMess) == true) {
				System.out.println("Element is still present");
			}
			else {
				System.out.println("Element is no longer present");
			}
		}
	}
	
	@When("I click the X button on the flash message")
	public void i_click_the_x_button_on_the_flash_message() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerSuccessMessCloseBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerSuccessMessCloseBTN);
	}
	
	@Then("the flash message disappears")
	public void the_flash_message_disappears() {
	    Assert.assertTrue(utils.isElementPresent(customersPage.customersPageNewCustomerSuccessMess) == false);
	}
	
	@When("I view the newly created customer")
	public void i_view_the_newly_created_customer() {
		utils.scrollTo(customersPage.customersPageSalesAndExpensesBasicInfoHeaderText);
	}
	
	@Then("I see the previously added details for the customer")
	public void i_see_the_previously_added_details_for_the_customer() {
		utils.waitUntilElementVisible(customersPage.customersPageSalesAndExpensesBIDisplayNameCustomerText);
		Assert.assertEquals(basicInfoFields.get(0), customersPage.customersPageSalesAndExpensesBIDisplayNameCustomerText.getText());
		Assert.assertEquals(basicInfoFields.get(1), customersPage.customersPageSalesAndExpensesBIPimaryContactCustomerText.getText());
		Assert.assertEquals(basicInfoFields.get(2), customersPage.customersPageSalesAndExpensesBIEmailCustomerText.getText());
		Assert.assertEquals(basicInfoFields.get(3), customersPage.customersPageSalesAndExpensesBIPhoneNumberCustomerText.getText());
//		Assert.assertEquals(basicInfoFields.get(4), customersPage.customersPageSalesAndExpensesBICurrencyCustomerText.getText());
		Assert.assertEquals(basicInfoFields.get(5), customersPage.customersPageSalesAndExpensesBIWebsiteCustomerText.getText());
	}
	@Then("I am able to see the information in the database")
	public void i_am_able_to_see_the_information_in_the_database() {
		dbutils = new DButils();

		String query = "SELECT name, contact_name, email, phone, currency_id, website, prefix FROM customers where name='"+basicInfoFields.get(0)+"';";
		System.out.println(query);
		List<String> itemInfo = dbutils.selectArecord(query);
		for (String string : itemInfo) {
			System.out.println(string);
		}
		String upper = itemInfo.get(0).substring(0, 1).toUpperCase() + itemInfo.get(0).substring(1);
		System.out.println(upper);
		Assert.assertEquals(basicInfoFields.get(0), upper);
		Assert.assertEquals(basicInfoFields.get(1), itemInfo.get(1));
		Assert.assertEquals(basicInfoFields.get(2), itemInfo.get(2));
		Assert.assertEquals(basicInfoFields.get(3), itemInfo.get(3));
		Assert.assertEquals(itemInfo.get(4), "1");
		Assert.assertEquals(basicInfoFields.get(5), itemInfo.get(5));		
	}
}

/*
dbutils = new DButils();
List<WebElement> deletedItems = Driver.getDriver().findElements(By.xpath("//a[contains(text(),'iphone')]"));
Iterator<String> dItems = deletedItems.iterator().toString();
for( int i; i<dItems.size(); i++) {
	try {
	String query = "SELECT name, unit_id, price, FROM customers where name='"+dItems.next()+"';";	
	System.out.println(query);	
	List<String> itemInfo = dbutils.selectArecord(query);	
	for (String string : itemInfo) {	
		System.out.println(string);
	}
	}catch( e) {
		System.out.println(dItems.next()+" has been deleted");
	}

}

*/