package WebAutomation.AutomationPractice.definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

import WebAutomation.AutomationPractice.steps.ProductSteps;

public class ProductDefinitions {
	
	@Steps
	ProductSteps productSteps;
	
	
	@When("^adds below product to cart$")
	public void addProduct(DataTable dt) {

		List<Map<String, String>> pList = dt.asMaps(String.class, String.class);
		String pName, pRef, pSize, pColour, pQnty;
		for(int i=0; i<pList.size(); i++) {
			
			pName = pList.get(i).get("ProductName");
			pRef = pList.get(i).get("ProductReference");
			pSize = pList.get(i).get("Size");
			pColour = pList.get(i).get("Colour");
			pQnty = pList.get(i).get("Quantity");
		
			productSteps.openProductPage(pName, pRef);
			productSteps.addProduct(pSize, pColour, pQnty);
			}
		
		
		
	}
}
