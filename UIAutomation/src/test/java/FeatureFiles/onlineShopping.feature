Feature: Shop online using registered account

@priceSort
@positiveScenario
Scenario Outline: User navigates to item
Given User has logged into account with <email> and <password>
When User searches for summer dress via megamenu
And User sorts results by price
Then Product grid should display summer dresses by increasing price

Examples:
|email	|password|
|bradyquinn96@gmail.com|testpassword|

@cartCheck
@positiveScenario
Scenario Outline: User selects item and desired colour and then adds item to cart
Given User has logged in with <email> and <password> and navigated to summer dresses
When User clicks on dress, selects colour and adds item to cart
Then Validate that correct item added and information in cart is correct

Examples:
|email	|password|
|bradyquinn96@gmail.com|testpassword|