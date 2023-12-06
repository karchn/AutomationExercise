package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.AbstractMethods;
import utilities.Registrationpage;

public class TC1_RegisterUser extends AbstractMethods{

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	public TC1_RegisterUser(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")
	WebElement enteraccountinfo;

	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement title;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement days;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement months;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement years;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement company;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement address;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement mobno;
	
	@FindBy(xpath="//button[text()='Create Account']")
	WebElement createaccount;
	
	@FindBy(xpath="//*[contains(text(),'Account Created!')]")
	WebElement accountcreatedmessage;
	
	@FindBy(xpath="//*[contains(text(),'Continue')]")
	WebElement Continuebutton;
	
	@FindBy(xpath="//*[contains(text(),' Logged in as ')]")
	WebElement loogedinas;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']/parent::a")
	WebElement deleteaccount;
	
	@FindBy(xpath = "//*[contains(text(),'Account Deleted!')]")
	WebElement accountdeletedinfo;
	
	public TC2_corretautentication testcase1() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    try {
	    try {
			Assert.assertEquals(enteraccountinfo.getText(), "ENTER ACCOUNT INFORMATION");
			}
			catch(Exception e) {
				System.out.println("ENTER ACCOUNT INFORMATION is not visible");
			}
	    
	    
	    title.click();
	    
	    Registrationpage rs = new Registrationpage(driver);
	    rs.registrationpage();
	 
	    
		try {
			Assert.assertEquals(accountcreatedmessage.getText(), "ACCOUNT CREATED!");
			}
			catch(Exception e) {
				System.out.println("Account Created! is not visible");
			}
	    
	    
	    Continuebutton.click();
	    
   
		
	    try {
			Assert.assertEquals(loogedinas.getText(), loogedinas.getText());
			}
			catch(Exception e) {
				System.out.println(" Logged in as  is not visible");
			}
		
	    deleteaccount.click();
	    
	    try {
			Assert.assertEquals(accountdeletedinfo.getText(), "ACCOUNT DELETED!");
			}
			catch(Exception e) {
				System.out.println("accountdeletedinfo is not visible");
			}
	    
	    Continuebutton.click();
	    }
	    catch(Exception e) {
	    	System.out.println("not able to register");
	    }
	    
	    TC2_corretautentication t2  = new TC2_corretautentication(driver);
	    return t2;
	}
}
