Feature: Registered user place an order
@Demo
Scenario: Already registered user place an Order for multiple products

Given user navigate to the shop page
And login with below credentials
| Fields                 | Values              	|
| Email Address          | abctest@test.com		|
| Password               | test@123           	|
When adds below product to cart
| ProductName 					| ProductReference	| Size 	| Colour   	| Quantity 	|
| Faded Short Sleeve T-shirts	| demo_1			| M 	| Blue 		| 1			|
| Blouse						| demo_2			| S 	| White		| 1			|
And pays the order through bank wire transfer
Then order placed successfully