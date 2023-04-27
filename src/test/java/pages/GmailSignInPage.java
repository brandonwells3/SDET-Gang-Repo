package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class GmailSignInPage {

		BrowserUtils utils = new BrowserUtils();
		
	
		public GmailSignInPage() {
			PageFactory.initElements(Driver.getDriver(), this);			
		}
		
		
		public void GmailLogin() {
			utils.waitUntilElementVisible(GMSigninText);
			utils.actionsSendKeys(GMEmailTextField, DataReader.getProperty("dummyGmailUser"));
			
			GMNextBTN.click();
			
			utils.waitUntilElementVisible(GMPasswordTextField);
			utils.actionsSendKeys(GMPasswordTextField, DataReader.getProperty("dummyGmailPass"));
			
			GMNextBTN.click();
		}
		
		@FindBy ( xpath = "//span[text()='Sign in']")
		public WebElement GMSigninText;
		
		@FindBy ( xpath = "//input[@type='email']")
		public WebElement GMEmailTextField;
		
		@FindBy ( xpath = "//span[text()='Next']")
		public WebElement GMNextBTN;
		
		@FindBy ( xpath = "//input[@type='password']")
		public WebElement GMPasswordTextField;
}
