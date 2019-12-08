package WebAutomation.AutomationPractice.steps;

import java.util.List;

import WebAutomation.AutomationPractice.pages.AuthenticationPage;
import net.thucydides.core.annotations.Step;

public class AuthenticationSteps {

	public AuthenticationPage authenticationPage;
	
	@Step
	public void login(List<List<String>> data) {
		authenticationPage.login(data);
	}
}