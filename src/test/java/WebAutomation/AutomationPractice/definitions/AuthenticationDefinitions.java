package WebAutomation.AutomationPractice.definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import WebAutomation.AutomationPractice.steps.AuthenticationSteps;
import WebAutomation.AutomationPractice.steps.CommonSteps;

public class AuthenticationDefinitions {
	@Steps
	CommonSteps commonSteps;	
	
	@Steps
	AuthenticationSteps authenticationSteps;
	
	
	@Given("^login with below credentials$")
	public void login(DataTable table) {
		List<List<String>> data = table.raw();
		System.out.println(data.get(1).get(1));
		commonSteps.navigateToSignInPage();
		authenticationSteps.login(data);
		commonSteps.checkSignOutLinkDisplayed();
		commonSteps.verifyMyAccountPageDisplayed();
		
	}
}
