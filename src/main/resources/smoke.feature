Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check adding items to cart
    Given user navigates to home page
    And user goes to login page
    And user logs in '<email>','<password>'
    And user search  product '<request>'
    When user chooses second item on the search result page
    And  user adds item to cart
    Then user checks that cart contain '<expected>' product
    Examples:
      | email                     |    password   | request | expected   |
      | ivan.shustur2017@gmail.com|    qwe159753  | samsung |     1      |


  Scenario Outline: Check login to account
    Given user navigates to home page
    And user goes to login page
    And user logs in '<email>','<password>'
    And user verify is he logged in '<expectedText>'
    Examples:
      | email                     |    password   | expectedText |
      | ivan.shustur2017@gmail.com|    qwe159753  | Hello, Ivan|


  Scenario Outline: Check deleting items from cart
    Given user navigates to home page
    And user goes to login page
    And user logs in '<email>','<password>'
    And user search  product '<request>'
    When user chooses second item on the search result page
    And  user adds item to cart
    And user opens shopping cart
    And user deletes item from cart
    Then user checks that cart contain '<expected>' product
    Examples:
      | email                     |    password   | request | expected   |
      | shustur1@ukr.net          | qwerty159753  | samsung |     0      |


  Scenario Outline: Check warning of inputting incorrect email
    Given user navigates to home page
    And user goes to login page
    And user input incorrect '<email>'
    Then user checks the warning of incorrect email input

    Examples:
      | email                     |    password   |
      | kaniy.v@gmail.com         |    qwe159753  |


  Scenario Outline: Check warning of inputting incorrect password
    Given user navigates to home page
    And user goes to login page
    And user input correct '<email>' and incorrect '<password>'
    Then user checks the warning of incorrect email input

    Examples:
      | email                     |    password   |
      | shustur1@ukr.net          |    qwe159     |


  Scenario Outline: Check changing the number of items in the cart
    Given user navigates to home page
    And user goes to login page
    And user logs in '<email>','<password>'
    And user search  product '<request>'
    When user chooses second item on the search result page
    And  user adds item to shopping cart
    And user opens shopping cart
    And user change number of items in the cart
    Then user checks that cart contain '<expected>' product
    Examples:
      | email                     |    password   | request | expected   |
      | rosokham040@gmail.com     | asd159753     | nokia   |     1       |


  Scenario Outline: Check filtering by item brand
    Given user navigates to home page
    And user goes to login page
    And user logs in '<email>','<password>'
    And User opens menu
    And User clicks 'Electronics' button
    And User clicks 'Headphones' button
    When User chooses filtering by '<brandName>'
    Then User checks that results contain '<brandName>'

    Examples:
      | email                     |    password   |   brandName |
      | shustur1@ukr.net          | qwerty159753  |   Apple     |


  Scenario: Check sorting items by price descending order
    Given user navigates to home page
    And User opens menu
    And User clicks 'Electronics' button
    And User clicks 'Headphones' button
    And User chose amazon.com seller
    When User sorts items by descending order
    Then User checks that items are sorted by descending order


  Scenario Outline: Check that search result meets search text
    Given user navigates to home page
    And user goes to login page
    And user logs in '<email>','<password>'
    When User makes search by keyword '<keyword>'
    Then User checks that search result contains search keyword '<keyword>'

    Examples:
      | email                     |    password   |    keyword |
      | shustur1@ukr.net          | qwerty159753  |    samsung |




  Scenario Outline: Check that item is displayed in the search results
    Given user navigates to home page
    And user goes to login page
    And user logs in '<email>','<password>'
    When User makes search by keyword '<keyword>'
    Then User checks that search result with '<keyword>' is visible

    Examples:
      | email                     |    password   |            keyword                                   |
      | shustur1@ukr.net          | qwerty159753  | Sony MDR7506 Professional Large Diaphragm Headphone  |

