@search
  Feature: Automate Core Functionality of the HomeDepot Client Page

    Background: As a user, I want to be greeted with some cool slider,
                I also want all the header and footer links to work,
                so that I am empowered to shop here

      @search1
      Scenario: Search Functionality works as expected
#        Given I land of the Home Depot Page
#        Then I should see a cool slider
#        When I type "Drills" into the search bar
#        And I click search Icon
#        Then I should see matching result
        Given I open url "https://www.homedepot.com/"
        Then I wait for element with xpath "//div[@id='hero-carousel']" to be present
        # We still need to assert it\
#        When I click on element with xpath "//input[@id='typeahead-search-field-input']"
#        And I wait for 3 sec
        When I type "Drills" into element with xpath "//input[@id='typeahead-search-field-input']"
        When I click on element with xpath "//button[@id='typeahead-search-icon-button']"
        And I wait for 3 sec
        Then element with xpath "//img[@title='Image for UP TO 35% OFF']" should be present

