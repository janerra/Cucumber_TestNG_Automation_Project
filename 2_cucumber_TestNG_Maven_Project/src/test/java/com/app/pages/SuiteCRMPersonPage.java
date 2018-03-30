package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMPersonPage {
	private WebDriver driver;

	public SuiteCRMPersonPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	public String getPersonName() {
		return driver.findElement(By.xpath("//h2[@class='module-title-text']")).getText();
	}

	@FindBy(xpath = "//a[@class='email-link']")
	public WebElement email;
	

	@FindBy(xpath="(//div[@class='actionmenulink'])[2]")
	public WebElement importContacts;
	
	@FindBy(xpath="//input[@id='vcard_file']")
	public WebElement chooseFile;
	
	@FindBy(xpath="(//input[@id='import_vcard_button']")
	public WebElement importVcard;
}
