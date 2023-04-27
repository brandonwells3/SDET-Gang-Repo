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
    
    When I enter dummy email to the email rest field
    And I click Send Reset Link button
    Then I should see a popup alert Success!
    When I go to gmail.com
    And I open an email with the subject Rest Password Notification
    Then I should see an email reset link
    When I click the password reset link
    Then I should be directed to the password reset page
    And I should see three text fields

  @FPResetTestCase1 @FPResetValid
  Scenario: TestCase1
    When I enter a valid email to the email reset field
    And I enter a valid password to the password reset field
    And I enter a valid retype password to the retype password reset field
    
    When I click Reset Password button
    Then I should not see any reset password error messages
    And I should be directed to the Login Page
    

  @FPResetTestCase2 @FPResetInValid
  Scenario: TestCase2
    When I enter an invalid email to the email reset field
    And I enter a valid password to the password reset field
    And I enter a valid retype password to the retype password reset field
    
    When I click Reset Password button
    Then I should see a popup alert Error Somathing Went Wrong
    Then I should not be directed to the Login Page

  @FPResetTestCase3 @FPResetInValid
  Scenario: TestCase3
    When I enter an invalid email to the email reset field
    And I enter an invalid password to the password reset field
    And I enter a valid retype password to the retype password reset field
    
   	And I should see an invalid password message
    
		When I click Reset Password button
    Then I should not be directed to the Login Page

  @FPResetTestCase4 @FPResetInValid
  Scenario: TestCase4
    When I enter an invalid email to the email reset field
    And I enter an invalid password to the password reset field
    And I enter an invalid retype password to the retype password reset field
    
   	And I should see an invalid password message
   	And I should see an invalid retype password message
    
		When I click Reset Password button
    Then I should not be directed to the Login Page

  @FPResetTestCase5 @FPResetInValid
  Scenario: TestCase5
    When I enter a valid email to the email reset field
    And I enter a valid password to the password reset field
    And I enter an invalid retype password to the retype password reset field
    
   	Then I should see an invalid retype password message
    
		When I click Reset Password button
    Then I should not be directed to the Login Page
    
  @FPResetTestCase6 @FPResetInValid
  Scenario: TestCase6
    When I enter a valid email to the email reset field
    And I enter an invalid password to the password reset field
    And I enter a valid retype password to the retype password reset field
    
    Then I should see an invalid password message
    
		When I click Reset Password button
    Then I should not be directed to the Login Page

  @FPResetTestCase7 @FPResetInValid
  Scenario: TestCase7
    When I enter a valid email to the email reset field
    And I enter an invalid password to the password reset field
    And I enter an invalid retype password to the retype password reset field
    
    Then I should see an invalid password message
    And I should see an invalid retype password message
    
    When I click Reset Password button
    Then I should not be directed to the Login Page

  @FPResetTestCase8 @FPResetInValid
  Scenario: TestCase8
    When I enter an invalid email to the email reset field
    And I enter a valid password to the password reset field
    And I enter an invalid retype password to the retype password reset field
    
    And I should see an invalid retype password message
    
    When I click Reset Password button
    Then I should not be directed to the Login Page
