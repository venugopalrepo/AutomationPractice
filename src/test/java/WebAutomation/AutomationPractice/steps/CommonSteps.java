package WebAutomation.AutomationPractice.steps;

import net.thucydides.core.annotations.Step;
import WebAutomation.AutomationPractice.definitions.CommonDefinitions;
import WebAutomation.AutomationPractice.pages.AuthenticationPage;
import WebAutomation.AutomationPractice.pages.CheckoutPage;
import WebAutomation.AutomationPractice.pages.HomePage;
import WebAutomation.AutomationPractice.pages.MyAccountPage;
import WebAutomation.AutomationPractice.pages.RegistrationPage;

public class CommonSteps {

	public HomePage homePage;
	public AuthenticationPage authenticationPage;
	public MyAccountPage myAccountPage;
	public CheckoutPage checkoutPage;
	public RegistrationPage registrationPage;
	
	@Step
	public void openTheHomePage() {
		homePage.openAt(CommonDefinitions.URL);
		homePage.getDriver().manage().window().maximize();
	}

	@Step
	public void verifyHomePageDisplayed() {
		homePage.verifyHomePageDisplayed();
	}

	@Step
	public void verifyMyAccountPageDisplayed() {
		myAccountPage.verifyMyAccountPageDisplayed();
	}
	
	@Step
	public void navigateToSignInPage() {
		homePage.clickOnSignIn();
		authenticationPage.verifyAuthenticationPageDisplayed();
	}
	
	@Step
	public void checkSignOutLinkDisplayed() {
		homePage.checkSignOutLinkDisplayed();
	}
	
	@Step
	public void checkUserIsNotSignedIn() {
		homePage.checkIfUserNotSignedIn();
	}
	
	@Step
	public void registerUser() {
	checkoutPage.submitNewEmail();
	registrationPage.waitUntilRegistrationFormLoaded();
	registrationPage.submitRegistrationDetails();
	}
}