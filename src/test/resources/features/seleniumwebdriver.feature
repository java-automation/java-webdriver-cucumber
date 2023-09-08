# Author: Deepti Prem
# AOD-941
@webdriver
Feature: practice with Selenium Webdriver Methods
  @webdriver1
  Scenario: Open webpage and explore the property
    # Given I open url "https://google.com"
    Given DP navigates to URL "ASK"
    Then DP gets page information
    Then DP maximizes the window
    Then I wait for 3 sec




