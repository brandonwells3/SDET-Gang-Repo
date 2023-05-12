#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@createCustomerNewCustomerUIComponentValidation
Feature: Verify UI Components of the New Customers page
  			 on the Customers tab for Crater Invoice App

  @createCustomerNewCustomerUIComponentValidationBasicInfoANDPortalAcess
  Scenario: Verify New Customer UI Components
    Given As an entity user, I am logged in
    When I click on the Customer Menu link
    And I click on + New Customer button
    Then I should be on the New Customers page
    And I should see the Basic Info section with the following Text Feilds
    | Display Name | Primary Contact Name | Email | Phone | Primary Currency | Website | Prefix |
    And I should see an asterisk next to Display Name
    And I should not see an asterisk next to the other fields
    
    And I Should see the Portal Access Section
    And I should see a toggle switch with the following text in grey above: 'Would you like to allow this customer to login to the Customer Portal?'
		And I should see the toggle switch in the off position by default in grey
		
		When I click the toggle switch
		Then I should see the toggle switch in the on position in purple
		And I should see a text box appear with a url
		And I should see a copy to clipboad button next to the url text field
		And I should see a message 'Please copy & forward the above given URL to your customer for providing access.' underneath the url text field
		And I should see a Password text field underneath url text field
		And I should see a Confirm Password text field to the right of the Password text field
		And I should see a show value button to the right of the Password text field
		And I should see a show value button to the right of the Confrim Password text field
		
		When I click the copy to clipboad button
		And I enter a value into Password and Confirm Password text fields
		And I click the show value button to the right of each text field
		Then The url should be copied to clipboard
		And I should be able to see the inputed values
		
		When I click the show value button to the right of each text field
		Then I should not be able to see the inputed values
		
	@createCustomerNewCustomerUIComponentValidationBillingAddressANDShippingAddress
  Scenario: Verify New Customer UI Components
  	Given As an entity user, I am logged in
    When I click on the Customer Menu link
    And I click on + New Customer button
    Then I should be on the New Customers page
    When I scroll down to Billing Address
    Then I should see the Billing Address section with the following Text Feilds
    | Name | Country | State | City | Address | Phone | Zip Code |
  	And I should not see any asterisks next to the text fields in the Billing Address Section
  	And I should see a button labeled Copy from Billing
  	When I enter dummy information to the billing adress fields
  	And I click the button labeled Copy from Billing
  	Then I should see the same information from the Billing Addres Section in the Shipping Address Section
  	And I should not see any asterisks next to the text fields in the Shipping Address Section
  	
  	
		
