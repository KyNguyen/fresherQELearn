package testCases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.actions.Actions;
import com.base.Base;
import com.codoid.products.exception.FilloException;
import com.pageObjects.ProfilePage;
import com.pageObjects.LoginPage;
import com.utils.Utils;

public class Login extends Base {
	
	public WebDriver driver;
	public Actions actions;
	
	private Logger log = LogManager.getLogger(Login.class.getName());
	private HashMap<String, String> dataTC1;
	private HashMap<String, String> dataTC2;

	@BeforeTest
	public void initialize() throws IOException, FilloException {
		driver = initializeDriver();
		log.info("Driver is initialized.");
		dataTC1 = new Utils().getTestData("TC1");
		dataTC2 = new Utils().getTestData("TC2");
		actions = new Actions(driver);
	}

	@Test
	public void testLoginSuccessfully() {
		ProfilePage profilePage = new ProfilePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		actions.navigateTo(prop.getProperty("url"));
		actions.enterText(loginPage.getUsername(), dataTC1.get("Username"));
		actions.enterText(loginPage.getPassword(), dataTC1.get("Password"));
		actions.click(loginPage.getLoginBtn());
		Assert.assertTrue(profilePage.getUserNameLbl().getText().equals(dataTC1.get("Username")));
		log.info("Successfully Logged In");
		actions.click(profilePage.getLogOutBtn());
	}

	@Test
	public void testLoginWithInvalidPassword() {
		LoginPage loginPage = new LoginPage(driver);

		actions.navigateTo(prop.getProperty("url"));
		actions.enterText(loginPage.getUsername(), dataTC2.get("Username"));
		actions.enterText(loginPage.getPassword(), dataTC2.get("Password"));
		actions.click(loginPage.getLoginBtn());

		String expectedError = "Invalid username or password!";
		String actualError = loginPage.getErrorMessageTxt().getText();
		Assert.assertTrue(actualError.equals(expectedError));
		log.info("The error message '" + expectedError + "' is displayed");
	}

	@DataProvider
	public Object[][] getData() {
		// Each row is set of test data for a test case
		// Each column is a value in a set of test data
		Object[][] data = new Object[2][2];

		// First set of test data
		data[0][0] = "John Doe";
		data[0][1] = "ThisIsNotAPassword";

		// Second set of test data
		data[1][0] = "testuser2";
		data[1][1] = "testpwd2";

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}
}
