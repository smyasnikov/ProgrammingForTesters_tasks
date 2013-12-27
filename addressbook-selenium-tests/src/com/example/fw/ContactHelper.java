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
	    type("address2", parameterObject.address2);
	    type("phone2", parameterObject.phone2);
	    
	}

	public void initContactModification(int index) {
		click(By.xpath("//tr["+index+"]/td/input"));
		click(By.xpath("//tr["+index+"]/td/a/img[@alt='Edit']"));
	}

	public void deleteContact(int index) {
		initContactModification(index);
		click(By.xpath("//input[@value='Delete']"));
		
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		
	}

}
