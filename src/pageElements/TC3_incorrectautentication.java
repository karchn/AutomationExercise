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
import utilities.Registrationpage;

public class TC3_incorrectautentication extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public TC3_incorrectautentication(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")
	WebElement login;

	@FindBy(xpath = "//*[contains(text(),'Login to your account')]")
	WebElement loginaccount;

	@FindBy(xpath = "//*[contains(text(),'Your email or password is incorrect!')]")
	WebElement errormsg;

	public TC4_logoutuser testcase3() throws IOException {
		//TC1_RegisterUser tc1 = new TC1_RegisterUser(driver);
		//tc1.testcase1();

		try {
			login.click();

			try {
				Assert.assertEquals(loginaccount.getText(), "Login to your account");
			} catch (Exception e) {
				System.out.println("Login to your account is not visible");
			}
			Registrationpage rs = new Registrationpage(driver);
			rs.login();

			try {
				Assert.assertEquals(errormsg.getText(), "Your email or password is incorrect!");
			} catch (Exception e) {
				System.out.println("errormsg is not visible");
			}

		} catch (Exception e) {

		}

		TC4_logoutuser t4 = new TC4_logoutuser(driver);
		return t4;
	}
}
