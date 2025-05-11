@converter
Feature: Converter test cases


  @converter1
  Scenario: Convert from Fahrenheit to Celsius
    Given I navigate to "converter" page
    When I type "100" in Fahrenheit input field
    Then I see "37.7" in Celsius input field
    And I wait for 2 sec