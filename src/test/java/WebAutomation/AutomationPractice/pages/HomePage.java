package WebAutomation.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class HomePage extends PageObjectEnhanced {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(css = "a[title=\"Contact Us\"]")
	private WebElement contactUs;

	@FindBy(xpath = "//a[@class='login']")
	private WebElement signIn;
	
	@FindBy(xpath = "//a[@class='logout']")
	private WebElement logout;

	public void verifyHomePageDisplayed() {
		contactUs.isDisplayed();
		signIn.isDisplayed();
	}
	
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public void checkSignOutLinkDisplayed() {
		logout.isDisplayed();
	}
}
