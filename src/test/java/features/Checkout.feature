Feature: Place the order for products
@PlaceOrder
Scenario Outline: Search Experience for product search in both fome and offer page

Given User is on GreenCart Landing page
When user searched with Shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And Verify product user has ability to enter promo code and place the order

Examples: 
| Name |
| Tom  |
