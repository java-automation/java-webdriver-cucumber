# Author: Tatiana Konoplia
# email: konoplya.t95@gmail.com
# ASK071323-322
@webdriver
Feature: practice with Selenium WebDriver methods

  @webdriver1
  Scenario: Open webpage and explore its property
      #Given I open url "https://www.google.com" =
    Given TK navigate to URL "Google"
    Then TK get page info
    Then TK maximize the window
    Then I wait for 5 sec