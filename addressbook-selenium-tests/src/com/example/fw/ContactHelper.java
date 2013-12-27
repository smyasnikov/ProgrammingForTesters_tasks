package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		}

	public void submitContractCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData parameterObject) {
		type("firstname", parameterObject.firstName);
		type("lastname", parameterObject.lastName);
	    type("address", parameterObject.address);
	    type("home", parameterObject.homePhone);
	    type("mobile", parameterObject.mobilePhone);
	    type("work", parameterObject.workPhone);
	    type("email", parameterObject.email);
	    type("email2", parameterObject.email2);
	    selectByText(By.name("bday"), parameterObject.bDay);
	    selectByText(By.name("bmonth"), parameterObject.bMonth);
	    type("byear", parameterObject.bYear);
	    //selectByText(By.name("new_group"), parameterObject.group);
	    type("address2", parameterObject.address2);
	    type("phone2", parameterObject.phone2);
	    
	}

	

}
