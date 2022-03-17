Feature: Login

  Scenario: Successful login with valid credentials
    Given User launch Firefox browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page title becomes "Your store. Login"
    And Close browser

  Scenario Outline: Successful login with valid credentials
    Given User launch Firefox browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page title becomes "Your store. Login"
    And Close browser

    Examples:
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin123 |



