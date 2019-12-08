package WebAutomation.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;

public class AuthenticationPage extends MasterPage {

	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}
	
	private String authenticationResource = "Authentication";
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password;
	
	@FindBy(css = "button[id=\"SubmitLogin\"]")
	private WebElement submitButton;
	
		
	public void verifyAuthenticationPageDisplayed() {
		Assert.assertEquals("Authentication page not displayed", authenticationResource, this.getNavigationLinkText());
	}
	
	public void login(List<List<String>> data) {
		type(emailAddress, data.get(1).get(1));
		type(password, data.get(2).get(1));
		submitButton.click();
	}
}
