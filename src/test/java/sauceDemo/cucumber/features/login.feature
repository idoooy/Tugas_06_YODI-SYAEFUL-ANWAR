Feature: Login Application saucedemo

  @LoginPositive
  Scenario: Success Login
    Given Halaman login saucedemo
    When User input username
    And User input password
    And User click login button
    Then User in product page

  @LoginNegative
  Scenario: Failed Login
    Given Halaman login saucedemo
    When User input invalid username
    And User input password
    And User click login button
    Then User get error message