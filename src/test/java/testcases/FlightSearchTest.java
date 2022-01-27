package testcases;



import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.Page;
import errorcollectors.ErrorCollector;
import pages.actions.HomePage;
import utilities.DataUtil;

public class FlightSearchTest {
	
	
		@BeforeTest
			public void setUp() {
			Page.initConfiguration();
		}
	
		@Test(dataProviderClass = DataUtil.class, dataProvider ="dp")
		public void flightSearchTest(Hashtable<String,String> data) throws InterruptedException {

			if(data.get("runmode").equalsIgnoreCase("N")) {
				
				throw new SkipException("Skipping the test as the Runmode is set to No");
				
			} else {
				
			HomePage home = new HomePage();
			ErrorCollector.verifyEquals(home.findTabCount(), 6);
			home.gotoFlights().booAFlight(data.get("from"), data.get("to"), data.get("departing"), data.get("returning"), data.get("noOfAdults"), data.get("noOfChildren"), data.get("noOfInfants"), data.get("age1Children"), data.get("age2Children"));
			}
			}
		
		@AfterTest
		public void teadDown() {
			Page.quit();
		}
		
}
