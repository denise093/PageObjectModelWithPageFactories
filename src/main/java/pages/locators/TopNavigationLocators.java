package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {
	
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	public WebElement signIn;
	
	@FindBy(css="a[data-stid='link-header-account-signin']")
	public WebElement signInBtn;

}
