package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase{
	
	@Test
	public void deleteSomeContact()
	{
		app.getNavigationHelper().openMainPage();
		
		// save old stage
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		
		//actions
	    app.getContactHelper().deleteContact(index);
		app.getNavigationHelper().returnToHomePage();
		
		// save new stage
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
