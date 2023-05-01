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
@createItemAddNewSuccessful
Feature: Verify Add New Item - Succeful
  
  @createItemAddNewSuccessfulWaitForMessDisapearance
    Scenario: User entereds Valid values to the data fields and wait for success message to disapear
  Given As an entity user, I am logged in
  When I click on the Items Menu link
  Then I should see a page titled Items
  When I click + Add Item button
  Then I should see a page titled New Item 
  When I provide valid item information name "popsicle", price "199", unit "Dollars", and description "A cold Treat"
  Then I should see a Success! popup message with a close button to the right
  And The flash message should disapear within five seconds or less
  And I should be directed to the Items Page
  When I should see a button labeled Filter
  And I should see the new item added in the items table
  And I should see the new item in database
  
   @createItemAddNewSuccessfulClickXBTN
   Scenario: User entereds Valid values to the data fields and close success message
  Given As an entity user, I am logged in
  When I click on the Items Menu link
  Then I should see a page titled Items
  When I click + Add Item button
  Then I should see a page titled New Item 
  When I provide valid item information name "popsicle", price "199", unit "Dollars", and description "A cold Treat"
  Then I should see a Success! popup message with a close button to the right
  And I click the X next on the right side of success message
  And I should be directed to the Items Page
  When I should see a button labeled Filter
  And I should see the new item added in the items table
  And I should see the new item in database
  
 
   	