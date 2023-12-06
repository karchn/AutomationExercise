package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public LoginPage(WebDriver driverhere) {
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

	public void logincorrectly() {
		try {
			login.click();

			Registrationpage rs = new Registrationpage(driver);
			rs.signup();
			rs.registrationpage();

			login.click();
			logout.click();

			try {
				Assert.assertEquals(loginaccount.getText(), "Login to your account");
			} catch (Exception e) {
				System.out.println("Login to your account is not visible");
			}
			rs.login();

			try {
				Assert.assertEquals(loogedinas.getText(), loogedinas.getText());
			} catch (Exception e) {
				System.out.println(" Logged in as  is not visible");
			}
		} catch (Exception e) {
			System.out.println("In the exception blockwhile looging with correct crendials");
		}
	}
}
