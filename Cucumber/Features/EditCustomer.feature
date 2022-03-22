Feature: SearchCustomer

  Scenario: Edit existing Customers
    Given User launch Firefox browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on Customer menu
    And User clicks on Customer menu item
    Then User finds Customer and clicks on Edit button
    Then Edit the Customer info
    And Clicks on Save Button
    Then Checks the Edited info of the customer
    And Close the browser