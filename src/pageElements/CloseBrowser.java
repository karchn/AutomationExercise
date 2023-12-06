package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CloseBrowser {

	WebDriver driver;

	public CloseBrowser(WebDriver driverhere) {

		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	public void closebrowser() {
		driver.quit();
	}
}
