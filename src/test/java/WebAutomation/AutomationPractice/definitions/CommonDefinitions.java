package WebAutomation.AutomationPractice.definitions;

import java.io.IOException;
import java.util.Properties;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import WebAutomation.AutomationPractice.steps.CommonSteps;
import WebAutomation.AutomationPractice.utility.Common;
import WebAutomation.AutomationPractice.utility.Constants;

public class CommonDefinitions {
	@Steps
	CommonSteps commonSteps;

	static boolean firstScenario = true;
	static int scenariosExecuted = 0;
	public static Properties authenticationProps;
	public static Properties urlProps;
	public static Properties dataProps;
	public static String env = "test";
	public static String URL = "";

	@Before
	public void setup(Scenario scenario) throws InterruptedException, IOException {
		System.out.println("*******************************************************************************************");
		
		if (firstScenario) {
			
			firstScenario = false;
			if (System.getProperty("env") != null)
				env = System.getProperty("env");
			firstScenario = false;
			authenticationProps = Common
					.loadPropertiesFile(Constants.ENVIRONMENT_LOCATION + env + ".credentials.properties");
			urlProps = Common.loadPropertiesFile(Constants.ENVIRONMENT_LOCATION + env + ".url.properties");
			dataProps = Common.loadPropertiesFile(Constants.ENVIRONMENT_LOCATION + env + ".data.properties");
			URL = urlProps.getProperty("url");

		}

	}

	
	
	@Given("^user navigate to the shop page$")
	public void openTheHomePage() {
		commonSteps.openTheHomePage();
		commonSteps.verifyHomePageDisplayed();
	}
	
}
