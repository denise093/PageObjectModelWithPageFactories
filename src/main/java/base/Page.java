package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ExtentManager;
import pages.actions.TopNavigation;
import utilities.ExcelReader;


public class Page {
	
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(Page.class.getName());
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static TopNavigation topNav;
	
	public static void initConfiguration() {
		
		// loading the log file
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		if(Constants.browser.equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Launching Firefox");

		
		} else if(Constants.browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
			log.info("Launching Chrome");

	}else if(Constants.browser.equals("ie")){
		
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		log.info("Launching IE");

	}
		driver.get(Constants.testsiteurl);
		log.info("Navigated to : " + Constants.testsiteurl);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitWait));
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		topNav = new TopNavigation(driver);
	}
	
	
	public static void quit(){
		
		driver.quit();
		
	}
	


	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

		public static void click(WebElement element) {
			element.click();
			log.info("Clicking on Element: " + element);
//			test.log(Status.INFO, "Clicking on Element: " + element);
			
		}
		
		
		public static void type(WebElement element, String keysToSend) {
			element.sendKeys(keysToSend);
			log.info(keysToSend + "types on Element: " + element);
//			test.log(Status.INFO, keysToSend + "typed on Element: " + element);
			
		}


}
