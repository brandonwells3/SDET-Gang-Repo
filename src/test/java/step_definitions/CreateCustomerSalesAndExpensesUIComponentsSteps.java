package step_definitions;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCustomersPage;
import utilities.BrowserUtils;

public class CreateCustomerSalesAndExpensesUIComponentsSteps {

	
	CraterCustomersPage customersPage;
	BrowserUtils utils;
	

	
	
	
	@When("I click the three dots next to test customer")
	public void i_click_the_three_dots_next_to_test_customer() throws InterruptedException {
		customersPage = new CraterCustomersPage();
		utils = new BrowserUtils();
		customersPage.findCustomer("Test_Customer_");
		Thread.sleep(2000);
		utils.waitUntilElementToBeClickable(customersPage.customersPageTestCustomerThreeDotsBTN);
		utils.actionsClick(customersPage.customersPageTestCustomerThreeDotsBTN);
	}
	
	@When("I click the View button")
	public void i_click_the_view_button() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageTestCustomerViewBTN);
		utils.actionsClick(customersPage.customersPageTestCustomerViewBTN);
	}
	
	@Then("I should be directed to the Customer Sales and Expenses page")
	public void i_should_be_directed_to_the_customer_sales_and_expenses_page() {
		utils.waitUntilElementVisible(customersPage.customersPageSalesAndExpensesHeaderText );
		Assert.assertTrue(customersPage.customersPageSalesAndExpensesHeaderText.isDisplayed());
	}
	
	@Then("I should see grey text titled basic info")
	public void i_should_see_grey_text_titled_basic_info() {
		utils.waitUntilElementVisible(customersPage.customersPageSalesAndExpensesBasicInfoHeaderText);
		Assert.assertTrue(customersPage.customersPageSalesAndExpensesBasicInfoHeaderText.isDisplayed());
	}
	
	@Then("I should see the following detail headers for the customer")
	public void i_should_see_the_following_detail_headers_for_the_customer(io.cucumber.datatable.DataTable dataTable) {
		List<String> customerBasicInfo = dataTable.asList();
		for ( String basicInfoFields : customerBasicInfo) {
			System.out.println(basicInfoFields);
		}
		Assert.assertEquals(customersPage.customersPageSalesAndExpensesBIDisplayNameLabel.getText(), customerBasicInfo.get(0));
		Assert.assertEquals(customersPage.customersPageSalesAndExpensesBIPimaryContactLabel.getText(), customerBasicInfo.get(1));
		Assert.assertEquals(customersPage.customersPageSalesAndExpensesBIEmailLabel.getText(), customerBasicInfo.get(2));
		Assert.assertEquals(customersPage.customersPageSalesAndExpensesBICurrencyLabel.getText(), customerBasicInfo.get(3));
		Assert.assertEquals(customersPage.customersPageSalesAndExpensesBIPhoneNumberLabel.getText(), customerBasicInfo.get(4));
		Assert.assertEquals(customersPage.customersPageSalesAndExpensesBIWebsiteLabel.getText(), customerBasicInfo.get(5));		
	}
}
