package com.app.step_definitions;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.app.pages.SuiteCRMCreateTaskPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.pages.SuiteCRMSummaryPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreatingTasksStepDefs {

	SuiteCRMDashboardPage dashboardPage = new SuiteCRMDashboardPage();
	SuiteCRMCreateTaskPage createTaskPage = new SuiteCRMCreateTaskPage();
	SuiteCRMSummaryPage summaryPage = new SuiteCRMSummaryPage();
	Map<String, String> createTaskMap = new HashMap<>();
	Map<String, String> overviewTaskMap = new HashMap<>();
	
	String subject;

	@When("^I click on create Task$")
	public void i_click_on_create_Task() {
		dashboardPage.clickCreateTask();
	}

	@And("^Set subject as \"([^\"]*)\"$")
	public void set_subject_as(String taskSubject) {
		createTaskPage.subject.sendKeys(taskSubject);
		subject = taskSubject;
		createTaskMap.put("Subject", taskSubject.toUpperCase());
		

	}

	@When("^Set Status as \"([^\"]*)\"$")
	public void set_Status_as(String statusStr) {
		Select statusSelect = new Select(createTaskPage.status);
		statusSelect.selectByVisibleText(statusStr);
		createTaskMap.put("Status",statusStr);
	}

	@When("^Set start date is todays date$")
	public void set_start_date_is_todays_date() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String todaysDate = today.format(formatter);
		System.out.println(todaysDate);
		createTaskPage.date_start_date.sendKeys(todaysDate + Keys.TAB);
		createTaskMap.put("StartDay", todaysDate);
	}

	@When("^Due date is (\\d+) days after todays date$")
	public void due_date_is_days_after_todays_date(int daysAhead) {
		LocalDate today = LocalDate.now();
		LocalDate dueDay = today.plusDays(daysAhead);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String dueDate = dueDay.format(formatter);
		System.out.println(dueDate);
		createTaskPage.date_due_date.sendKeys(dueDate + Keys.TAB);
		createTaskMap.put("DueDay",dueDate);
		// System.out.println
	}

	@When("^Set \"([^\"]*)\" priority$")
	public void set_priority(String levelPriority) {
		Select priority = new Select(createTaskPage.priorityEl);
		priority.selectByVisibleText(levelPriority);
		createTaskMap.put("Priority", levelPriority);
	}

	@When("^Set description as \"([^\"]*)\"$")
	public void set_description_as(String descriptionText) {
		createTaskPage.description.sendKeys(descriptionText);
		createTaskMap.put("Description", descriptionText);
	}

	@When("^Save the task$")
	public void save_the_task() {
		createTaskPage.save.click();
	}

	@Then("^Task details page should be displayed$")
	public void task_details_page_should_be_displayed() {
		
		
		System.out.println("***"+summaryPage.pageLabel.getText());
		System.out.println("***"+subject);
		assertTrue(summaryPage.pageLabel.getText().equalsIgnoreCase(subject));
		
		System.out.println("-before---"+createTaskMap.toString());
		
		overviewTaskMap.put("Subject", summaryPage.pageLabel.getText());
		overviewTaskMap.put("Status", summaryPage.status.getText());
		overviewTaskMap.put("StartDay", summaryPage.date_start_date.getText().replace(" 12:00am", ""));
		overviewTaskMap.put("DueDay", summaryPage.date_due_date.getText().replace(" 12:00am", ""));
		overviewTaskMap.put("Priority", summaryPage.priorityEl.getText());
		overviewTaskMap.put("Description", summaryPage.description.getText());
		
		
		System.out.println("-after---"+overviewTaskMap.toString());
	}

	@Then("^Data should match with created task data$")
	public void data_should_match_with_created_task_data() {
		assertEquals(overviewTaskMap, createTaskMap);
	}
}
