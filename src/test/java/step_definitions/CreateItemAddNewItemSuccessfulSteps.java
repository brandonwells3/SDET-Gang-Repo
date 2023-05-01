package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterItemsPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;

public class CreateItemAddNewItemSuccessfulSteps {

	
	CraterItemsPage itemsPage;
	BrowserUtils utils;
	DButils dbutils;
	
	static String itemNewName;
	static double timeStart;
	static double timeStop;
	
	
	
	@When("I click + Add Item button")
	public void i_click_add_item_button() {
		itemsPage = new CraterItemsPage();
		utils = new BrowserUtils();
		utils.waitUntilElementToBeClickable(itemsPage.itemsPageAddItemBTN);
		utils.actionsClick(itemsPage.itemsPageAddItemBTN);
	}
	
	@Then("I should see a page titled New Item")
	public void i_should_see_a_page_titled_new_item() {
		utils = new BrowserUtils();
		itemsPage = new CraterItemsPage();
		utils.waitUntilElementVisible(itemsPage.itemsPageNewItemHeaderText);
		Assert.assertTrue(itemsPage.itemsPageNewItemHeaderText.isDisplayed());
	}
	
	@When("I provide valid item information name {string}, price {string}, unit {string}, and description {string}")
	public void i_provide_valid_item_information_name_price_unit_and_description(String name, String price, String unit, String description) throws InterruptedException {
		itemNewName = name + utils.randonNumber();
		itemsPage.createAnIteam(itemNewName, price, unit, description);
		utils.actionsClick(itemsPage.itemsPageNewItemSaveItemBTN);
	}
	
	@Then("I should see a Success! popup message with a close button to the right")
	public void i_should_see_a_success_popup_message_with_a_close_button_to_the_right() {
		utils.waitUntilElementVisible(itemsPage.itemsPageNewItemSuccessPopUpMess);
		Assert.assertTrue(itemsPage.itemsPageNewItemSuccessPopUpMess.isDisplayed());
	}
	
	@Then("I click the X next on the right side of success message")
	public void i_click_the_x_next_on_the_right_side_of_success_message() {
		utils.waitUntilElementToBeClickable(itemsPage.itemsPageNewItemSuccessXBTN);
		utils.actionsClick(itemsPage.itemsPageNewItemSuccessXBTN);
	}
	@Then("The flash message should disapear within five seconds or less")
	public void the_flash_message_should_disapear_within_five_seconds_or_less() throws InterruptedException {
		try {
		try {	
		try {
		try {
			Assert.assertFalse(itemsPage.itemsPageNewItemSuccessPopUpMess.isDisplayed());
		}catch(java.lang.AssertionError e) {
			Thread.sleep(3000);
			Assert.assertFalse(itemsPage.itemsPageNewItemSuccessPopUpMess.isDisplayed());
			System.out.println("3 sec");
		}
		}catch(java.lang.AssertionError e) {
			Thread.sleep(1000);
			Assert.assertFalse(itemsPage.itemsPageNewItemSuccessPopUpMess.isDisplayed());
			System.out.println("4 sec");
		}
		}catch(java.lang.AssertionError e) {
			Thread.sleep(1000);
			Assert.assertFalse(itemsPage.itemsPageNewItemSuccessPopUpMess.isDisplayed());
			System.out.println("5 sec");
		}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			Thread.sleep(1000);
			System.out.println("Element does not exist");
			System.out.println("6 sec");
		}
	}
	
	@Then("I should be directed to the Items Page")
	public void i_should_be_directed_to_the_items_page() {
		utils.waitUntilElementVisible(itemsPage.itemsPageHeaderText);
		Assert.assertTrue(itemsPage.itemsPageHeaderText.isDisplayed());
	}
	
	@Then("I should see the new item added in the items table")
	public void i_should_see_the_new_item_added_in_the_items_table() {
		itemsPage.findTheItem(itemNewName);
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='"+itemNewName+"']")).isDisplayed());
	}
	
	@Then("I should see the new item in database")
	public void i_should_see_the_new_item_in_database() {
		dbutils = new DButils();
		String query = "SELECT name, price, unit_id, description FROM items where name='"+itemNewName+"';";
		System.out.println(query);
		List<String> itemInfo = dbutils.selectArecord(query);
		for (String string : itemInfo) {
			System.out.println(string);
		}
		
		
		
		
	}
}
