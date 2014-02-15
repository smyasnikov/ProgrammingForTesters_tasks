package com.example.tests;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTest extends TestBase{
	
	@Test(dataProvider = "randomValidContactsGenerator")
	public void modifySomeContact(ContactData contact)
	{
		app.navigateTo().mainPage();
		
		// save old stage
		SortedListOf<ContactData> oldList = app.getContactHelper().getUIContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		
		//actions
	    app.getContactHelper().modifyContact(index, contact);
	    
		
		// save new stage
	    SortedListOf<ContactData> newList = app.getContactHelper().getUIContacts();
	    
	    // compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));

	}

}
