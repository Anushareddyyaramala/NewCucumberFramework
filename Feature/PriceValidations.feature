
Feature: verify the functionality of the products 


  Scenario Outline: Verify the functionality of products
    Given User Navigates to the homepage using Url
    When  User enters the "<product>" in searchbar
    And   User selects the required product
    Then verify the price of the product with ActualCost

    Examples: 
         |      product                 | 
         |     Titan Women Analog Watch | 
     
