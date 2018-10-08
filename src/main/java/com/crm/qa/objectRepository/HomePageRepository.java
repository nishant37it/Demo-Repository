package com.crm.qa.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePageRepository extends TestBase {
	
	public final String loggedinUserNameXpath = "//*[contains(text(),'User: Nishant Chourasiya')]";
	public final String ContactslinkXpath ="//a[contains(text(),'Contacts')]";
	public final String DealslinkXpath = "//a[contains(text(),'Deals')]";
	public final String TaskslinkXpath = "//a[contains(text(),'Tasks')]";
	public final String newContactlinkXpath ="//a[contains(text(),'New Contact')]";
	
	@FindBy(xpath = loggedinUserNameXpath)
	public WebElement loggedinUserName;
	
	@FindBy(xpath = ContactslinkXpath)
	public WebElement Contactslink;
	
	@FindBy(xpath = DealslinkXpath)
	public WebElement Dealslink;
	
	@FindBy(xpath = newContactlinkXpath)
	public WebElement newContactlink;
	
	@FindBy(xpath = TaskslinkXpath)
	public WebElement Taskslink;
	
	public HomePageRepository(WebDriver driver) throws Exception
	{
		try{
		PageFactory.initElements(driver, this);
		}catch(Exception ex)
		{
			throw ex;
		}
	}
}