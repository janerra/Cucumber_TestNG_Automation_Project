package com.app.pages;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MenuOptionsStepsDefs {
	//DashboardPage
	
	@When("^I hover over the Collaboration menu_s$")
	public void i_hover_over_the_Collaboration_menu_s() {
	  
	}

	@Then("^following menu_s options should be visible for Collaboration:$")
	public void following_menu_s_options_should_be_visible_for_Collaboration(DataTable arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc).
	    // Field names for YourType must match the column names in 
	    // your feature file (except for spaces and capitalization).
	    throw new PendingException();
	}
}
