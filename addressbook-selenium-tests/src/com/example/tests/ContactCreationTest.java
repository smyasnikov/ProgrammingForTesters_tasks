package com.example.tests;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase{
	
	
	@Test(dataProvider = "randomValidContactsGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	app.navigateTo().mainPage();
	
	// save old stage
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
	//actions
	app.getContactHelper().createContact(contact);
	
    
    // save new stage
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    //assertEquals(newList.size(), oldList.size()+1);
    
	assertThat(newList, equalTo(oldList.withAdded(contact)));
    
  }
}
