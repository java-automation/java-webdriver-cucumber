@quote
Feature: Quote test suite

  @quote1
  Scenario: Quote smoke test
    Given I navigate to "quote" page
    When I fill out the required fields on the form
    When I submit the quote form
    And I wait for 1 sec
    Then I see required fields submitted successfully











  @market2 @smoke
  Scenario: Quote name validation
    Given I navigate to "quote" page
    When I fill out the name field with first name "John" and last name "Doe"
    Then I validate that value in the name field is "John Doe"

  @market3
  Scenario: Multi select
    Given I navigate to "quote" page
    When I select "Ford" and "BMW" car makes
    And I wait for 5 sec

  @market4
  Scenario: New window
    Given I navigate to "quote" page
    When I click on related documents link
    Then I verify that "Document 2" is present in the documents list


  @market5_oop
  Scenario: Quote smoke test oop
    Given I navigate to "quote" page
    When I fill out the required fields on the form oop
    And I fill out the optional fields on the form oop
    And I submit the quote form oop
    Then I see required fields submitted successfully oop
    Then I see optional fields submitted successfully oop
