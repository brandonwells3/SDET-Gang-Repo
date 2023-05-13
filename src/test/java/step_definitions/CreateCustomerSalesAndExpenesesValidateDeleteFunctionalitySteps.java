package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCustomersPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class CreateCustomerSalesAndExpenesesValidateDeleteFunctionalitySteps {

	
	CraterCustomersPage customersPage;
	BrowserUtils utils;
	
	
	
	@When("I click the three dots next to dummy {string} customer")
	public void i_click_the_three_dots_next_to_dummy_customer(String name) throws InterruptedException {
		customersPage = new CraterCustomersPage();
		utils = new BrowserUtils();
		customersPage.findCustomer(name);
		utils.actionsClick(Driver.getDriver().findElement(By.xpath("//span[text()='"+name+"']//parent::a//parent::td//following-sibling::td//div//button")));
	}

	@Then("I should see the following three options displayed: Edit, View, and Delete")
	public void i_should_see_the_following_three_options_displayed_edit_view_and_delete() {
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomer3DotsViewBTN);
		Assert.assertTrue(customersPage.customersPageNewCustomer3DotsViewBTN.isDisplayed());
		Assert.assertTrue(customersPage.customersPageNewCustomer3DotsEditBTN.isDisplayed());
		Assert.assertTrue(customersPage.customersPageNewCustomer3DotsDeleteBTN.isDisplayed());
	}
	
	@When("I click on the Delete button")
	public void i_click_on_the_delete_button() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomer3DotsDeleteBTN);
		utils.actionsClick(customersPage.customersPageNewCustomer3DotsDeleteBTN);
	}
	
	@Then("I should be prompted with a Modal {string}")
	public void i_should_be_prompted_with_a_modal(String string) {
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerDeleteModalAreYourSureMess);
		Assert.assertEquals(string, customersPage.customersPageNewCustomerDeleteModalAreYourSureMess);
	}
	
	@Then("I should see {string}")
	public void i_should_see(String string) {
		utils.waitUntilElementVisible(customersPage.customersPageNewCustomerDeleteModalYouWillNotBeAbleToRecoverMess);
		Assert.assertEquals(string, customersPage.customersPageNewCustomerDeleteModalYouWillNotBeAbleToRecoverMess);
	}
	@When("I click cancel or anywhere on the page")
	public void i_click_cancel_or_anywhere_on_the_page() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerDeleteModalCancelBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerDeleteModalCancelBTN);
	}
	@Then("the Modal is closed")
	public void the_modal_is_closed() throws InterruptedException {
		Thread.sleep(1000);
		utils.isElementPresent(customersPage.customersPageNewCustomerDeleteModalAreYourSureMess);
	}
	
	@When("I click the Ok button")
	public void i_click_the_ok_button() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerDeleteModalOkayBTN);
		utils.actionsClick(customersPage.customersPageNewCustomerDeleteModalOkayBTN);
	}
	@Then("I should see the following message {string}")
	public void i_should_see_the_following_message(String string) {


	}
	@Then("I should be navigated to the customer table")
	public void i_should_be_navigated_to_the_customer_table() {


	}
	@Then("I should see a close button to the right")
	public void i_should_see_a_close_button_to_the_right() {
	    
		
	}
	@When("I click the X button")
	public void i_click_the_x_button() {


	}
	@Then("the flash message should be closed")
	public void the_flash_message_should_be_closed() {


	}
	@When("I view the customer table")
	public void i_view_the_customer_table() {

;
	}
	@Then("I should not be able to see the recently deleted customer in the customers table")
	public void i_should_not_be_able_to_see_the_recently_deleted_customer_in_the_customers_table() {


	}
	@Then("I should not be able to see the recently deleted customer in the databse")
	public void i_should_not_be_able_to_see_the_recently_deleted_customer_in_the_databse() {


	}

}
