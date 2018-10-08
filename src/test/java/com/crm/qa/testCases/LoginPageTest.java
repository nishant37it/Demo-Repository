package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws Exception {
		initialization();

		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1,groups = { "functest", "checkintest" })
	public void loginPageTitleTest() {
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	@Test(priority = 2,groups = { "functest" })
	public void CRMImageTest() throws Exception {
		loginPage.validateCRMImage();
	}

	@Test(priority = 3,groups = { "functest" })
	public void logInTest() throws Exception {
		loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}

	// After executing each method window will close.
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
