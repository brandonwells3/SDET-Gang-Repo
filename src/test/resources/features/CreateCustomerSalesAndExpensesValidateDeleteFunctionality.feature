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
@CreateCustomerSalesAndExpensesDeleteFunctionality
Feature: Validate delete functionality in the Customer Sales
				& Expenses Page for the Crater Invoice App
 	

  @CreateCustomerSalesAndExpensesDeleteFunctionalityDoNotDelete
		Scenario: Validate Delete Functionality for Customer Sales & Expenses Page
			Given As an entity user, I am logged in
 			When I click on the Customer Menu link
   		And I click the three dots next to dummy 'Test101' customer
			Then I should see the following three options displayed: Edit, View, and Delete
			When I click on the Delete button
			Then I should be prompted with a Modal "Are you sure?"
			And I should see "You will not be able to recover this customer and all the related Invoices, Estimates and Payments."
			When I click cancel or anywhere on the page
			Then the Modal is closed

	 @CreateCustomerSalesAndExpensesDeleteFunctionalityDoDelete
		Scenario: Validate Delete Functionality for Customer Sales & Expenses Page			
			Given As an entity user, I am logged in
 			When I click on the Customer Menu link
   		And I click the three dots next to dummy test customer
			Then I should see the following three options displayed: Edit, View, and Delete
			When I click on the Delete button
			Then I should be prompted with a Modal "<Alert Icon> Are you sure?"
			And I should see "You will not be able to recover this customer and all the related Invoices, Estimates and Payments."
			When I click the Ok button
			Then I should see the following message "Success! Customer deleted successfully"
			And I should be navigated to the customer table
			And I should see a close button to the right
			When I click the X button
			Then the flash message should be closed
			When I view the customer table
			Then I should not be able to see the recently deleted customer in the customers table
			And I should not be able to see the recently deleted customer in the databse
