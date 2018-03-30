package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuOptionsStepsDefs {
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	
	@When("^I hover over the (Collaboration|Sales|Marketing|Support|All) menu_s$")
	public void i_hover_over_the_Collaboration_menu_s(String menu) {
		switch (menu) {
		case "Sales":
			BrowserUtils.hover(dashboardPage.sales);
			break;
		case "Marketing":
			BrowserUtils.hover(dashboardPage.marketing);
			break;
		case "Support":
			BrowserUtils.hover(dashboardPage.support);
			break;
		case "Collaboration":
			BrowserUtils.hover(dashboardPage.collaboration);
			break;
		case "All":
			BrowserUtils.hover(dashboardPage.all);
			break;
		}
	}

	@Then("^following menu_s options should be visible for Collaboration:$")
	// options - what we set in feature file
	public void following_menu_s_options_should_be_visible_for_Collaboration(List<String> options) {
	    //capture lost of webelements
		List<WebElement> topMenuOption = dashboardPage.topMenuOptions ("Collaboration");
		//get their text in a list
		List<String> topMenuOptionsString  = BrowserUtils.getElementsText(topMenuOption);
		//compare the list with
		assertEquals(topMenuOptionsString.size(),options.size(), " Number of expected menu options did not match");
		
		for (int i = 0; i < options.size(); i++) {
			assertEquals(topMenuOptionsString.get(i), options.get(i));
		} 
  }
	
	@Then("^following menu_s options should be visible for Support:$")
	public void following_menu_s_options_should_be_visible_for_Support(List<String> options) {
		List<WebElement> topMenuOption = dashboardPage.topMenuOptions ("Support");
		List<String> topMenuOptionsString  = BrowserUtils.getElementsText(topMenuOption);
		assertEquals(topMenuOptionsString.size(),options.size(), " Number of expected menu options did not match");
		
		for (int i = 0; i < options.size(); i++) {
			assertEquals(topMenuOptionsString.get(i), options.get(i));
		} 
		
	}
	
}
