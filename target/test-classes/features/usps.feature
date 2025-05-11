@usps
Feature: USPS test suite

#  Background: Initial landing page navigation
##    Given I navigate to "usps lookup by address" page

  @usps1
  Scenario Outline: Validate ZIP code for multiple addresses
    Given I navigate to "usps lookup by address" page
    When I fill out "<street>" street, "<city>" city, "<state>" state
    And I submit lookup by address form
    Then I validate "<expected_zip>" zip code exists in the result
    Examples:
      | street                | city        | state  | expected_zip |
      | 4970 El Camino Real   | Los Altos   |  CA    | 94022        |
      | 11 Wall St            | New York    |  NY    | 10005        |
      | 20 South Wacker Drive | Chicago     |  IL    | 60606        |

  @usps2
  Scenario: Stamps and Supplies
    Given I navigate to "usps lookup by address" page
    When I click menu item "Stamps & Supplies" under "Send" menu

  @usps3
  Scenario: Shipping end to end
    Given I navigate to "usps lookup by address" page
    When I hover over search and search for "Boxes"
    And I filter results with "Send"
    Then I verify 8 results are displayed
    When I click on "Priority Mail | USPS" link
    And I click on "Ship Now" button
    Then I verify login page is displayed

