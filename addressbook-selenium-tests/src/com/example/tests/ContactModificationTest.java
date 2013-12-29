package com.example.tests;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{
	
	@Test
	public void modifySomeContact()
	{
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactModification(0);
		ContactData contact = new ContactData();
		contact.address="new address";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getNavigationHelper().returnToHomePage();
	}

}
