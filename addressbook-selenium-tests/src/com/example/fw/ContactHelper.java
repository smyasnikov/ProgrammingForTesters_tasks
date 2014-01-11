package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		click(By.xpath("//tr["+(index+2)+"]/td/input"));
		click(By.xpath("//tr["+(index+2)+"]/td/a/img[@alt='Edit']"));
	}

	public void deleteContact(int index) {
		initContactModification(index);
		click(By.xpath("//input[@value='Delete']"));
		
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		
	}
	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		
		
		 List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		/*
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String accept=checkbox.getAttribute("accept");
			if (accept.length() != 0)
			{
				if(accept.indexOf(';', 0) != -1)
				{
			contact.email =accept.substring(0, accept.indexOf(';', 0));
			contact.email2 =accept.substring(contact.email.length()+1);
				}
				else
				{
					contact.email=accept;
					contact.email2="";
				}
					
			}
			else
			{
				contact.email="";
				contact.email2="";
			}
			String title=checkbox.getAttribute("title");
			if (title.length() > 10)
			{
				if(title.indexOf(' ', 0) != -1)
				{
			contact.firstName=title.substring("Select (".length(), title.indexOf(' ', "Select (".length()));		
			contact.lastName=title.substring(title.indexOf(' ', "Select (".length())+1, title.length()-")".length());
				}
				else
				{
					contact.firstName=title.substring("Select (".length(), title.indexOf(' ', "Select (".length()));
					contact.lastName="";
				}
			}
			else
			{
				contact.firstName="";
				contact.lastName="";
			}
			
			contacts.add(contact);
		}
		*/
		int i=2;
		for (WebElement checkbox : checkboxes) {
			
			ContactData contact = new ContactData();
			WebElement celli2=driver.findElement(By.xpath("//tr["+i+"]/td[2]"));
			WebElement celli3=driver.findElement(By.xpath("//tr["+i+"]/td[3]"));
			WebElement celli4=driver.findElement(By.xpath("//tr["+i+"]/td[4]/a"));
			WebElement celli5=driver.findElement(By.xpath("//tr["+i+"]/td[5]"));
			
			contact.lastName=celli2.getText();
			contact.firstName=celli3.getText();
			contact.email=celli4.getText();
			contact.homePhone=celli5.getText();
			i=i+1;
			
			contacts.add(contact);
		}
		
	
		return contacts;
	}

}
