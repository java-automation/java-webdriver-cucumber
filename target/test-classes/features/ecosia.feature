@ecosia
Feature: Ecosia

  @ecosia1
  Scenario: Ecosia footer links validation
    Given I navigate to "ecosia" page
    When I click on "Careers" footer link
    And I wait for 3 sec
    Then I verify "Open positions" link is displayed
