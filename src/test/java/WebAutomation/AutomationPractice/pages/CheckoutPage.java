package WebAutomation.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebAutomation.AutomationPractice.utility.Common;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CheckoutPage extends MasterPage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	private String shoppingCartResource = "Your shopping cart";
	private String authenticationResource = "Authentication";
	private String addressesResource = "Addresses";
	private String shippingResource = "Shipping";
	private String paymentMethodResource = "Your payment method";
	private String bankWirePaymentResource = "Bank-wire payment.";
	private String orderConfirmedResource = "Order confirmation";
	
	@FindBy(xpath = "//a[@title=\"View my shopping cart\"]")
	private WebElement shoppingCart;
	
	@FindBy(xpath = "//a[@class='bankwire']")
	private WebElement bankWirePayment;
	
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedCheckoutButton;
	
	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	private WebElement processAddress;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	private WebElement processCarrier;
	
	@FindBy(xpath = "//label[contains(text(),'I agree to the terms of service and will adhere to')]")
	private WebElement tAndCsTickBox;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrder;
	
	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement createEmail;
	
	@FindBy(xpath = "//button[@id=\"SubmitCreate\"]")
	private WebElement createAccountButton;
	
	
	public void submitNewEmail() {
		type(createEmail, Common.getRandomEmail());
		createAccountButton.click();
	}
	
	public void clickOnConfirmOrder() {
		confirmOrder.click();
	}
	
	public void clickOnShoppingCart() {
		WebDriverWait wait=new WebDriverWait(this.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(shoppingCart));
		shoppingCart.click();
	}
	
	public void clickProceedToCheckout() {
		WebDriverWait wait=new WebDriverWait(this.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(proceedCheckoutButton));
		proceedCheckoutButton.click();
	}
	
	public void clickProcessAddressToCheckout() {
		WebDriverWait wait=new WebDriverWait(this.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(processAddress));
		processAddress.click();
	}
	
	public void clickProcessCarrierToCheckout() {
		WebDriverWait wait=new WebDriverWait(this.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(processCarrier));
		processCarrier.click();
	}
	
	public void tickTAndCs() {
//		WebDriverWait wait=new WebDriverWait(this.getDriver(), 5);
//		wait.until(ExpectedConditions.visibilityOf(tAndCsTickBox));
		tAndCsTickBox.click();
	}
	
	public void chooseBankWirePaymentMethod() {
		WebDriverWait wait=new WebDriverWait(this.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(bankWirePayment));
		bankWirePayment.click();
	}
	
	public void verifyShoppingCartDisplayed() {
		Assert.assertEquals("Shopping cart page not displayed", shoppingCartResource, this.getNavigationLinkText());
	}
	
	public void verifyCheckoutAddressDisplayed() {
		Assert.assertEquals("Checkout Address not displayed", addressesResource, this.getNavigationLinkText());
	}
	
	public void verifyAuthenticationPageDisplayed() {
		Assert.assertEquals("Authentication page not displayed", authenticationResource, this.getNavigationLinkText());
	}
	
	public void verifyCheckoutShippingDisplayed() {
		Assert.assertEquals("Checkout Shipping not displayed", shippingResource, this.getNavigationLinkText());
	}
	
	public void verifyCheckoutPaymentMethodDisplayed() {
		Assert.assertEquals("Checkout Payment Method page not displayed", paymentMethodResource, this.getNavigationLinkText());
	}
	
	public void verifyCheckoutBankWireMethodDisplayed() {
		Assert.assertEquals("Checkout BankWire payment page not displayed", bankWirePaymentResource, this.getNavigationLinkText());
	}
	
	public void checkOrderIsConfirmed() {
		Assert.assertEquals("Checkout Order Confirmation not displayed", orderConfirmedResource, this.getNavigationLinkText());
	}
	
	
}
