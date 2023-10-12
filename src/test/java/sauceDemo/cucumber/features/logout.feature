Feature: Logout Application saucedemo

  Scenario: Success Logout
    Given Halaman login saucedemo
    When User input username
    And User input password
    And User click login button
    Then User in product page
    When User click sidebar menu
    And User click logout
    Then User in login page