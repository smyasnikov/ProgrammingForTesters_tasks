package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().addNewPage();
		fillContactForm(contact, CREATION).submitContractCreation();
		manager.navigateTo().homePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
	    fillContactForm(contact, MODIFICATION);
	    submitContactModification();
		manager.navigateTo().homePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactModification(index);
		submitContactDeletion();
		manager.navigateTo().homePage();
		rebuildCache();
		return this;
		}
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts==null)
		{
			rebuildCache();
		}
		return cachedContacts;		
	}
	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
				
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		int i=2;
		for (WebElement checkbox : checkboxes) {
			
			
			WebElement celli2=driver.findElement(By.xpath("//tr["+i+"]/td[2]"));
			WebElement celli3=driver.findElement(By.xpath("//tr["+i+"]/td[3]"));
			WebElement celli4=driver.findElement(By.xpath("//tr["+i+"]/td[4]/a"));
			WebElement celli5=driver.findElement(By.xpath("//tr["+i+"]/td[5]"));
			
			String lastName=celli2.getText();
			String firstName=celli3.getText();
			String email=celli4.getText();
			String homePhone=celli5.getText();
			
			ContactData contact = new ContactData()
			.withLastName(lastName)
			.withFirstName(firstName)
			.withEmail(email)
			.withHomePhone(homePhone);
			i=i+1;
			
			cachedContacts.add(contact);
		}

	//----------------------------------------------------------------------------------------------

	
		
	}

	public ContactHelper submitContractCreation() {
		click(By.name("submit"));
		cachedContacts=null;
		return this;
	}

	private void submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts=null;
	}

	public ContactHelper initContactModification(int index) {
		click(By.xpath("//tr["+(index+2)+"]/td/input"));
		click(By.xpath("//tr["+(index+2)+"]/td/a/img[@alt='Edit']"));
		return this;
		}

	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts=null;
		return this;
		}
	
	public ContactHelper fillContactForm(ContactData contact, Boolean formType) {
		type("firstname", contact.getFirstName());
		type("lastname", contact.getLastName());
	    type("address", contact.getAddress());
	    type("home", contact.getHomePhone());
	    type("mobile", contact.getMobilePhone());
	    type("work", contact.getWorkPhone());
	    type("email", contact.getEmail());
	    type("email2", contact.getEmail2());
	    selectByText(By.name("bday"), contact.getbDay());
	    selectByText(By.name("bmonth"), contact.getbMonth());
	    type("byear", contact.getbYear());
	    if (formType == CREATION)
	    {
	    	selectByText(By.name("new_group"), contact.getGroup());
	    }
	    else
	    {
	    	if(driver.findElements(By.name("new group")).size()!=0)
	    	{
	    		throw new Error("It's possible to select group during modification");
	    	}
	    }
	    
	    type("address2", contact.getAddress2());
	    type("phone2", contact.getPhone2());
	    
	    return this;
		}

}
