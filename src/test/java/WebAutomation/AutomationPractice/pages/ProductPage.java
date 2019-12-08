package WebAutomation.AutomationPractice.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.findby.By;

@SuppressWarnings("deprecation")
public class ProductPage extends MasterPage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "h1[itemprop=\"name\"]")
	private WebElement productName;
	
	@FindBy(css = "span[itemprop=\"sku\"]")
	private WebElement productRef;
	
	@FindBy(xpath = "//select[@id='group_1']")
	private WebElement sizeDropDown;
	
	@FindBy(xpath = "//select[@id='group_1']/option[@selected='selected']")
	private WebElement selectedSize;
	
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	private WebElement quantity;

	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement addToCart;
	
	@FindBy(xpath="//div[@class='layer_cart_cart col-xs-12 col-md-6']//span[@class='continue btn btn-default button exclusive-medium']")
	private WebElement continueShopping;
	
	public String getProductPageResource(String productId) {
		return "/index.php?id_product=" + productId + "&controller=product";
	}
	
	public void checkProductDetailsDisplayed(String pName, String pRef) {
		Assert.assertEquals("Product Details not displayed", pName, this.productName.getText());
		Assert.assertEquals("Product Details not displayed", pRef, this.productRef.getText());
	}
	
	public void selectSize(String pSize) {
		Select drpSize = new Select (sizeDropDown);
		drpSize.selectByVisibleText(pSize);
	}
	
	@SuppressWarnings("deprecation")
	public void selectColour(String pColour) {
		String colourXpath = "//ul[@id='color_to_pick_list']//a[@name='" + pColour + "']";
		WebElement colourElement = this.getDriver().findElement(By.xpath(colourXpath));
		colourElement.click();
	}
	
	public void enterQuantity(String pQnty) {
		type(quantity, pQnty);
	}
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	public void clickOnContinueShopping() {
		WebDriverWait wait=new WebDriverWait(this.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(continueShopping));
		continueShopping.click();
	}
}
