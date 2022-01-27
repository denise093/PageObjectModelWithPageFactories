package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import base.Page;
import pages.locators.SignInPageLocators;


public class SignInPage extends Page {
	
	public SignInPageLocators signinPage;
	
	public SignInPage(){
		
		this.signinPage = new SignInPageLocators();
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory,this.signinPage);
	}
	
	public void doLogin(String username, String password) {
		type(signinPage.email,username);
		type(signinPage.password,password);
		click(signinPage.submit);
	}

}
