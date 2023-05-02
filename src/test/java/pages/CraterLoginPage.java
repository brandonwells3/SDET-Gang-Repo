package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class CraterLoginPage {

	public CraterLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	BrowserUtils utils;
	
	
	@FindBy ( xpath = "//title[text()='Crater - Self Hosted Invoicing Platform']")
	public WebElement craterHomePageTitle;
	
	
	@FindBy ( xpath = "//a[text()='Forgot Password?']")
	public WebElement crateHomePageForgotPasswordLink;
	
	@FindBy ( xpath = "//input[@name='email']")
	public WebElement craterLoginEmailField;
	
	@FindBy ( xpath = "//input[@name='password']")
	public WebElement craterLoginPassField;
	
	@FindBy ( xpath = "//button[text()='Login']")
	public WebElement craterLoginLoginButton;
	

	@FindBy ( xpath = "//*[local-name()='svg']")
	public WebElement craterTitle;
	
	@FindBy (xpath = "//div[text() ='Email ']")
	public WebElement lableEmail;
	
//	@FindBy (xpath = "//span[text() =' * ']")
//	public WebElement emailAsterisk;
	
	@FindBy (xpath = "//div[text()='Password ']")
	public WebElement lablePassword;
	
//	@FindBy (xpath = "//button[text()='Login']")
//	public WebElement loginButton;
	
	@FindBy (xpath ="//p[contains(text(), 'Copyright @ Crater Invoice, Inc. 2023')]")
	public WebElement textAreaOnButtomLeft;
	
	@FindBy (xpath = "//h1[contains(text(), 'Simple Invoicing for Individuals Small Businesses')]")
	public WebElement firstHeading;
	
	@FindBy (xpath = "//p[contains(text(), 'Crater helps you track expenses, record payments & generate beautiful invoices & estimates.')]")
	public WebElement secondHeading;
	
	
	public void login() {
		utils = new BrowserUtils();
		utils.waitUntilElementVisible(craterLoginEmailField);
		utils.actionsSendKeys(craterLoginEmailField, DataReader.getProperty("testUser1"));
		System.out.println("Email has been entered");
		
		utils.actionsSendKeys(craterLoginPassField, DataReader.getProperty("testPass1"));
		System.out.println("Password has been entered");
		
		utils.waitUntilElementToBeClickable(craterLoginLoginButton);
		utils.actionsClick(craterLoginLoginButton);
		System.out.println("Login Button has been clicked");
	}
	
	
	
}
