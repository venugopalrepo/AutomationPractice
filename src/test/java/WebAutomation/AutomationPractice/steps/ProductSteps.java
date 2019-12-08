package WebAutomation.AutomationPractice.steps;

import WebAutomation.AutomationPractice.definitions.CommonDefinitions;
import WebAutomation.AutomationPractice.pages.ProductPage;
import net.thucydides.core.annotations.Step;

public class ProductSteps {

	public ProductPage productPage;
	
	@Step
	public void openProductPage(String pName, String pRef) {
	String productId = CommonDefinitions.dataProps.getProperty(pRef);
	String productResource = productPage.getProductPageResource(productId);
	productPage.getDriver().get(CommonDefinitions.URL + productResource);
	productPage.checkProductDetailsDisplayed(pName, pRef);
	}
	
	@Step
	public void addProduct(String pSize, String pColour, String pQnty) {
		productPage.selectSize(pSize);
		productPage.selectColour(pColour);
		productPage.enterQuantity(pQnty);
		productPage.clickOnAddToCart();
		productPage.clickOnContinueShopping();
	}
	
}