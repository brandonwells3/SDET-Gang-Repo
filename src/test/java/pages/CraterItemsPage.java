package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class CraterItemsPage {

	public CraterItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}																		
	BrowserUtils utils;
	
	
	
	public void createAnIteam(String itemName, String itemPrice, String itemUnit, String itemDescription) throws InterruptedException {
		utils = new BrowserUtils();
		
		utils.waitUntilElementVisible(itemsPageNewItemNameTextField);
		utils.actionsSendKeys(itemsPageNewItemNameTextField, itemName);
		Thread.sleep(1000);
		
		utils.waitUntilElementVisible(itemsPageNewItemPriceField);
		utils.actionsSendKeys(itemsPageNewItemPriceField, itemPrice);
		Thread.sleep(1000);
		
		utils.waitUntilElementVisible(itemsPageNewItemUnitField);
		utils.actionsClick(itemsPageNewItemUnitField);
		Thread.sleep(1000);
		utils.actionsClick(Driver.getDriver().findElement(By.xpath("//span[text()='"+itemUnit+"']")));
		
		
		
		utils.waitUntilElementVisible(itemsPageNewItemDescriptionField);
		utils.actionsSendKeys(itemsPageNewItemDescriptionField, itemDescription);
		Thread.sleep(1000);
	}
	
	public void findTheItem(String itemSpecialName) {
		utils = new BrowserUtils();
		utils.waitUntilElementToBeClickable(itemsPageFilterBTN);
		utils.actionsClick(itemsPageFilterBTN);
		utils.actionsSendKeys(itemsPageFilterBTNNameField, itemSpecialName);
	}
																		
	
	
	
	@FindBy ( xpath = "//h3[text()='Items']")
	public WebElement itemsPageHeaderText;
	
	@FindBy ( xpath = "//a[text()='Items']")
	public WebElement itemsPageMenuNavigationPathItems;
	
	@FindBy ( xpath = "//a[text()='Home']")
	public WebElement itemsPageMenuNavigationPathHome;
	
	@FindBy ( xpath = "//button[text()='Filter ']")
	public WebElement itemsPageFilterBTN;
	
	@FindBy ( xpath = "//input[@name='name']")
	public WebElement itemsPageFilterBTNNameField;
	
	@FindBy ( xpath = "//button[text()=' Add Item']")
	public WebElement itemsPageAddItemBTN;
	
//	@FindBy ( xpath = "")
//	public WebElement itemsPageSelectAllCheckBox;
	
	@FindBy ( xpath = "//th[text()='Name ']")
	public WebElement itemsPageNameColumn;
	
	@FindBy ( xpath = "//th[text()='Unit ']")
	public WebElement itemsPageUnitColumn;
	
	@FindBy ( xpath = "//th[text()='Price ']")
	public WebElement itemsPagePriceColumn;
	
	@FindBy ( xpath = "//th[text()='Added On ']")
	public WebElement itemsPageAddedOnColumn;
	
	@FindBy ( xpath = "//p[@class='text-sm text-gray-700']")
	public WebElement itemsPagePagination;
	
	
	@FindBy( xpath = "//p[text()=' Showing   ']//span[@class='font-medium'][3]")
	public WebElement itemsPageCurrentTotal;
	
	@FindBy ( xpath = "//span[text()='Previous']")
	public WebElement itemsPageNavLeftArrow;
	
	@FindBy ( xpath = "//span[text()='Next']")
	public WebElement itemsPageNavRightArrow;
	
	@FindBy ( xpath = "//a[@class='z-10 bg-primary-50 border-primary-500 text-primary-600 relative items-center hidden px-4 py-2 text-sm font-medium text-gray-500 bg-white border border-gray-300 hover:bg-gray-50 md:inline-flex']")
	public WebElement itemsPageNavCurrentPageNum;
	
	@FindBy ( xpath = "//a[@class='bg-white border-gray-300 text-gray-500 hover:bg-gray-50 relative items-center hidden px-4 py-2 text-sm font-medium text-gray-500 bg-white border border-gray-300 hover:bg-gray-50 md:inline-flex'][1]")
	public WebElement itemsPageNavFirstNonSelectedPageNum;
	
	@FindBy ( xpath = "//span[text()='Next']//parent::a/preceding::a[1]")
	public WebElement itemsPageNavLastPageNum;
	
	@FindBy ( xpath = "//nav//a[contains(@class,'disabled')]")
	public WebElement itemsPageDisabledNavButton;
	
	@FindBy ( xpath = "//h3[text()='New Item']")
	public WebElement itemsPageNewItemHeaderText;
	
	@FindBy ( xpath = "//div[text()='Name ']//parent::label//following-sibling::div//div//input")
	public WebElement itemsPageNewItemNameTextField;
	
	@FindBy ( xpath = "//input[@id='0']")
	public WebElement itemsPageNewItemPriceField;
	
	@FindBy ( xpath = "//div[text()='Unit ']//parent::label//following-sibling::div//div//input")
	public WebElement itemsPageNewItemUnitField;
	
	@FindBy ( name = "description")
	public WebElement itemsPageNewItemDescriptionField;
	
	@FindBy ( xpath = "//button[text()=' Save Item']")
	public WebElement itemsPageNewItemSaveItemBTN;
	
	@FindBy ( xpath = "//p[text()='Success!']")
	public WebElement itemsPageNewItemSuccessPopUpMess;
	
	@FindBy ( xpath = "//div[@class='p-4']//div//div//following-sibling::div[@class='flex shrink-0']")
	public WebElement itemsPageNewItemSuccessXBTN;
	
}
