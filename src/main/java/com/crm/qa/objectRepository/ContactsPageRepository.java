package com.crm.qa.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class ContactsPageRepository extends TestBase {
	
	public final String ContactsTextXpath = "//td[contains(text(),'Contacts')]";
	public final String newContactsTitleXpath = "//select[@name = 'title']";
	public final String firstNameXpath = "//input[@name='first_name']";
	public final String lastNameXpath ="//input[@name='surname']";
	public final String CompanyXpath = "//input[@name='client_lookup']";
	public final String SaveButtonXpath = "//input[@value='Load From Company']/following::input[@type='submit' and @class='button']";
	
	@FindBy(xpath = ContactsTextXpath)
	public WebElement ContactsText;
	
	@FindBy(xpath = newContactsTitleXpath)
	public WebElement newContactsTitle;
	
	@FindBy(xpath=firstNameXpath)
	public WebElement firstName;
	
	@FindBy(xpath=lastNameXpath)
	public WebElement lastName;
	
	@FindBy(xpath=CompanyXpath)
	public WebElement Company;
	
	@FindBy(xpath = SaveButtonXpath)
	public WebElement SaveButton;
		
	// Constructor
	public ContactsPageRepository(WebDriver driver) throws Exception
	{
		try{
		PageFactory.initElements(driver, this);
		}catch(Exception ex)
		{
			ex.getMessage();
			throw ex;
		}
	}
}