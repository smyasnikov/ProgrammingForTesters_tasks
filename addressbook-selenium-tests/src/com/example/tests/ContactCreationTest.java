package com.example.tests;


import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase{
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
		}
	
	@Test(dataProvider = "contactsFromFile")
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
