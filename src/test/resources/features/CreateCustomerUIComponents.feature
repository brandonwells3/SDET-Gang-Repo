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
@tag
Feature: Verify UI Components of the Customers Page
  			 for Crater Invoice App

  @createCustomerUIComponentValidation
  Scenario: Verify UI Components of the Customers Page
    Given As an entity user, I am logged in
    When I click on the Customer Menu link
    Then I should see a page titled Customers
    And I should see the menu navigation paths as Home / customers placed under Customers
    And I should see a button labeled Filter
    And I should see a button labeled + Add Customer
    # And I should see a table with the Columns: 
   	And I see Pagination text as follow: Showing 1 to 10 of item Total results
   	And I should see Left and Right Arrows allowing user to navigate to previous and next pages 
		And I should see number indicating the page the user is currently on and the next upcoming page
  	
  	When I click on the first page
		Then The Left Navgation Arrow should be disabled
		
		When I click on the last page
		Then The Right Navigation Arrow should be disabled
  
  

  
