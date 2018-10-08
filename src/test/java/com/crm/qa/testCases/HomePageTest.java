package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();

		loginPage = new LoginPage(driver);
		testUtil = new TestUtil(driver);
		contactsPage = new ContactsPage(driver);
		homePage =loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();		
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page title is not matched.");
	}
	
	@Test(priority = 2)
	public void verifyLoggedinUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyLoggedinUserNameTitle());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() throws Exception
	{
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContatactsLink();
		
	}

	// After executing each method window will close.
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
