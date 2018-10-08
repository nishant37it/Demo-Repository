package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();

		loginPage = new LoginPage(driver);
		testUtil = new TestUtil(driver);
		contactsPage = new ContactsPage(driver);
		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContatactsLink();
	}

	@Test(priority = 1, enabled = false)
	public void verifyContactsLabelTest() throws Exception
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on comtacts page.");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void verifyCreateNewContactsTest(String title, String firstname, String lastname, String company) throws Exception
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstname, lastname, company);
		
	}

	// After executing each method window will close.
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
