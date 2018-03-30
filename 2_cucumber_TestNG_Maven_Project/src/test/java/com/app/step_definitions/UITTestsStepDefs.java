package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMLoginPage;
import com.app.pages.SuiteCRMPersonPage;
import com.app.pages.SuiteCRMSearchResultsPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UITTestsStepDefs {
	
	private WebDriver driver = Driver.getDriver();
	SuiteCRMLoginPage loginPage = new SuiteCRMLoginPage();
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMSearchResultsPage searchResultsPage = new SuiteCRMSearchResultsPage();
	SuiteCRMPersonPage  personPage = new SuiteCRMPersonPage();
	
	@Given("^I logged into suiteCRM$")
	public void i_logged_into_suiteCRM() {
	   driver.get(ConfigurationReader.getProperty("url"));
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   loginPage.login(ConfigurationReader.getProperty("username"), 
			   			ConfigurationReader.getProperty("password"));
	}

	@Then("^CRM Name should be SuiteCRM$")
	public void crm_Name_should_be_SuiteCRM() {
		assertTrue(driver.getTitle().endsWith("SuiteCRM"));
	}

	@Then("^Modules should be displayed$")
	public void modules_should_be_displayed() {
		assertTrue(dashboardPage.sales.isDisplayed());
		assertTrue(dashboardPage.marketing.isDisplayed());
		assertTrue(dashboardPage.support.isDisplayed());
		assertTrue(dashboardPage.activities.isDisplayed());
		assertTrue(dashboardPage.collaboration.isDisplayed());
		assertTrue(dashboardPage.all.isDisplayed());
	}
	
	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchTerm) {
		try {
			assertTrue(dashboardPage.searchInput.isDisplayed());
			
		} catch (AssertionError e) {
			dashboardPage.searchButton.click();
		}
	    
		dashboardPage.searchInput.sendKeys(searchTerm+Keys.ENTER);
	}

	@Then("^link for user \"([^\"]*)\" should be displayed$")
	public void link_for_user_should_be_displayed(String searchTerm) {
	    assertTrue(searchResultsPage.resultLink(searchTerm).isDisplayed(), searchTerm+"does not displayed");
	}
	
	@Then("^there should be (\\d+) result for \"([^\"]*)\"$")
	public void there_should_be_result_for(int count, String searchTerm) {
		int actual = searchResultsPage.resultLinks(searchTerm).size();
		assertTrue((actual >= count), "number of results did not match" );
	}
	//----------------------
	@Then("^I open contact \"([^\"]*)\"$")
	public void i_open_contact(String searchTerm) {
		System.out.println("**---*"+searchTerm);
		
		searchResultsPage.resultLink(searchTerm).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("**---*"+personPage.getPersonName().toUpperCase());
	}

	@Then("^contact name should be \"([^\"]*)\"$")
	public void contact_name_should_be(String searchTerm) {
		assertTrue(personPage.getPersonName().toUpperCase().equals(searchTerm.toUpperCase()));
		System.out.println("***");
	}

	@Then("^contact email should be \"([^\"]*)\"$")
	public void contact_email_should_be(String ema) {
	    assertTrue(personPage.email.getText().equals(ema));
	}
	
	//------------------------
	@When("^duplicated contact \"([^\"]*)\" exists$")
	public void duplicated_contact_exists(String arg1) {
		personPage.importContacts.click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		personPage.chooseFile.sendKeys("src/test/resources/data/john-doe.vcf");
		
		personPage.importVcard.click();
		

	}

	@When("^remove duplicates for this contact$")
	public void remove_duplicates_for_this_contact() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^there should be only (\\d+) John Doe in the contacts page$")
	public void there_should_be_only_John_Doe_in_the_contacts_page(int arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	
	
	
		
	@Then("^I logout from the application$")
	public void i_logout_from_the_application() {
		dashboardPage.logout();
	}
	
}
