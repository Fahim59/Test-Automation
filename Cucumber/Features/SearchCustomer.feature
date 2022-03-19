Feature: SearchCustomer

  Background: These are the common steps
    Given User launch's Firefox browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And Click Login
    Then Page title should "Dashboard / nopCommerce administration"
    When User click on Customer menu
    And User click on Customer menu item

  Scenario: Search existing Customers by Email
    When User types email as "james_pan@nopCommerce.com"
    And Click on Search button
    Then User can see email "james_pan@nopCommerce.com" in the table
    And Closes browser

  Scenario: Search existing Customers by First Name
    When User types name as "James"
    And Click on Search button
    Then User can see name "James" in the table
    And Closes browser