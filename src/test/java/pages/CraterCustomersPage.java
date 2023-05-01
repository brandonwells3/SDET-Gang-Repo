package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterCustomersPage {

	public CraterCustomersPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	
	@FindBy ( xpath = "//h3[text()='Customers']")
	public WebElement customersPageCustomerHeaderText;
	
	@FindBy ( xpath = "//a[text()='Home']")
	public WebElement customersPageMenuNavigationHome;
	
	@FindBy ( xpath = "//a[text()='Customers']")
	public WebElement customersPageMenuNavigationCustomers;
	
	@FindBy ( xpath = "//button[text()='Filter ']")
	public WebElement customersPageFilterBTN;
	
	@FindBy ( xpath = "//button[text()=' New Customer']")
	public WebElement customersPageNewCustomerBTN;
	
	@FindBy ( xpath = "//div[@class='flex flex-col mt-3']//div//div//div//div//div//div//input[contains(@id,'check_')]")
	public WebElement customersPageCheckAllCheckBox;
	
	@FindBy ( xpath = "//th[text()='Name ']")
	public WebElement customersPageNameColumn;
	
	@FindBy ( xpath = "//th[text()='Phone ']")
	public WebElement customersPagePhoneColumn;
	
	@FindBy ( xpath = "//th[text()='Amount Due ']")
	public WebElement customersPageAmountDueColumn;
	
	@FindBy ( xpath = "//th[text()='Added On ']")
	public WebElement customersPageAddedOnColumn;
	
	@FindBy ( xpath = "//p[@class='text-sm text-gray-700']")
	public WebElement customersPagePaginationShowingResultsText;
	
	@FindBy ( xpath = "//p[text()=' Showing   ']//span[@class='font-medium'][3]")
	public WebElement customersPageCurrentTotalNumOfCustomers;
	
	@FindBy ( xpath = "//span[text()='Previous']//parent::a")
	public WebElement customersPagePagnationLeftArrowBTN;
	
	@FindBy ( xpath = "//span[text()='Next']//parent::a")
	public WebElement customersPagePagnationRightArrowBTN;
	
	
	
	
	
	
}
