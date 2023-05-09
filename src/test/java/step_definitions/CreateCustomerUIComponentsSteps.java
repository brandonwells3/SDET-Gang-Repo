package step_definitions;

import static org.junit.Assert.fail;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.CraterCustomersPage;
import utilities.BrowserUtils;

public class CreateCustomerUIComponentsSteps {

	
	CraterCommonPage commonPage;
	BrowserUtils utils;
	CraterCustomersPage customersPage;
	
	
	
	
	@When("I click on the Customer Menu link")
	public void i_click_on_the_customer_menu_link() {
		commonPage = new CraterCommonPage();
		utils = new BrowserUtils();
		utils.waitUntilElementToBeClickable(commonPage.customersLink);
		utils.actionsClick(commonPage.customersLink);
	}
	
	@Then("I should see a page titled Customers")
	public void i_should_see_a_page_titled_customers() {
		customersPage = new CraterCustomersPage();
		utils.waitUntilElementVisible(customersPage.customersPageCustomerHeaderText);
		Assert.assertTrue(customersPage.customersPageCustomerHeaderText.isDisplayed());
	}
	
	@Then("I should see the menu navigation paths as Home / customers placed under Customers")
	public void i_should_see_the_menu_navigation_paths_as_home_customers_placed_under_customers() {
		utils.waitUntilElementVisible(customersPage.customersPageMenuNavigationHome);
		Assert.assertTrue(customersPage.customersPageMenuNavigationHome.isDisplayed());
		Assert.assertTrue(customersPage.customersPageMenuNavigationCustomers.isDisplayed());
	}
	
	@Then("I should see a button labeled Filter in the Customers Page")
	public void i_should_see_a_button_labeled_filter_in_the_customers_page() {
		utils.waitUntilElementVisible(customersPage.customersPageFilterBTN);
		Assert.assertTrue(customersPage.customersPageFilterBTN.isDisplayed());
	}
	
	@Then("I should see a button labeled + New Customer")
	public void i_should_see_a_button_labeled_new_customer() {
		utils.waitUntilElementToBeClickable(customersPage.customersPageNewCustomerBTN);
		Assert.assertTrue(customersPage.customersPageNewCustomerBTN.isDisplayed());
	}
	
	@Then("I should see a table with New Customer related headers")
	public void i_should_see_a_table_with_new_customer_related_headers() {
		utils.waitUntilElementVisible(customersPage.customersPageNameColumn);
		Assert.assertTrue(customersPage.customersPageNameColumn.isDisplayed());
		Assert.assertTrue(customersPage.customersPagePhoneColumn.isDisplayed());
		Assert.assertTrue(customersPage.customersPageAmountDueColumn.isDisplayed());
		Assert.assertTrue(customersPage.customersPageAddedOnColumn.isDisplayed());
	}
	
	@Then("I should see number indicating the page the user is currently on and the next upcoming pages")
	public void i_should_see_number_indicating_the_page_the_user_is_currently_on_and_the_next_upcoming_pages() {
		Assert.assertTrue(customersPage.customersPagePaginationPage1.isDisplayed());
		Assert.assertTrue(customersPage.customersPagePaginationPage2.isDisplayed());
		Assert.assertTrue(customersPage.customersPagePaginationPage3.isDisplayed());
	}
	
	@When("I click on the first page in the Customers tab")
	public void i_click_on_the_first_page_in_the_customers_tab() {
		utils.waitUntilElementToBeClickable(customersPage.customersPagePaginationPage1);		
		utils.actionsClick(customersPage.customersPagePaginationPage1);
	}
	
	@Then("The Left Navgation Arrow should be disabled in the Customers tab")
	public void the_left_navgation_arrow_should_be_disabled_in_the_customers_tab() {
		try {
			utils.waitUntilElementVisible(customersPage.customersPagePaginationDisabledNavButton);
			Assert.assertEquals(customersPage.customersPagePaginationDisabledNavButton.getText(),"Previous");
		}catch(java.util.NoSuchElementException e) {
			fail("Left Arrow is not disabled");
		}
	}
	
	@When("I click on the last page in the Customers tab")
	public void i_click_on_the_last_page_in_the_customers_tab() {
		utils.waitUntilElementToBeClickable(customersPage.customersPagePaginationPage4);		
		utils.actionsClick(customersPage.customersPagePaginationPage4);
	}
	
	@Then("The Right Navigation Arrow should be disabled in the Customers tab")
	public void the_right_navigation_arrow_should_be_disabled_in_the_customers_tab() {
		try {
			utils.waitUntilElementVisible(customersPage.customersPagePaginationDisabledNavButton);
			Assert.assertEquals(customersPage.customersPagePaginationDisabledNavButton.getText(),"Next");
		}catch(java.util.NoSuchElementException e) {
			fail("Right Arrow is not disabled");
		}
	}
}
