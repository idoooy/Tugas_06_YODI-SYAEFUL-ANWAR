Feature: Go To About

  @About
  Scenario: Success Go To About
    Given Login page saucedemo
    When User input username
    And User input password
    And User click login button
    Then User in product page
    When User click sidebar menu
    And User click menu about
    Then User in about page