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

public class TC2_corretautentication extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public TC2_corretautentication(WebDriver driverhere) {
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

	@FindBy(xpath = "//select[@id='days']")
	WebElement days;

	@FindBy(xpath = "//select[@id='months']")
	WebElement months;

	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")
	WebElement logout;

	@FindBy(xpath = "//*[contains(text(),' Logged in as ')]")
	WebElement loogedinas;

	@FindBy(xpath = "//i[@class='fa fa-trash-o']/parent::a")
	WebElement deleteaccount;

	@FindBy(xpath = "//*[contains(text(),'Account Deleted!')]")
	WebElement accountdeletedinfo;

	@FindBy(xpath = "//*[contains(text(),'Continue')]")
	WebElement Continuebutton;

	public TC3_incorrectautentication testcase2() throws IOException {
		implicitlywaitmethod();

		try {
			LoginPage lg = new LoginPage(driver);
			lg.logincorrectly();

			deleteaccount.click();

			try {
				Assert.assertEquals(accountdeletedinfo.getText(), "ACCOUNT DELETED!");
			} catch (Exception e) {
				System.out.println("accountdeletedinfo is not visible");
			}

			Continuebutton.click();
		} catch (Exception e) {
			System.out.println("login with correct username and Password has encountered an exception");
		}

		TC3_incorrectautentication t3 = new TC3_incorrectautentication(driver);
		return t3;
	}
}
