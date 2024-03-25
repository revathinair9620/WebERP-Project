package com.weberp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.weberp.qa.base.TestBase;
import com.weberp.qa.pages.LoginPage;
import com.weberp.qa.pages.MainMenuPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	MainMenuPage mainMenuPage;
	
	public LoginPageTest() {
		super(); // call the test base class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "webERP Login screen");
	}
	
	@Test(priority = 3)
	public void loginTest() {
		mainMenuPage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
