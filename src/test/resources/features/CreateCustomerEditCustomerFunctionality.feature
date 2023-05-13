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
@CreateCustomerEditCustomerFunctionality
Feature: Validate edit customer functionality for
 				 crater invoice application

  @CreateCustomerEditCustomerFunctionality
  Scenario: Validate Edit Customer Functionality
	Given As an entity user, I am logged in
  When I click on the Customer Menu link
	And I click on the horizontal 3 dots icon to the right of the 'EDIT CUSTOMER TEST' customer
	And I click on the Edit button
	Then I am navigated to the Edit Customer page
	When I view the Basic Info section
	Then I should see and have the ability to edit the following fields
