package com.crm.qa.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPageRepository extends TestBase {
	
	public final String userNameXpath = "//input[@name='username']"; 
	public final String PasswordXpath ="//input[@name='password']";
	public final String LoginXpath = "//input[@value='Login']";
	public final String LogoXpath = "//a[@class='navbar-brand']/img";
	
	@FindBy(xpath = userNameXpath)
	public WebElement userName;
	
	@FindBy(xpath =PasswordXpath)
	public WebElement Password;
	
	@FindBy(xpath = LoginXpath)
	public WebElement Login;
	
	@FindBy(xpath = LogoXpath)
	public WebElement Logo;
	
	public LoginPageRepository(WebDriver driver) throws Exception
	{
		try{
		// All the variables will be initialize by driver.
		PageFactory.initElements(driver, this);
		}catch(Exception ex)
		{
			throw ex;
		}
	}
}
