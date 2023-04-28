package step_definitions;

import static org.junit.Assert.fail;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.CraterItemsPage;
import pages.CraterLoginPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class CreateItemUIComponentsSteps {
	
	
	CraterLoginPage loginPage;
	BrowserUtils utils;
	CraterCommonPage commonPage;
	CraterItemsPage itemsPage;
	

	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
		loginPage = new CraterLoginPage();
		utils = new BrowserUtils();
		Driver.getDriver().get(DataReader.getProperty("craterUrl"));
		utils.waitUntilElementVisible(loginPage.craterLoginEmailField);	
		loginPage.login();
	}
	
	@When("I click on the Items Menu link")
	public void i_click_on_the_items_menu_link() {
		commonPage = new CraterCommonPage();
		utils = new BrowserUtils();
		utils.waitUntilElementToBeClickable(commonPage.itemsLink);
		utils.actionsClick(commonPage.itemsLink);
	}
	
	@Then("I should see a page titled Items")
	public void i_should_see_a_page_titled_items() {
		itemsPage = new CraterItemsPage();
		utils.waitUntilElementVisible(itemsPage.itemsPageHeaderText);
		Assert.assertTrue(itemsPage.itemsPageHeaderText.isDisplayed());
	}
	
	@Then("I should see the menu navigation paths as Home / Items placed under Items")
	public void i_should_see_the_menu_navigation_paths_as_home_items_placed_under_items() {
		utils.waitUntilElementVisible(itemsPage.itemsPageMenuNavigationPathHome);
		Assert.assertTrue(itemsPage.itemsPageMenuNavigationPathHome.isDisplayed());
		Assert.assertTrue(itemsPage.itemsPageMenuNavigationPathItems.isDisplayed());
	}
	
	@Then("I should see a button labeled Filter")
	public void i_should_see_a_button_labeled_filter() {
		utils.waitUntilElementVisible(itemsPage.itemsPageFilterBTN);
		Assert.assertTrue(itemsPage.itemsPageFilterBTN.isDisplayed());
	}
	
	@Then("I should see a button labeled + Add Item")
	public void i_should_see_a_button_labeled_add_item() {
		utils.waitUntilElementVisible(itemsPage.itemsPageAddItemBTN);
		Assert.assertTrue(itemsPage.itemsPageAddItemBTN.isDisplayed());
	}
	
	@Then("I see Pagination text as follow: Showing 1 to 10 of itemTotal results")
	public void i_see_pagination_text_as_follow_showing_1_to_10_of_total_results() {
		utils.waitUntilElementVisible(itemsPage.itemsPagePagination);
		Assert.assertEquals(itemsPage.itemsPagePagination.getText(), "Showing 1 to 10 of "+itemsPage.itemsPageCurrentTotal.getText()+" results");
	}
	
	@Then("I should see Left and Right Arrows allowing user to navigate to previous and next pages")
	public void i_should_see_left_and_right_arrows_allowing_user_to_navigate_to_previous_and_next_pages() {
		utils.waitUntilElementVisible(itemsPage.itemsPageNavLeftArrow);
		Assert.assertTrue(itemsPage.itemsPageNavLeftArrow.isDisplayed());
		Assert.assertTrue(itemsPage.itemsPageNavRightArrow.isDisplayed());
	}
	
	@Then("I should see number indicating the page the user is currently on and the next upcoming page")
	public void i_should_see_number_indicating_the_page_the_user_is_currently_on_and_the_next_upcoming_page() {
		utils.waitUntilElementVisible(itemsPage.itemsPageNavCurrentPageNum);
		Assert.assertTrue(itemsPage.itemsPageNavCurrentPageNum.isDisplayed());
		Assert.assertTrue(itemsPage.itemsPageNavCurrentPageNum.isDisplayed());
	}
	
	@When("I click on the first page")
	public void i_click_on_the_first_page() {
		utils.waitUntilElementToBeClickable(itemsPage.itemsPageNavCurrentPageNum);
		if(itemsPage.itemsPageNavCurrentPageNum.getText().equals("1")) {
			utils.actionsClick(itemsPage.itemsPageNavCurrentPageNum);
		}
		else {
			utils.actionsClick(itemsPage.itemsPageNavFirstNonSelectedPageNum);
		}
	}
	
	@Then("The Left Navgation Arrow should be disabled")
	public void the_left_navgation_arrow_should_be_disabled() {
		try {
			utils.waitUntilElementVisible(itemsPage.itemsPageDisabledNavButton);
			Assert.assertEquals(itemsPage.itemsPageDisabledNavButton.getText(),"Previous");
		}catch(java.util.NoSuchElementException e) {
			fail("Left Arrow is not disabled");

		}
	}
	
	@When("I click on the last page")
	public void i_click_on_the_last_page() {
		utils.waitUntilElementVisible(itemsPage.itemsPageNavLastPageNum);
		utils.actionsClick(itemsPage.itemsPageNavLastPageNum);
	}
	
	@Then("The Right Navigation Arrow should be disabled")
	public void the_right_navigation_arrow_should_be_disabled() {
		try {
			utils.waitUntilElementVisible(itemsPage.itemsPageDisabledNavButton);
			Assert.assertEquals(itemsPage.itemsPageDisabledNavButton.getText(),"Next");
		}catch(java.util.NoSuchElementException e) {
			fail("Right Arrow is not disabled");

		}
	}

	
	
	
	
}
