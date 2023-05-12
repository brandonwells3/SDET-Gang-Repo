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
@CreateCustomerSalesAndExpensesUIComponents
Feature: Verify UI Components of the Sales and Expenses page
  			 on the Customers tab for Crater Invoice App

  @CreateCustomerSalesAndExpensesUIComponents
  Scenario: Verify UI Components for Sales and Expenses page
		Given As an entity user, I am logged in
    When I click on the Customer Menu link
    And I click the three dots next to test customer
    And I click the View button
    Then I should be directed to the Customer Sales and Expenses page
    And I should see grey text titled basic info
    And I should see the following detail headers for the customer
    | Display Name | Primary Contact Name | Email | Currency | Phone Number | Website |