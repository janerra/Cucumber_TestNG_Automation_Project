package com.app.step_definitions;

import java.util.List;

import com.app.beans.ContactBean;
import com.app.pages.SuiteCRMContactInformationPage;
import com.app.pages.SuiteCRMCreateContactPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class CreateContactsBeansStepDefinition {
	
	SuiteCRMDashboardPage dashboard = new SuiteCRMDashboardPage();
	SuiteCRMCreateContactPage createContact = new SuiteCRMCreateContactPage();
	SuiteCRMContactInformationPage contactInfo = new SuiteCRMContactInformationPage();
	
	@When("^I save a new contact with been class:$")
	public void i_save_a_new_contact_with_been_class(List<ContactBean> contacts) {
		 System.out.println("***************"+contacts.size());
		 ContactBean contactBean = contacts.get(0);
		    
		    BrowserUtils.hover(dashboard.createLink);
		    dashboard.createContact.click();
		    
		    createContact.firstName.sendKeys(contactBean.getFirstName());
		    createContact.lastName.sendKeys(contactBean.getLastName());
		    createContact.officePhoneNumber.sendKeys(contactBean.getOfficePhone());
		    createContact.cellPhone.sendKeys(contactBean.getCellPhone());
		    createContact.department.sendKeys(contactBean.getDepartment());
		    createContact.email.sendKeys(contactBean.getEmail());
		    
		    BrowserUtils.waitFor(3);
			//save
			createContact.saveNewContact();
	}
}
