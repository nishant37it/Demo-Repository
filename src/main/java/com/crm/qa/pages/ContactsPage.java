package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.crm.qa.base.TestBase;
import com.crm.qa.objectRepository.ContactsPageRepository;

public class ContactsPage extends TestBase {

	ContactsPageRepository ContactsPageRepo;

	public ContactsPage(WebDriver driver) throws Exception {
		// TODO Auto-generated constructor stub

		try {
			TestBase.driver = driver;
			ContactsPageRepo = new ContactsPageRepository(driver);

		} catch (Exception ex) {
			ex.getMessage();
			throw ex;
		}
	}

	public boolean verifyContactsLabel() throws Exception {

		Thread.sleep(2000);
		return ContactsPageRepo.ContactsText.isDisplayed();
	}
	
	public void createNewContact(String title, String fName, String lName, String companyName) throws Exception
	{
		//WebElement element = ContactsPageRepo.driver.findElement(By.xpath(ContactsPageRepo.newContactsTitleXpath));
		Select slt = new Select(ContactsPageRepo.newContactsTitle);
		Thread.sleep(2000);
		slt.selectByVisibleText(title);
		
		ContactsPageRepo.firstName.sendKeys(fName);
		ContactsPageRepo.lastName.sendKeys(lName);
		ContactsPageRepo.Company.sendKeys(companyName);
		ContactsPageRepo.SaveButton.click();
	}
}
