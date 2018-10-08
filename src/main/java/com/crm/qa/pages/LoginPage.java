package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;
import com.crm.qa.objectRepository.LoginPageRepository;

public class LoginPage extends TestBase {

	LoginPageRepository LoginPageRepo;
	
	public LoginPage(WebDriver driver) throws Exception {
		try {

			// Call TestBase class driver.
			TestBase.driver = driver;

			LoginPageRepo = new LoginPageRepository(driver);

		} catch (Exception ex) {
			ex.getMessage();
			throw ex;
		}
	}

	public String validateTitle() {
		// Validate title
		return driver.getTitle();
	}

	public void validateCRMImage() throws Exception {

		System.out.println(LoginPageRepo.Logo.isDisplayed());
	}

	public HomePage logIn(String un, String pass) throws Exception {
		LoginPageRepo.userName.sendKeys(un);
		LoginPageRepo.Password.sendKeys(pass);
		Thread.sleep(1000);
		LoginPageRepo.Login.click();
		
		return new HomePage(driver);
	}
}