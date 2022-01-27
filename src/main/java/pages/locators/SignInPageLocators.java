package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageLocators {
	
	@FindBy(css="#loginFormEmailInput")
	public WebElement email;
	
	@FindBy(css="#loginFormPasswordInput")
	public WebElement password;
	
	@FindBy(css="#loginFormSubmitButton")
	public WebElement submit;

}
