package com.weberp.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.weberp.qa.base.TestBase;

public class MainMenuPage extends TestBase {

	private static final String EXCEL_FILE_PATH = "C:\\Users\\Sam\\eclipse-workspace\\Weberpproject\\src"
			+ "\\main\\java\\com\\weberp\\qa\\testdata\\webERP.xlsx";

	// pagefactory OR

	@FindBy(xpath = "//b[contains(text(),'Transactions')]")
	WebElement transactions;

	@FindBy(xpath = "//b[contains(text(),'Inquiries and Reports')]")
	WebElement inquiriesreports;

	@FindBy(xpath = "//b[contains(text(),'Maintenance')]")
	WebElement maintenance;
	
	@FindBy(xpath = "/html/body/section/fieldset[1]/ul[1]/li")
	private List<WebElement> menuItems;
	

	
	//@FindBy(xpath = "//ul[@xpath='1']/li[@class='MenuItem']")
    

	// Initializing the Page Objects:
	public MainMenuPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public List<WebElement> getMenuItemsTranscationTab() {
		return driver.findElements(By.xpath("/html/body/section/fieldset[1]/ul[1]/li"));

	}

	public List<WebElement> getMenuItemsInquiriesReportTab() {
		return driver.findElements(By.xpath("/html/body/section/fieldset[2]/ul[1]/li"));
	}

	public List<WebElement> getMenuItemsMaintenanceTab() {
		return driver.findElements(By.xpath("/html/body/section/fieldset[3]/ul[1]/li"));
	}

	public List<WebElement> getMainMenuTab() {
		return driver.findElements(By.xpath("//body/nav[1]/ul[1]/li"));
	}
	
	public List<String> getAllMenuItems() {
        List<String> actualMenuItems = new ArrayList<>();
        for (WebElement menuItem : menuItems) {
            String menuItemText = menuItem.getText().trim();
            actualMenuItems.add(menuItemText);
            System.out.println("Menu Item: " + menuItemText);
        }
        return actualMenuItems;
    }
	
	

}
