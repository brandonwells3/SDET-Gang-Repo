package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterForgotPasswordPage {

	public CraterForgotPasswordPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	
	@FindBy ( name = "email")
	public WebElement ForgotPasswordEnterEmailTextBox;

	@FindBy ( xpath = "//div[text()='Send Reset Link']")
	public WebElement ForgotPasswordSendRestBTN;
	
	@FindBy ( xpath = "//a[text()='Back to Login?']")
	public WebElement ForgotPasswordBackToLoginLink;
	
	@FindBy ( xpath = "//div[@class=\"flex items-start\"]")
	public WebElement ForgotPasswordERRMessPopUp;
	
	@FindBy ( xpath = "//p[text()='Success!']")
	public WebElement ForgotPasswordSUMessPopUp; 
	
	@FindBy ( xpath = "//span[text()=\"Incorrect Email.\"]")
	public WebElement ForgotPasswordIncorrectEmailErrorMess;
	
	@FindBy ( xpath = "//span[text()='Field is required']")
	public WebElement ForgotPasswordFieldRequiredErrorMess;
	
	
	
	
	
	
}
