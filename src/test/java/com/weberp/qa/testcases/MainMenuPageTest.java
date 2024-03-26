package com.weberp.qa.testcases;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.weberp.qa.base.TestBase;
import com.weberp.qa.pages.LoginPage;
import com.weberp.qa.pages.MainMenuPage;

public class MainMenuPageTest extends TestBase {

	LoginPage loginPage;
	MainMenuPage mainMenuPage;
	
	private List<String> expectedMenuItems = Arrays.asList(
            "• New Sales Order or Quotation",
            "• Enter Counter Sales",
            "• Enter Counter Returns",
            "• Generate/Print Picking Lists",
            "• Outstanding Sales Orders/Quotations",
            "• Special Order",
            "• Recurring Order Template",
            "• Process Recurring Orders",
            "• Maintain Picking Lists"
    );

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
		for (WebElement menuItem : menuItems) {
			String actualMenuItemText = menuItem.getText().trim();
			System.out.println("Actual Menu Item Text:" + actualMenuItemText);
		}

	}

	@Test
	public void verifyInquiriesReportItems() {
		List<WebElement> menuItems = mainMenuPage.getMenuItemsInquiriesReportTab();
		System.out.println("Size of elementList: " + menuItems.size());
		for (WebElement menuItem : menuItems) {
			String actualMenuItemText = menuItem.getText().trim();
			System.out.println("Actual Menu Item Text:" + actualMenuItemText);

		}

	}

	@Test
	public void verifyMaintenanaceItems() {
		List<WebElement> menuItems = mainMenuPage.getMenuItemsMaintenanceTab();
		System.out.println("Size of elementList: " + menuItems.size());
		for (WebElement menuItem : menuItems) {
			String actualMenuItemText = menuItem.getText().trim();
			System.out.println("Actual Menu Item Text:" + actualMenuItemText);
//			String expectedMenuItemText = "• Create Contract\r\n" + "• Select Contract\r\n"
//					+ "• Sell Through Support Deals";
//			Assert.assertEquals(actualMenuItemText, expectedMenuItemText, "Menu item text doesn't match expected.");

		}

	}

	@Test
	public void verifyMainmenuItems() {
		List<WebElement> menuItems = mainMenuPage.getMainMenuTab();
		System.out.println("Size of elementList: " + menuItems.size());
		for (WebElement menuItem : menuItems) {
			String actualMenuItemText = menuItem.getText().trim();
			System.out.println("Actual Menu Item Text:" + actualMenuItemText);

		}

	}
	
	@Test
    public void testMenuItems() {
        List<String> actualMenuItems = mainMenuPage.getAllMenuItems();

        // Assert if actual and expected menu items are the same
        Assert.assertEquals(actualMenuItems, expectedMenuItems,
                "Menu items do not match the expected list");
    }

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
