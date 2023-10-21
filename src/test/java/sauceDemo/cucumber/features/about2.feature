Feature: Go To About2

  @About2
  Scenario: Success Go To About
    Given Product page saucedemo2
    When User click sidebar menu2
    And User click menu about2
    Then User in about page2