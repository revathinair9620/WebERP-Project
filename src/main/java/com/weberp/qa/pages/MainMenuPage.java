package com.weberp.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.weberp.qa.base.TestBase;

public class MainMenuPage extends TestBase {

	// pagefactory OR

	@FindBy(xpath = "//b[contains(text(),'Transactions')]")
	WebElement transactions;

	@FindBy(xpath = "//b[contains(text(),'Inquiries and Reports')]")
	WebElement inquiriesreports;

	@FindBy(xpath = "//b[contains(text(),'Maintenance')]")
	WebElement maintenance;
	

	// Initializing the Page Objects:
	public MainMenuPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public List<WebElement> getMenuItemsTranscationTab() {
        return driver.findElements(By.xpath("/html/body/section/fieldset[1]/ul")); 
    }
	
	public List<WebElement> getMenuItemsInquiriesReportTab() {
        return driver.findElements(By.xpath("/html/body/section/fieldset[2]/ul")); 
    }

}
