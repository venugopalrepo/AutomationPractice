package WebAutomation.AutomationPractice.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.PageObject;

public class PageObjectEnhanced extends PageObject {
	public PageObjectEnhanced(WebDriver driver) {
		super(driver);
	}

	public void executeJavaScriptClick(WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", e);
	}

	public void type(WebElement e, String value) {
		e.clear();
		e.sendKeys(value);
	}

	public void maxScreen() {
		getDriver().manage().window().maximize();
	}

	public void clearIfTextExists(WebElement e) {
		String elementValue = e.getAttribute("value");

		if (elementValue.length() > 0) {

			for (int i = 0; i < elementValue.length(); i++) {
				e.sendKeys(Keys.BACK_SPACE);
			}

		}
	}

	public boolean isClicked(WebElement w) {
		boolean islinkClicked = false;

		try {
			w.click();
			islinkClicked = true;
		} catch (Exception e) {
		}

		return islinkClicked;
	}

	public void changeWindow() {
		for (String winHandle : getDriver().getWindowHandles()) {

			getDriver().switchTo().window(winHandle);

		}

	}

	public void scrollToBottom() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public void checkIfElementPresent(WebElement e) {

		Assert.assertNotNull("WebElement " + e + ", is not present", e.isDisplayed());

	}

	public void checkIfReadOnly(WebElement e) {

		Assert.assertNotNull("WebElement " + e + ", is not Read-Only", e.getAttribute("readonly"));

	}

	public void checkIfEditable(WebElement e) {
		String test = "abc";
		type(e, "abc");
		Assert.assertTrue("Failed, I cant edit that element", e.getAttribute("value").equalsIgnoreCase(test));

	}

	public boolean findIfElementExists(String option) {
		boolean elementFound = false;

		List<WebElement> myElement = getDriver().findElements(By.xpath(option));

		if (myElement.size() > 0) {

			elementFound = true;
		} else {
			elementFound = false;
		}

		return elementFound;

	}

}

