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
@ForgotPasswordFunctionality
Feature: Verify Forgot Password Functionality for Crater Invoice App

  Background: 
    Given I go to Crater App Website
    And I click Forgot Password link

  @FPFunctionalitytestCase1
  Scenario: User enters an invalid email
    When I enter an invalid email to the rest field
    Then I see an error message

  @FPFunctionalitytestCase2
  Scenario: User enters a valid email
    When I enter a valid email to the reset field
    And I click on Send Rest Link button
    Then I should see a popup alert with a message
    When I click Back to Login? link
    Then I should be directed to the Login Page

  @FPFunctionalitytestCase3
  Scenario: User goes back to Login Page
    When I click Back to Login? link
    Then I should be directed to the Login Page
