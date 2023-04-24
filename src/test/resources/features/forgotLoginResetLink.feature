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
@FPResetPasswordFunctionality
Feature: Test Functionality of Reset Password Link

  Background: 
    Given I go to Crater App Website
    And I click Forgot Password link
    
    When I enter dummy email
    Then I should see a popup alert with a message
    When I go to gmail.com
    And I open an email with the subject Rest Password Notification
    Then I should see an email reset link
    When I click the password reset link
    Then I should be directed to the password reset page
    And I should see three text fields

  @FPRestTestCase1
  Scenario: TestCase1
    When I enter a valid email
    And I enter a valid password
    And I enter a valid retype password
    Then I should be directed to the Login Page
    

  @FPRestTestCase2
  Scenario: TestCase2
    When I enter an invalid email
    And I enter a valid password
    And I enter a valid retype password

  # Then I should see an error message
  @FPRestTestCase3
  Scenario: TestCase3
    When I enter an invalid email
    And I enter an invalid password
    And I enter a valid retype password

  # Then I should see an error message
  @FPRestTestCase4
  Scenario: TestCase4
    When I enter an invalid email
    And I enter an invalid password
    And I enter an invalid retype password

  # Then I should see an error message
  @FPRestTestCase5
  Scenario: TestCase5
    When I enter a valid email
    And I enter a valid password
    And I enter an invalid retype password

  # Then I should see an error message
  @FPRestTestCase6
  Scenario: TestCase6
    When I enter a valid email
    And I enter an invalid password
    And I enter a valid retype password

  # Then I should see an error message
  @FPRestTestCase7
  Scenario: TestCase7
    When I enter a valid email
    And I enter an invalid password
    And I enter an invalid retype password

  # Then I should see an error message
  @FPRestTestCase8
  Scenario: TestCase8
    When I enter an invalid email
    And I enter a valid password
    And I enter an invalid retype password
