@boardreader
Feature: Boardreader test suite

  @boardreader1
  Scenario: Boardreader smoke test
    Given I navigate to "boardreader" page
    When I search for "cucumber test" on boardreader
    Then I validate "io.cucumber" shows on boardreader results
