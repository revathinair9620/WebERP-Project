package com.weberp.qa.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.weberp.qa.base.TestBase;
import com.weberp.qa.pages.LoginPage;
import com.weberp.qa.pages.MainMenuPage;

public class MainMenuPageTest extends TestBase {

	LoginPage loginPage;
	MainMenuPage mainMenuPage;

	public MainMenuPageTest() {
		super(); // call the test base class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		mainMenuPage = new MainMenuPage();
		mainMenuPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyTranscationMenuItems() {
		List<WebElement> menuItems = mainMenuPage.getMenuItemsTranscationTab();
		System.out.println("Size of elementList: " + menuItems.size());
		System.out.println("Menu Items:");
		for (WebElement menuItem : menuItems) {
			// System.out.println("Actual Menu Item Text: \n " + menuItem.getText());
			String actualMenuItemText = menuItem.getText().trim();
			System.out.println("Actual Menu Item Text: \n" + actualMenuItemText);
		}

	}
	@Test
	public void verifyInquiriesReportItems() {
		List<WebElement> menuItems = mainMenuPage.getMenuItemsInquiriesReportTab();
		System.out.println("Size of elementList: " + menuItems.size());
		System.out.println("Menu Items:");
		for (WebElement menuItem : menuItems) {
			// System.out.println("Actual Menu Item Text: \n " + menuItem.getText());
			String actualMenuItemText = menuItem.getText().trim();
			System.out.println("Actual Menu Item Text: \n" + actualMenuItemText);


		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
