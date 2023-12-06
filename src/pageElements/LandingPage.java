package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.AbstractMethods;
import utilities.Registrationpage;

public class LandingPage extends AbstractMethods {

	WebDriver driver;

	public LandingPage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	public void GoTo() throws IOException {
		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")
	WebElement login;

	@FindBy(xpath = "//*[contains(text(),'New User Signup!')]")
	WebElement newusersignup;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement name;

	@FindBy(xpath = "(//input[@placeholder='Email Address'])[2]")
	WebElement emailaddress;

	@FindBy(xpath = "//button[text()='Signup']")
	WebElement signup;

	public TC1_RegisterUser usersignup() throws IOException {
		implicitlywaitmethod();

		try {
			String title = driver.getTitle();
			System.out.println(title);

			Assert.assertEquals(title, "Automation Exercise");
		} catch (Exception e) {
			System.out.println("title is not matching");
		}

		login.click();

		try {
			Assert.assertEquals(newusersignup.getText(), "New User Signup!");
		} catch (Exception e) {
			System.out.println("new user sign up is not visible");
		}

		Registrationpage rs = new Registrationpage(driver);
		rs.signup();

		TC1_RegisterUser ru = new TC1_RegisterUser(driver);
		return ru;
	}

}
