@LoginUIComponentsValidation
Feature: Verify UI Components of Login page for Crater App.

  @LoginUIComponents
  Scenario: Verify UI Components 
    Given As a user, I am on the Login Page of crater App.
    And I should see Page Title "crater"
    And I should be able to see a Text Box with the Label "Email *"
    And I sholud see a Text Box with the lable "Password*" 
    And I should see a link titled "Forgot Passowrd?"
    And I should see a primary button labled "Login"
    And I should see a Text area on the bottom left "Copyright @ Crater Invoice, Inc. 2023"
    And I should see the first Heading with the following text "Simple Invoicing for Individuals Small Businesses"
    And I should see the second Heading "Crater helps you track expenses, record payments & generate beautiful invoices & estimates."