package utilities;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageElements.LandingPage;

public class Basetest {

	
	public WebDriver driver;
	
	public WebDriver intializebrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream	fs = new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
	    	 driver= new ChromeDriver(); // intializing 
	     }
	     else if(browser.equalsIgnoreCase("firefox")) {
	    	 driver= new FirefoxDriver(); // intializing 
	     }
		
		return driver;
	}
	
	
	public LandingPage LaunchApplication() throws IOException {
		driver=intializebrowser();
		LandingPage lp = new LandingPage(driver);
		lp.GoTo();
		return lp;
	}
	
//	@AfterSuite
//	public void CloseBrowser() {
//		
//		driver.close();
//	}
}
