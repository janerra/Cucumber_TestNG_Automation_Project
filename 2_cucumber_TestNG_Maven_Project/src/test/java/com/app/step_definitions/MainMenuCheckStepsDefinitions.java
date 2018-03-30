package com.app.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainMenuCheckStepsDefinitions {
	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();

	@When("^I hover the (Sales|Marketing|Support|Activities|Collabiration|All) menu$")
	public void i_hover_the_Collabiration_menu(String menu) {
		// BrowserUtils.hover(dashboardPage.support);
		//
		// List<WebElement> supportList = dashboardPage.supportOptions();
		// for (WebElement we : supportList) {
		// System.out.println(("***")+we.getText());

		switch (menu) {
		case ("Sales"):
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
	}

	@Then("^following menu options should be visible for (Sales|Marketing|Support|Activities|Collabiration|All):$")
	public void following_menu_options_should_be_visible(String menu, List<String> options) {
		// capture list of webelements
		List<WebElement> topMenuOptions = dashboardPage.topMenuOptions(menu);
		// get their text in a list
		List<String> topMenuOptionsString = BrowserUtils.getElements(topMenuOptions);
		//compare the list with options
		assertEquals(topMenuOptionsString.size(), options.size(), "Number of expected menu options did not match");
		System.out.println("***"+ topMenuOptionsString.size()+"***"+options.size());
		for (int j = 0; j < options.size(); j++) {
			assertEquals(topMenuOptionsString.get(j), options.get(j));
			System.out.println(topMenuOptionsString.get(j)+"---"+options.get(j));
		}
		
	}
}
