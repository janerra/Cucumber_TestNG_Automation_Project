package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateTaskPage {

private WebDriver driver;
	
	public SuiteCRMCreateTaskPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(id="name")
	public WebElement subject;
	
	public WebElement status;
	
	public WebElement date_start_date;
	
	public WebElement date_due_date;
	
	@FindBy(id="priority")
	public WebElement priorityEl;
	
	@FindBy(xpath="//textarea[@name='description']")
	public WebElement description;
	
	@FindBy (xpath="(//input[@id='SAVE'])[2]")
	public WebElement save;
}
