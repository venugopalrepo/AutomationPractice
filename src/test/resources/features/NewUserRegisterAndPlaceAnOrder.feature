Feature: New user register and place an order
@Demo
Scenario: New user register during checkout process and place an Order

Given user navigate to the shop page
When adds below product to cart
| ProductName 					| ProductReference	| Size 	| Colour   	| Quantity 	|
| Faded Short Sleeve T-shirts	| demo_1			| M 	| Blue 		| 1			|
| Blouse						| demo_2			| S 	| White		| 1			|
And user register and pays the order through bank wire transfer
Then order placed successfully