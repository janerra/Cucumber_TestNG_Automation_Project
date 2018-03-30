package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMSummaryPage extends SuiteCRMCreateTaskPage{
private WebDriver driver;
	
	public SuiteCRMSummaryPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//h2[@class='module-title-text']")
	public WebElement pageLabel;
	
	@FindBy(css="#date_start")
	public WebElement date_start_date;
	
	@FindBy(css="#date_due")
	public WebElement date_due_date;
	
	@FindBy(css="#description")
	public WebElement description;
	
}
