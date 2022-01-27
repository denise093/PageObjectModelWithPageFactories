package pages.actions;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import base.Page;
import pages.locators.HomePageLocators;


public class HomePage extends Page {
	
		public HomePageLocators home;
		
		public HomePage(){
			
			this.home = new HomePageLocators();
			
			AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
			PageFactory.initElements(factory,this.home);
		}
		
	
	public HomePage gotoFlights() { 
		
		click(home.flightTab);
		return this;
		
	}

	public void gotoHotels() {
	
	}

	public void gotoFlightAndHotels() {
	
	}

	public void booAFlight(String from, String to, String departing, String returning, String noOfAdults, String noOfChildren,String noOfInfants, String age1Children,String age2Children) throws InterruptedException {
	
	click(home.fromBtn);
	type(home.from,from);
	click(home.searchForFrom);
	
	click(home.toBtn);
	type(home.to,to);
	click(home.searchForTo);
	
	type(home.departing,departing);
	type(home.returning,returning);
	
	click(home.travelersNo);

	String adultCString = noOfAdults;
	String[] adultCountArray = adultCString.split("\\.");
	int adultCount = Integer.parseInt(adultCountArray[0]);
	
	String childCString = noOfChildren;
	String[] childCountArray = childCString.split("\\.");
	int childCount = Integer.parseInt(childCountArray[0]);
	 
	String infantCString = noOfInfants;
	String[] infantCountArray = infantCString.split("\\.");
	int infantCount = Integer.parseInt(infantCountArray[0]);
	
	if(adultCount > 0) {
		
	for(int i =0; i< (adultCount - 1); i++) {
		click(home.adultsPlus);
	}
	}
	
	if(childCount > 0) {
		
	for(int i =0; i< childCount; i++) {
		click(home.childrenPlus);
	}
	}


	
	if(infantCount > 0) {
		
	for(int i =0; i< infantCount; i++) {
		click(home.infantsPlus);
	}
	}
	type(home.childrenAge,age1Children);
	
	type(home.children2Age,age2Children);
	Thread.sleep(2000);
	click(home.doneBtn);
	Thread.sleep(2000);
	click(home.searchBtn);
	Thread.sleep(2000);
	}

	public int findTabCount() {
		return home.tabCount.size();
	}
}
