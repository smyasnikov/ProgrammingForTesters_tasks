package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{
	
	@Test(dataProvider = "randomValidContactsGenerator")
	public void modifySomeContact(ContactData contact)
	{
		app.navigateTo().mainPage();
		
		// save old stage
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		
		//actions
	    app.getContactHelper().modifyContact(index, contact);
	    
		
		// save new stage
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
