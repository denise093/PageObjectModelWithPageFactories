package testcases;

import java.io.IOException;
import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import base.Page;
import pages.actions.SignInPage;
import utilities.DataUtil;

public class SignInTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider ="dp")
	public  void signInTest(Hashtable<String,String> data) throws IOException, InterruptedException {
		if(data.get("runmode").equalsIgnoreCase("N")) {
			
			throw new SkipException("Skipping the test as the Runmode is set to No");
			
		} else {
			
		Page.initConfiguration();
		SignInPage signin = Page.topNav.goToSignIn();
		signin.doLogin(data.get("username"), data.get("password"));
		}
	}
	
	@AfterMethod
	public void teadDown() {
		if(Page.driver != null) {
			Page.quit();
		}

	}

}
