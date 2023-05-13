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
@CreateCustomerValidateFilterFunctionality
Feature: Validate the filtering feature for the customers
  			 table data for the Crater Invoice Application

  @CreateCustomerValidateFilterFunctionality
  Scenario: Validate Filtering Functionality for the Customer Table Data
	Given As an entity user, I am logged in
	When I click on the Customer Menu link
	Then I should be navigated to the Customers page
	When I click on the Filter icon
	Then the following text boxes should appear
