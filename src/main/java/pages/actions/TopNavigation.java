package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import base.Page;
import pages.locators.TopNavigationLocators;


public class TopNavigation {

	public TopNavigationLocators topNavigation;
	
	public TopNavigation(WebDriver driver) {
		this.topNavigation = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory,this.topNavigation);
	}
	
	public SignInPage goToSignIn() throws InterruptedException {
		Thread.sleep(3000);
		Page.click(topNavigation.signIn);
		Page.click(topNavigation.signInBtn);
		return new SignInPage();
		
	}
	
	public void goToCreateAccount() {
		
	}
	
	public void goToList() {
		
	}
	
	
	public void goToSupport() {
		
	}
	
	public void goToHome() {
		
	}
}
