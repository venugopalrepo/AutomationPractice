package WebAutomation.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class MyAccountPage extends MasterPage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private String myAccountResource = "My account";
	
		
	public void verifyMyAccountPageDisplayed() {
		Assert.assertEquals("My Account page not displayed", myAccountResource, this.getNavigationLinkText());
	}
	
}
