package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class MenuOptionsStepDefinition {
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();

	@When("^I hover over the (Collabiration|Sales|Marketing|Support|All) menu$")
	public void i_hover_over_the_Collabiration_menu(String menu) {
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
		case "Activities":
			BrowserUtils.hover(dashboardPage.activities);
			break;

		}
		// BrowserUtils.hover(dashboardPage.collaboration);
	}

	@Then("^following menu options should be visible for (Collabiration|Sales|Marketing|Support|All):$")
	public void following_menu_options_should_be_visible_for_collaboration(String menu, List<String> options) {

		// capture the list of webElements 
		List<WebElement> topMenuOptions = dashboardPage.topMenuOptions(menu);
		//// CHESK
		List<String> topMenuOptionsStrings = BrowserUtils.getElementsText(topMenuOptions);
		// compare with prepared list
		assertEquals(topMenuOptionsStrings.size(), options.size(), "Numbers of elements is not mutch");

		for (int i = 0; i < options.size(); i++) {
			assertEquals(topMenuOptionsStrings.get(i), options.get(i));
		}

	}
}
