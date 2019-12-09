package WebAutomation.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebAutomation.AutomationPractice.definitions.CommonDefinitions;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RegistrationPage extends MasterPage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@id='submitAccount']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement titleMr;
	
	@FindBy(xpath = "//input[@id='customer_firstname']")
	private WebElement cusFirstName;
	
	@FindBy(xpath = "//input[@id='customer_lastname']")
	private WebElement cusLastName;
	
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement passwd;
	
	@FindBy(xpath = "//select[@id='days']")
	private WebElement dobDays;
	
	@FindBy(xpath = "//select[@id='months']")
	private WebElement dobMonths;
	
	@FindBy(xpath = "//select[@id='years']")
	private WebElement dobYears;
	
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement addressLine11;
	
	@FindBy(xpath = "//input[@id='city']")
	private WebElement addressCity;
	
	@FindBy(xpath = "//select[@id='id_state']")
	private WebElement addressState;
	
	@FindBy(xpath = "//input[@id='postcode']")
	private WebElement addressZipCode;
	
	@FindBy(xpath = "//select[@id='id_country']")
	private WebElement addressCountry;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement addressPhone;
	
	@FindBy(xpath = "//input[@id='phone_mobile']")
	private WebElement addressMobilePhone;
	
	@FindBy(xpath = "//input[@id='alias']")
	private WebElement addressAlias;
		
	public void waitUntilRegistrationFormLoaded() {
		WebDriverWait wait=new WebDriverWait(this.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(registerButton));
	}
	
	public void submitRegistrationDetails() {
		titleMr.click();
		type(cusFirstName, CommonDefinitions.dataProps.getProperty("firstName"));
		type(cusLastName, CommonDefinitions.dataProps.getProperty("lastName"));
		type(passwd, CommonDefinitions.dataProps.getProperty("password"));
		setDOB();
		setCountryState();
		type(firstName, CommonDefinitions.dataProps.getProperty("firstName"));
		type(lastName, CommonDefinitions.dataProps.getProperty("lastName"));
		type(addressLine11, CommonDefinitions.dataProps.getProperty("addressLine1"));
		type(addressCity, CommonDefinitions.dataProps.getProperty("city"));
		type(addressZipCode, CommonDefinitions.dataProps.getProperty("zipCode"));
		type(addressPhone, CommonDefinitions.dataProps.getProperty("phoneNumber"));
		type(addressMobilePhone, CommonDefinitions.dataProps.getProperty("phoneNumber"));
		type(addressAlias, CommonDefinitions.dataProps.getProperty("alias"));
		registerButton.click();
	}
	
	public void setCountryState() {
		Select drpCountry = new Select (addressCountry);
		drpCountry.selectByVisibleText(CommonDefinitions.dataProps.getProperty("country"));
		Select drpState = new Select (addressState);
		drpState.selectByVisibleText(CommonDefinitions.dataProps.getProperty("state"));
	}
	
	public void setDOB() {
		Select drpDays = new Select (dobDays);
		Select drpMonths = new Select (dobMonths);
		Select drpYears = new Select (dobYears);
		drpDays.selectByValue("10");
		drpMonths.selectByValue("5");
		drpYears.selectByValue("1984");
	}
	 
}
