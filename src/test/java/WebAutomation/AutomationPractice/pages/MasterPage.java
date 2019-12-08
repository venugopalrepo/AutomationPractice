package WebAutomation.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class MasterPage extends PageObjectEnhanced{

	public MasterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Terms and conditions of use')]")
	private WebElement termsAndConditions;
	
	@FindBy(xpath = "//span[@class='navigation_page']")
	private WebElement navigationLink;
	
	public String getNavigationLinkText() {
		return navigationLink.getText();
	}
	
}