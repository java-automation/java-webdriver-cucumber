@commerce
  Feature: NOP Commerce Test Suite

    @commerce1
    Scenario: Commerce registration smoke test
      Given I navigate to "nop commerce registration" page
      When I fill out required user personal details on the registration form
      And I submit the registration form
      Then I see that user registration was successful
      And I verify that required user fields saved correctly on account page

    @commerce2
    Scenario: Commerce registration optional fields test
      Given I navigate to "nop commerce registration" page
      When I fill out required user personal details on the registration form
      And I fill out optional fields on the registration form
      And I submit the registration form
      Then I see that user registration was successful
      And I verify that required user fields saved correctly on account page
      And I verify that optional user fields saved correctly on account page

    @commerce3
    Scenario: Commerce books page test
      Given I navigate to "nop commerce registration" page
      When I navigate to "Books" commerce page
      Then I verify that "Fahrenheit 451 by Ray Bradbury" item cost is "$27.00"
      




