@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//*[@name='q']" should be present
    When I type "Cucumber" into element with xpath "//*[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"


  @gibiru
  Scenario: Steps for gibiru
    Given I open url "http://gibiru.com"
    Then I should see page title contains "Gibiru "
    Then element with xpath "//input[@id='q']" should be present
    When I type "cat towers" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    And I wait for element with xpath "//div[@id='web-results']" to be present
    Then element with xpath "//div[@id='web-results']" should contain text "tower"


  @duckduckgo
  Scenario: Steps for duckduckgo
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo "
    Then element with xpath "//input[@name='q']" should be present
    When I type "cat towers" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    And I wait for element with xpath "//div[@id='web_content_wrapper']" to be present
    Then element with xpath "//div[@id='web_content_wrapper']" should contain text "tower"


  @swisscows
  Scenario: Steps for swisscows
    Given I open url "https://swisscows.com"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@class='input-search']" should be present
    When I type "cat towers" into element with xpath "//input[@class='input-search']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    And I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "tower"


  @searchencrypt
  Scenario: Steps for searchencrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//input[@name='q']" should be present
    When I type "cat towers" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    And I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "tower"


  @startpage
  Scenario: Steps for startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage "
    Then element with xpath "//input[@id='q']" should be present
    When I type "cat towers" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//body/div[@id='root']/div[1]/div[1]/section[1]/div[3]/div[1]/div[3]/form[1]/div[1]/button[1]"
    And I wait for element with xpath "//div[@class='show-results']" to be present
    Then element with xpath "//div[@class='show-results']" should contain text "tower"


  @ecosia
  Scenario: Steps for ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia "
    Then element with xpath "//input[@name='q']" should be present
    When I type "cat towers" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    And I wait for element with xpath "//div[@class='web ']" to be present
    Then element with xpath "//div[@class='web ']" should contain text "tower"


#  @wiki
#  Scenario: Steps for wiki
#    Given I open url "https://www.wiki.com/"
#    Then I should see page title as "Wiki.com"
#    Then element with xpath "//input[@name='q']" should be present
#    When I type "cat towers" into element with xpath "//input[@name='q']"
#    Then I click on element using JavaScript with xpath "//input[@type='submit']"
#    And I wait for element with xpath "" to be present
#    Then element with xpath "" should contain text "tower"


  @givewater
  Scenario: Steps for givewater
    Given I open url "https://www.givewater.com/"
    Then I should see page title contains "giveWater "
    Then I wait for element with xpath "//img[@class='aligncenter size-full wp-image-171']" to be present
    When I click on element with xpath "//i[@class='fas fa-times']"
    Then element with xpath "//input[@id='site-search']" should be present
    When I type "cat towers" into element with xpath "//input[@id='site-search']"
    Then I click on element using JavaScript with xpath "//button[@class='btn-search']"
    And I wait for element with xpath "//div[@class='layout__body']" to be present
    Then element with xpath "//div[@class='layout__body']" should contain text "tower"


  @ekoru
  Scenario: Steps for ekoru
    Given I open url "https://ekoru.org/"
    Then I should see page title contains "Ekoru "
    Then element with xpath "//input[@name='q']" should be present
    When I type "cat towers" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@onclick='search()']"
    And I wait for element with xpath "//div[@class='serp-left-col']" to be present
    Then element with xpath "//div[@class='serp-left-col']" should contain text "tower"
