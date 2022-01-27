package pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

	@FindBy(css ="a[aria-controls='wizard-flight-pwa']")
	public WebElement flightTab;
	
	@FindBy(css ="button[aria-label='Leaving from']")
	public WebElement fromBtn;
	
	@FindBy(css ="#location-field-leg1-origin")
	public WebElement from;
	
	@FindBy(xpath ="(//*[contains(text(),'Search for')])[2]")
	public WebElement searchForFrom;
	
	@FindBy(xpath ="(//*[contains(text(),'Search for')])[3]")
	public WebElement searchForTo;
	
	
	@FindBy(css ="button[aria-label='Going to']")
	public WebElement toBtn;
	
	@FindBy(css ="#location-field-leg1-destination")
	public WebElement to;
	
	@FindBy(css ="#d1-btn")
	public WebElement departing;
	
	@FindBy(css ="#d2-btn")
	public WebElement returning;
	
	@FindBy(css ="#preferred-class-input-trigger")
	public WebElement classType;
	
	@FindBy(css ="button[data-testid='travelers-field']")
	public WebElement travelersNo;
	
	@FindBy(xpath ="//*[contains(@aria-labelledby,'uitk-step-increase-adults')]")
	public WebElement adultsPlus;
	
	@FindBy(xpath ="//*[contains(@aria-labelledby,'uitk-step-increase-children')]")
	public WebElement childrenPlus;
	
	@FindBy(css ="#child-age-input-0-0")
	public WebElement childrenAge;
	
	
	@FindBy(css ="#child-age-input-0-1")
	public WebElement children2Age;
	
	@FindBy(xpath ="//*[contains(@aria-labelledby,'uitk-step-increase-infants')]")
	public WebElement infantsPlus;
	
	@FindBy(css =".uitk-button.uitk-button-large.uitk-button-fullWidth.uitk-button-has-text.uitk-button-primary.uitk-button-floating-full-width")
	public WebElement doneBtn;
	
	@FindBy(xpath ="//button[@data-testid='submit-button']")
	public WebElement searchBtn;
	
	@FindBy(css =".uitk-tab-text")
	public List<WebElement> tabCount;
	
}
