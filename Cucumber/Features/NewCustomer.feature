Feature: NewCustomer

  Scenario: Adding new Customers
    Given User launch the Firefox browser
    When User opens the URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email "admin@yourstore.com" and Password "admin"
    And Click on Login button
    Then Page title should be like "Dashboard / nopCommerce administration"
    When User clicks on Customer menu
    And User clicks on Customer menu item
    Then User clicks on Add New button
    Then Page title should be becomes "Add a new customer / nopCommerce administration"
    When User enters customer info
    And Click on Save button
    Then User can see confirmation message "The new customer has been added successfully."
    And Close the browser