package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CraterForgotPasswordPage;
import pages.CraterLoginPage;
import utilities.DataReader;
import utilities.Driver;

public class forgotLoginUIComponentsSteps {

	String pTag;
	CraterLoginPage loginPage;
	CraterForgotPasswordPage forgotPage;
	
	
	@Given("I go to Crater App Website")
	public void i_go_to_crater_app_website() {
		Driver.getDriver().get(DataReader.getProperty("craterUrl"));
	}
	
	@Given("I click Forgot Password link")
	public void i_click_forgot_password_link() {
		loginPage = new CraterLoginPage();
		loginPage.crateHomePageForgotPasswordLink.click();
	}
	
	@Then("I see a {string} labeled {string}")
	public void i_see_a_labeled(String obj, String text) {
		forgotPage = new CraterForgotPasswordPage();
		if(obj.equals("button")) {
			pTag = "div";
		}
		else {
			pTag = "a";
		}
		
		if(obj.equals("button")) {
			Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//"+pTag+"[text()='"+text+"']")).isDisplayed());
		}
		else if(obj.equals("link")) {
			Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//"+pTag+"[text()='"+text+"']")).isDisplayed());
		}
		else {
			Assert.assertTrue(forgotPage.ForgotPasswordEnterEmailTextBox.isDisplayed());	
		}			
	}	
}
