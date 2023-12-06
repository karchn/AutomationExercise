package pageElements;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.AbstractMethods;
import utilities.LoginPage;

public class TC4_logoutuser extends AbstractMethods{

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	public TC4_logoutuser(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")
	WebElement login;

	@FindBy(xpath = "//*[contains(text(),'Login to your account')]")
	WebElement loginaccount;

	@FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")
	WebElement enteraccountinfo;

	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement title;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement days;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement months;
	
	@FindBy(xpath="//i[@class='fa fa-lock']/parent::a")
	WebElement logout;
	
	@FindBy(xpath="//*[contains(text(),' Logged in as ')]")
	WebElement loogedinas;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']/parent::a")
	WebElement deleteaccount;
	
	@FindBy(xpath = "//*[contains(text(),'Account Deleted!')]")
	WebElement accountdeletedinfo;
	
	@FindBy(xpath="//*[contains(text(),'Continue')]")
	WebElement Continuebutton;
	
	public void testcase4() throws IOException {
		implicitlywaitmethod();
	    
	    try {
	    	LoginPage lg = new LoginPage(driver);
	    	lg.logincorrectly();
		  
	    	 logout.click();
	    	 
	    	 try {
	    		 String url=driver.getCurrentUrl();
	 			System.out.println(url);

	 			Assert.assertEquals(url, "https://automationexercise.com/login");
	 		} catch (Exception e) {
	 			System.out.println("user is not in login page");
	 		}
		 
	    }
	    catch(Exception e) {
	    	
	    }
}
}
