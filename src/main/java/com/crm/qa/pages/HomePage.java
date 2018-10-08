package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;
import com.crm.qa.objectRepository.HomePageRepository;

public class HomePage extends TestBase {

	HomePageRepository HomePageRepo;

	public HomePage(WebDriver driver) throws Exception {
		try {
			TestBase.driver = driver;
			HomePageRepo = new HomePageRepository(driver);
		} catch (Exception ex) {
			ex.getMessage();
			throw ex;
		}
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLoggedinUserNameTitle()
	{
		return HomePageRepo.loggedinUserName.isDisplayed();
	}

	// Q. What clickOnContacts() method is returning?
	// clickOnContacts() method is returning contactsPage() object.
	// Because after clicking on ContactsLink, ContactsPage will open.
	public ContactsPage clickOnContatactsLink() throws Exception {
		HomePageRepo.Contactslink.click();
		return new ContactsPage(driver);
	}

	public DealsPage clickOnDealsLink() {
		HomePageRepo.Dealslink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTaskLink() {
		HomePageRepo.Taskslink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions act =new Actions(driver);
		act.moveToElement(HomePageRepo.Contactslink).build().perform();
		HomePageRepo.newContactlink.click();
	}
}
