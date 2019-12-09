package WebAutomation.AutomationPractice.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import WebAutomation.AutomationPractice.steps.CheckoutSteps;
import WebAutomation.AutomationPractice.steps.CommonSteps;

public class CheckoutDefinitions {
	
	@Steps
	CheckoutSteps checkoutSteps;
	
	@Steps
	CommonSteps commonSteps;
	
	
	@When("^pays the order through bank wire transfer$")
	public void checkoutByBankWireTransfer() {
		checkoutSteps.goToCheckoutSummary();
		checkoutSteps.fromShoppingCartGoToBankWirePayment();
			
	}
	
	@When("^user register and pays the order through bank wire transfer$")
	public void registerAndCheckoutByBankWireTransfer() {
		checkoutSteps.goToCheckoutSummary();
		checkoutSteps.fromShoppingCartToRegistration();
		commonSteps.registerUser();
		checkoutSteps.fromAddressGoToBankWirePayment();	
	}
	
	@Then("^order placed successfully$")
	public void orderConfirmation() {
		checkoutSteps.orderConfirmed();			
	}
}
