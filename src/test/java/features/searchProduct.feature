Feature: Search and place the order for products
@OffersPage
Scenario Outline: Search Experience for product search in both fome and offer page

Given User is on GreenCart Landing page
When user searched with Shortname <Name> and extracted actual name of product
Then user searched for <Name> in offers page
And validate product name in offers page matches with landing page

Examples: 
| Name |
| Tom  |
| Beet |