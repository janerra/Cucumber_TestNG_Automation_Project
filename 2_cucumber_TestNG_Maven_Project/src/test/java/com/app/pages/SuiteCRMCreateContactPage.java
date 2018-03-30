package com.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class SuiteCRMCreateContactPage {
	private WebDriver driver;

	public SuiteCRMCreateContactPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	public WebElement firstName;

	@FindBy(id = "last_name")
	public WebElement lastName;

	@FindBy(id = "phone_work")
	public WebElement officePhoneNumber;

	@FindBy(id = "department")
	public WebElement department;
	
	@FindBy(xpath = "//div[@field='email1']")
	public WebElement email;

	@FindBy(id = "SAVE")
	public WebElement save;

	@FindBy(xpath = "(//input[@title='Save'])[1]")
	public WebElement saveSecondButton;

	@FindBy(id = "//input[title='Save']")
	public WebElement saveConformation;

	@FindBy(xpath = "//h2[.='Save Contact']")
	public WebElement saveContactLabel;

	@FindBy(id = "phone_mobile")
	public WebElement cellPhone;

	//--------------------------------
	public void saveNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(save);

		save.click();
		if (saveContactLabel.isDisplayed()) {
			saveSecondButton.click();
		}
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
