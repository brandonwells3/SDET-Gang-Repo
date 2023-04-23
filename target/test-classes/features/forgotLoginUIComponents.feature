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
@FPUIComponentTest
Feature: Verify UI components of the 'Forgot Password'
				 link for the Carter App

  @UIComponentTest
  Scenario Outline: Verify UI components
    Given I go to Crater App Website
    And I click Forgot Password link
    Then I see a "<obj>" labeled "<text>"
    
    Examples: 
      | obj        | text            |
      | text field | Enter Email     |
      | button     | Send Reset Link |
      | link       | Back to Login?  |
    
