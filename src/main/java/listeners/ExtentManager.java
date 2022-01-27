package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.Page;



public class ExtentManager {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static String fileName;
	

	public static ExtentReports getInstance(){
		
		if(extent==null) {
			
			extent = new ExtentReports();
			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html");
			try {
				htmlReporter.loadXMLConfig(new File (System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extent.attachReporter(htmlReporter);

		}
		return extent;
	}

	    
		public static void captureScreenshot() throws IOException {
			
			Date d = new Date();
			 fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

			
			
			File screeshot = ((TakesScreenshot)  Page.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screeshot, new File(".//reports//"+fileName));
		}
		
		

		public static void captureElementScreenshot(WebElement element) throws IOException {
			
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";

			
			
			File screeshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screeshot, new File(".//screenshot//"+"Element_"+fileName));
		}

	 


	}
