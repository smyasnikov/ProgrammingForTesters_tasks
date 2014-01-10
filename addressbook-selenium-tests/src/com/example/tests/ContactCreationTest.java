package com.example.tests;


import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{
	
	
	@Test(dataProvider = "randomValidContactsGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old stage
	List<ContactData> oldList = app.getContactHelper().getContacts();
		
	//actions
	app.getNavigationHelper().openAddNewPage();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContractCreation();
    app.getNavigationHelper().returnToHomePage();
    
    // save new stage
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    //assertEquals(newList.size(), oldList.size()+1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
}
