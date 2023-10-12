Feature: Go To About

  Scenario: Success Add To Chart
    Given Halaman login saucedemo
    When User input username
    And User input password
    And User click login button
    Then User in product page
    When User click sidebar menu
    And User click menu about
    Then User in about page