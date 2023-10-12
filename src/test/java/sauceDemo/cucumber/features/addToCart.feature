Feature: Add To Chart

  Scenario: Success Add To Chart
    Given Halaman login saucedemo
    When User input username
    And User input password
    And User click login button
    Then User in product page
    When User click button add to cart
    And User click button cart
    Then User in cart page

