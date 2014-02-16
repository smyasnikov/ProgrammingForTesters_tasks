package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().addNewPage();
		fillContactForm(contact, CREATION).submitContractCreation();
		manager.navigateTo().homePage();
		//update model
	    manager.getModel().addContact(contact);
	    //rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
	    fillContactForm(contact, MODIFICATION);
	    submitContactModification();
		manager.navigateTo().homePage();
		//update model
		manager.getModel().removeContact(index).addContact(contact);
		//rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactModification(index);
		submitContactDeletion();
		manager.navigateTo().homePage();
		//update model
		manager.getModel().removeContact(index);
		//rebuildCache();
		return this;
		}
	
	public SortedListOf<ContactData> getUIContacts(Boolean formType) {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
				
		if (formType == CREATION)
		{
			List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
			int i=2;
			for (WebElement checkbox : checkboxes) 
			{
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
			
				contacts.add(contact);
			}	
		}
		else
		{
			List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
			int i=0;
			for (WebElement checkbox : checkboxes) 
			{
				initContactModification(i);
				ContactData contact = getContactDataFromEditForm();
				manager.navigateTo().homePage();
				i++;
				contacts.add(contact);
			}	
		}
	return contacts;
	}

	private ContactData getContactDataFromEditForm() {
		WebElement uiFitstName=driver.findElement(By.xpath("//input[2]"));
		WebElement uiLastName=driver.findElement(By.xpath("//input[3]"));
		WebElement uiAddress=driver.findElement(By.xpath("//textarea[1]"));
		WebElement uiHomePhone=driver.findElement(By.xpath("//input[4]"));
		WebElement uiMobilePhone=driver.findElement(By.xpath("//input[5]"));
		WebElement uiWorkPhone=driver.findElement(By.xpath("//input[6]"));
		WebElement uiEmail=driver.findElement(By.xpath("//input[7]"));
		WebElement uiEmail2=driver.findElement(By.xpath("//input[8]"));
		WebElement uiBDay=driver.findElement(By.xpath("//select[1]/option[1]"));
		WebElement uiBMonth=driver.findElement(By.xpath("//select[2]/option[1]"));
		WebElement uiBYear=driver.findElement(By.xpath("//input[9]"));
		WebElement uiAddress2=driver.findElement(By.xpath("//textarea[2]"));
		WebElement uiHomePhone2=driver.findElement(By.xpath("//input[10]"));
		
		String firstName=uiFitstName.getAttribute("value");
		String lastName=uiLastName.getAttribute("value");
		String address=uiAddress.getText();
		String homePhone=uiHomePhone.getAttribute("value");
		String mobilePhone=uiMobilePhone.getAttribute("value");
		String workPhone=uiWorkPhone.getAttribute("value");
		String email=uiEmail.getAttribute("value");
		String email2=uiEmail2.getAttribute("value");
		String bDay=uiBDay.getAttribute("value");
		String bMonth=uiBMonth.getAttribute("value");
		String bYear=uiBYear.getAttribute("value");
		String address2=uiAddress2.getText();
		String homePhone2=uiHomePhone2.getAttribute("value");
		

		ContactData contact = new ContactData()
		.withFirstName(firstName)
		.withLastName(lastName)
		.withAddress(address)
		.withHomePhone(homePhone)
		.withMobilePhone(mobilePhone)
		.withWorkPhone(workPhone)
		.withEmail(email)
		.withEmail2(email2)
		.withBDay(bDay)
		.withBMonth(bMonth)
		.withBYear(bYear)
		.withaddress2(address2)
		.withPhone2(homePhone2)
		;
		return contact;
	}

	
	/*private SortedListOf<ContactData> cachedContacts;
	
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
	
	}*/

	public ContactHelper submitContractCreation() {
		click(By.name("submit"));
		//cachedContacts=null;
		return this;
	}

	private void submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		//cachedContacts=null;
	}

	public ContactHelper initContactModification(int index) {
		click(By.xpath("//tr["+(index+2)+"]/td/input"));
		click(By.xpath("//tr["+(index+2)+"]/td/a/img[@alt='Edit']"));
		return this;
		}

	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		//cachedContacts=null;
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
	    {/*
	    	if(driver.findElements(By.name("new group")).size()!=0)
	    	{
	    		throw new Error("It's possible to select group during modification");
	    	}*/
	    }
	    
	    type("address2", contact.getAddress2());
	    type("phone2", contact.getPhone2());
	    
	    return this;
		}

}
