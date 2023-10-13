Feature: Login Application saucedemo

  @LoginDDT
  Scenario Outline: Success Login
    Given Login page saucedemo
    When User input <username> as username
    And User input <password> as password
    And User click login button
    Then User verify <status> login result

    Examples:
    | username        | password     | status   |
    | standard_user   | secret_sauce | success  |
    | standard_user1  | secret_sauce | failed   |
