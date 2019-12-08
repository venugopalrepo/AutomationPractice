package WebAutomation.AutomationPractice.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import WebAutomation.AutomationPractice.steps.CheckoutSteps;

public class CheckoutDefinitions {
	
	@Steps
	CheckoutSteps checkoutSteps;
	
	
	@When("^pays the order through bank wire transfer$")
	public void checkoutByBankWireTransfer() {
		checkoutSteps.goToCheckoutSummary();
		checkoutSteps.fromShoppingCartGoToBankWirePayment();
			
	}
	
	@Then("^order placed successfully$")
	public void orderConfirmation() {
		checkoutSteps.orderConfirmed();			
	}
}
