package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class GmailEmailPage {

	public GmailEmailPage() {
		PageFactory.initElements(Driver.getDriver(), this);		
	}
	
	@FindBy ( xpath = "//div[@role='link']//span[text()='Reset Password Notification']")
	public WebElement GMResetEmail;
	
	@FindBy ( xpath = "//a[text()='Reset Password']")
	public WebElement GMRestPasswordBTNLink;
	
	
	
	
	
	
	
	
	
	
}
