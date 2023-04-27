package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CraterPasswordResetPage {

	
	public CraterPasswordResetPage() {
		PageFactory.initElements(Driver.getDriver(), this);		
	}
	
	@FindBy ( name = "email")
	public WebElement passResetEmailFeild;
	
	@FindBy ( xpath = "//div[text()='Password ']//parent::div//parent::label//parent::div//following-sibling::div[@name='password']")
	public WebElement passResetPassField;
	
	@FindBy ( xpath = "//div[text()='Retype Password ']//parent::div//parent::label//parent::div//following-sibling::div[@name='password']")
	public WebElement passResetRetypeField;
	
	@FindBy ( xpath = "//button[text()='Reset Password']")
	public WebElement passResetResetBTN;
	
	@FindBy ( xpath = "//span[text()='Incorrect Email.']")
	public WebElement passResetIncorrectEmailMess;
	
	@FindBy ( xpath = "//span[text()='Password must contain 8 characters']")
	public WebElement passResetPassMustBe8Mess;
	
	@FindBy ( xpath = "//span[text()='Passwords must be identical']")
	public WebElement passResetPassMustMatchMess;
	
	@FindBy ( xpath = "//p[text()='Error']")
	public WebElement passResetNoErrorERRPopUp;
	
	@FindBy ( xpath = "//p[text()='Success!']")
	public WebElement passResetNoErrorSCPupUp;
	
	
	
	
	
	
	
}
