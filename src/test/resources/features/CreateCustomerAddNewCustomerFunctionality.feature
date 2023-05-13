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
@CreateCustomerAddNewCustomerFunctionality
Feature: Validate Add New Customer Functionality
				for Crate Invoice Application

  @CreateCustomerAddNewCustomerFunctionalityWaitForSuccessToDisapear
  Scenario: Validate Add New Customer Functionality
	Given As an entity user, I am logged in
  When I click on the Customer Menu link
  And I click on + New Customer button
  Then I should be on the New Customers page
 	When I input the following data into the Basic Info Section
	| Test101 | Test Name | primetech.test123@gmail.com | 3982121245 | USD - US Dollar | http://google.com | Dr. |
	Then I should see the inputed data in the Basic Info fields
	And There are no validation errors
	When I click the grey toggle button in the Portal Access section
	Then I should be able to see the Portal Access section
	And I input the following data into the Portal Access password and confrim password fields
	Then I should see the inputed data in the password fields
	When I input the following data into the Billing Address section
	| Test | United States | Virginia | Testville | 12345 Test Street | 54321 Test Drive | 3982121245 | 20176 |	
	Then I should see the input data in the Billing Address section
	When I click on the Copy from Billing button
	Then The Billing Address info should be copied to the Shipping Address section
	And There are no validation errors
	When I click on the Save Customer button
	Then I am directed to the Customer Sales & Expenses page
	And I see a flash message saying: "Success! Customer created successfully" with a close button to the right.
	And I should see the flash message disappear within 5 seconds or less
	When I view the newly created customer
	Then I see the previously added details for the customer
	And I am able to see the information in the database

	
	@CreateCustomerAddNewCustomerFunctionalityCloseSuccessPopup
  Scenario: Validate Add New Customer Functionality
	Given As an entity user, I am logged in
  When I click on the Customer Menu link
  And I click on + New Customer button
  Then I should be on the New Customers page
 	When I input the following data into the Basic Info Section
	| Test | Test Name | primetech.test123@gmail.com | 3982121245 | USD - US Dollar | http://google.com | Dr. |
	Then I should see the inputed data in the Basic Info fields
	When I click the grey toggle button in the Portal Access section
	Then I should be able to see the Portal Access section
	And I input the following data into the Portal Access password and confrim password fields #password123
	Then I should see the inputed data in the password fields
	When I input the following data into the Billing Address section
	| Test | United States | Virginia | Testville | 12345 Test Street | 54321 Test Drive | 3982121245 | 20176 |	
	Then I should see the input data in the Billing Address section
	When I click on the Copy from Billing button
	Then The Billing Address info should be copied to the Shipping Address section
	When I view all the input fields
	Then There are no validation errors
	When I click on the Save Customer button
	Then I am directed to the Customer Sales & Expenses page
	And I see a flash message saying: "Success! Customer created successfully" with a close button to the right.
	When I click the X button on the flash message
	Then the flash message disappears
	When I view the newly created customer
	Then I see the previously added details for the customer
	And I am able to see the information in the database
	
	