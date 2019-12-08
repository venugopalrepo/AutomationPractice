package WebAutomation.AutomationPractice.steps;

import WebAutomation.AutomationPractice.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;

public class CheckoutSteps {

	public CheckoutPage checkoutPage;
	
	@Step
	public void goToCheckoutSummary() {
		checkoutPage.clickOnShoppingCart();
		checkoutPage.verifyShoppingCartDisplayed();
	}
	
	@Step
	public void fromShoppingCartGoToBankWirePayment() {
		checkoutPage.clickProceedToCheckout();
		checkoutPage.verifyCheckoutAddressDisplayed();
		checkoutPage.clickProcessAddressToCheckout();
		checkoutPage.verifyCheckoutShippingDisplayed();
		checkoutPage.tickTAndCs();
		checkoutPage.clickProcessCarrierToCheckout();
		checkoutPage.verifyCheckoutPaymentMethodDisplayed();
		checkoutPage.chooseBankWirePaymentMethod();
		checkoutPage.verifyCheckoutBankWireMethodDisplayed();
		checkoutPage.clickOnConfirmOrder();
	}
	
	@Step
	public void orderConfirmed() {
		checkoutPage.checkOrderIsConfirmed();
	}
}