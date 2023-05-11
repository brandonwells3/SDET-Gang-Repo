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
	public WebElement customersPagePaginationLeftArrowBTN;
	
	@FindBy ( xpath = "//span[text()='Next']//parent::a")
	public WebElement customersPagePaginationRightArrowBTN;
	
	@FindBy ( xpath = "//a[@class='z-10 bg-primary-50 border-primary-500 text-primary-600 relative items-center hidden px-4 py-2 text-sm font-medium text-gray-500 bg-white border border-gray-300 hover:bg-gray-50 md:inline-flex']")
	public WebElement customersPagePaginationCurrentMiddlePage;
	
	@FindBy ( xpath = "//nav[@aria-label='Pagination']//a[text()=' 1 ']")
	public WebElement customersPagePaginationPage1;
	
	@FindBy ( xpath = "//nav[@aria-label='Pagination']//a[text()='2']")
	public WebElement customersPagePaginationPage2;	
	
	@FindBy ( xpath = "//nav[@aria-label='Pagination']//a[text()='3']")
	public WebElement customersPagePaginationPage3;	
	
	@FindBy ( xpath = "//nav[@aria-label='Pagination']//a[text()='4']")
	public WebElement customersPagePaginationPage4;	
	
	@FindBy ( xpath = "//nav//a[contains(@class,'disabled')]")
	public WebElement customersPagePaginationDisabledNavButton;
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/* NewCustomer Section */	
	
	
	@FindBy ( xpath = "//a[text()='New Customer']")
	public WebElement customersPageMenuNavigationNewCustomer;
	
	@FindBy ( xpath = "//div[@class='flex items-center']//div//button")
	public WebElement customersPageNewCustomerSaveCustomerBTN;
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/* Basic Info Section */
	
	
	@FindBy ( xpath = "//h6[text()='Basic Info']")
	public WebElement customersPageNewCustomerBasicInfoHeaderText;
	
	@FindBy ( xpath = "//div[text()='Display Name ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBIDisplayNameTextField;
	@FindBy ( xpath = "//div[text()='Display Name ']")
	public WebElement customersPageNewCustomerBIDisplayNameTextFieldLabel;
	
	@FindBy ( xpath = "//div[text()='Primary Contact Name ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBIPrimaryContactNameTextField;
	@FindBy ( xpath = "//div[text()='Primary Contact Name ']")
	public WebElement customersPageNewCustomerBIPrimaryContactNameTextFieldLabel;
	
	@FindBy ( xpath = "//div[text()='Email ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBIEmailTextFeild;
	@FindBy ( xpath = "//div[text()='Email ']")
	public WebElement customersPageNewCustomerBIEmailTextFeildLabel;
	
	@FindBy ( xpath = "//div[text()='Email ']//parent::label//parent::div//following-sibling::div[@class='relative w-full text-left']//label//div[text()='Phone ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBIPhoneTextFeild;
	@FindBy ( xpath = "//div[text()='Email ']//parent::label//parent::div//following-sibling::div[@class='relative w-full text-left']//label//div[text()='Phone ']")
	public WebElement customersPageNewCustomerBIPhoneTextFeildLabel;
	
	@FindBy ( xpath = "//div[text()='Primary Currency ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBIPrimaryCurrencyTextField;
	@FindBy ( xpath = "//div[text()='Primary Currency ']")
	public WebElement customersPageNewCustomerBIPrimaryCurrencyTextFieldLabel;
	
	@FindBy ( xpath = "//div[text()='Website ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBIWebsiteTextField;
	@FindBy ( xpath = "//div[text()='Website ']")
	public WebElement customersPageNewCustomerBIWebsiteTextFieldLabel;
	
	@FindBy ( xpath = "//div[text()='Prefix ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBIPrefixTextField;
	@FindBy ( xpath = "//div[text()='Prefix ']")
	public WebElement customersPageNewCustomerBIPrefixTextFieldLabel;
	
	@FindBy ( xpath = "//div[text()='Display Name ']//span[text()=' * ']")
	public WebElement customersPageNewCustomerBIDisplayNameRedAsterisk;
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/* Portal Access Section */	
	
	
	@FindBy ( xpath = "//h6[text()='Portal Access']")
	public WebElement customersPageNewCustomerPortalAccessHeaderText;
	
	@FindBy ( xpath = "//p[text()='Would you like to allow this customer to login to the Customer Portal?']")
	public WebElement customersPageNewCustomerPAMessageText;
	
	@FindBy ( xpath = "//button[@modelvalue]")
	public WebElement customersPageNewCustomerPAToggleSwitchBTN;
	
	@FindBy ( xpath = "//button[@modelvalue='true']")
	public WebElement customersPageNewCustomerPAToggleSwitchBTNTrue;
	
	@FindBy ( xpath = "//button[@modelvalue='false']")
	public WebElement customersPageNewCustomerPAToggleSwitchBTNFalse;
	
	@FindBy ( xpath = "//div[text()='Customer Portal Login URL ']")
	public WebElement customersPageNewCustomerPACustomerPortalHeaderText;
	
	@FindBy ( xpath = "//div[text()='Customer Portal Login URL ']//parent::label//following-sibling::div//div//span")
	public WebElement customersPageNewCustomerPACustomerPortalURLLinkText;
	
	@FindBy ( xpath = "/html/body/div[1]/main/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/svg")
	public WebElement customersPageNewCustomerPACustomerPortalCopyToClipBoardBTN;
	
	@FindBy ( xpath = "//input[@name='password']")
	public WebElement customersPageNewCustomerPAPasswordTextField;
	
	@FindBy ( xpath = "//input[@name='confirm_password']")
	public WebElement customersPageNewCustomerPAConfirmPasswordTextField;
	
	@FindBy ( xpath = "/html/body/div[1]/main/div/div/form/div[2]/div/div[2]/div/div[3]/div/div/div/svg")
	public WebElement customersPageNewCustomerPAShowPasswordBTN;
	
	@FindBy ( xpath = "/html/body/div[1]/main/div/div/form/div[2]/div/div[2]/div/div[4]/div/div/div/svg")
	public WebElement customersPageNewCustomerPAShowConfirmPasswordBTN;
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/* Billing Address Section */	
	
	
	@FindBy ( xpath = "//h6[text()='Billing Address']")
	public WebElement customersPageNewCustomerBillingAddressHeaderText;
	
	@FindBy ( xpath = "//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='Name ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBANameTextField;
	
	@FindBy ( xpath = "//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='State ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBAStateTextField;
	
	@FindBy ( xpath = "//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='Country ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBACountryTextField;
	
	@FindBy ( xpath = "//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='City ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBACityTextField;
	
	@FindBy ( xpath = "//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='Address ']//parent::label//following-sibling::div//textarea[@name='billing_street1']")
	public WebElement customersPageNewCustomerBAAddressLine1TextField;
	
	@FindBy ( xpath = "//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='Address ']//parent::label//following-sibling::div//textarea[@name='billing_street2']")
	public WebElement customersPageNewCustomerBAAddressLine2TextField;
	
	@FindBy ( xpath = "//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='Phone ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBAPhoneTextField;
	
	@FindBy ( xpath = "//h6[text()='Billing Address']//parent::div//div//div//label//div[text()='Zip Code ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerBAZipCodeTextField;
	
	@FindBy ( xpath = "//div[@class='p-1']//button")
	public WebElement customersPageNewCustomerCopyFromBillingBTN;
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/* Shipping Address Section */	
	
	
	@FindBy ( xpath = "//h6[text()='Shipping Address']")
	public WebElement customersPageNewCustomerShippingAddressHeaderText;
	
	@FindBy ( xpath = "//h6[text()='Shipping Address']//parent::div//div//div//label//div[text()='Name ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerSANameTextField;
	
	@FindBy ( xpath = "//h6[text()='Shipping Address']//parent::div//div//div//label//div[text()='Country ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerSACountryTextField;
	
	@FindBy ( xpath = "//h6[text()='Shipping Address']//parent::div//div//div//label//div[text()='State ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerSAStateTextField;
	
	@FindBy ( xpath = "//h6[text()='Shipping Address']//parent::div//div//div//label//div[text()='City ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerSACityTextField;
	
	@FindBy ( xpath = "//h6[text()='Shipping Address']//parent::div//div//div//label//div[text()='Phone ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerSAPhoneTextField;
	
	@FindBy ( xpath = "//h6[text()='Shipping Address']//parent::div//div//div//label//div[text()='Zip Code ']//parent::label//following-sibling::div//div//input")
	public WebElement customersPageNewCustomerSAZipCodeTextField;
	
	@FindBy ( xpath = "")
	public WebElement customersPageNewCustomer;
	
	@FindBy ( xpath = "")
	public WebElement customersPageNewCustomer1;
		
}
