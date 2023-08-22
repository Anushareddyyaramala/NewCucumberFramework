
Feature: verify the functionality of the products 


  Scenario Outline: Verify the  products costs
    Given User Navigates to the homepage using Url
    When  User enters the "<product>" in searchbar
    And   User selects the required product
    Then verify the zoomed product is visible when mousehover on it

    Examples: 
         |      product                 | 
         |     Titan Women Analog Watch | 
     

 