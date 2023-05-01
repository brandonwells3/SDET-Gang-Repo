package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterItemsPage {

	public CraterItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}																		//AC 1 - 
																			//			5.)*** column link
																			//          1.) Select all checkbox
	@FindBy ( xpath = "//h3[text()='Items']")
	public WebElement itemsPageHeaderText;
	
	@FindBy ( xpath = "//a[text()='Items']")
	public WebElement itemsPageMenuNavigationPathItems;
	
	@FindBy ( xpath = "//a[text()='Home']")
	public WebElement itemsPageMenuNavigationPathHome;
	
	@FindBy ( xpath = "//button[text()='Filter ']")
	public WebElement itemsPageFilterBTN;
	
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
	
	
	
}
