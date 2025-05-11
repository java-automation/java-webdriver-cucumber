Feature: Quote Page

  #  As a User I want to fill out the Quote page
#  So that I can profit
  Background: As a User I want to fill out the Quote page, So that I can profit


  #E2E Scenario for the Quote Page
  Scenario: E2E Scenario for the Quote Page
#  1. Go to https://skryabin.com/market/quote.html
    Given I open url "https://skryabin.com/market/quote.html"
#  2. Fill out all the required fields
    When I type "userName" into element with xpath "//input[@name='username']"
    #Then I verify username is typed into the box


    When I type "test@test.com" into element with xpath "//input[@name='email']"
    When I type "abcd1234" into element with xpath "//input[@name='password']"
    When I type "abcd1234" into element with xpath "//input[@id='confirmPassword']"
    When I click on element with xpath "//input[@id='name']"
    When I type "My" into element with xpath "//input[@id='firstName']"
    When I type "Name" into element with xpath "//input[@id='lastName']"
    When I click on element with xpath "//span[text()='Save']/parent::button"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    #  3. Click Submit Button
    When I click on element with xpath "//button[@id='formSubmit']"
    And I wait for 4 sec
#  Expected Result:
#  User lands on the Submitted Page
    Then element with xpath "//legend[@class='applicationResult']" should be present
    Then element with xpath "//b[@name='username']" should have text as "userName"








