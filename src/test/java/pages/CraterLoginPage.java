package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterLoginPage {

	public CraterLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	
	@FindBy ( xpath = "//title[text()='Crater - Self Hosted Invoicing Platform']")
	public WebElement craterHomePageTitle;
	
	
	@FindBy ( xpath = "//a[text()='Forgot Password?']")
	public WebElement crateHomePageForgotPasswordLink;
	
	
	
}
