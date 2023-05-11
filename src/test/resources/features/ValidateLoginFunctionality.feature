

@login @regression
Feature: Verify Login functionality for Crater app.
  User with valid credentials, should be able to Login sucesfully on Crater app.
  
   Background: 
    Given As a user, I am on the login page
  

  @validLogin @smoketest
  Scenario Outline: valid login on Crater app.
  When User enters email "<email>" and password "<password>"
  And User click on login button
  Then User should be directed on the Dashboard page.
  
  Examples:
  | email                           | password         |
  | entityadmin@primetechschool.com | primetech@school |
  
  
   @invalidLogin
  Scenario Outline: Invalid email and password login
    When User enters invalid "<email>" and invalid "<password>"
    And User click on login button
    Then User should see an error message "Error Those credentials do not match our records."
   # And The flash message has a close button on the right and disapear in less than or equal to 5 seconds 
    And User should not be logged in
    
    Examples:
  | email                           | password         |
  | entitymin@primetechschool.com   | primech@school     |
   
  
  
  @emptyFieldsLogin
  Scenario: Empty email and password login
    When User leaves empty email "" and password "" field
    And User click on login button
    Then User should see the following "Email is Required" and  "Password is Required"
    And User should not be logged in
    
   
  