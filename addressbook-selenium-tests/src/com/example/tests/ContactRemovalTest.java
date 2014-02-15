package com.example.tests;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTest extends TestBase{
	
	@Test
	public void deleteSomeContact()
	{
		app.navigateTo().mainPage();
		
		// save old stage
		SortedListOf<ContactData> oldList = app.getContactHelper().getUIContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		
		//actions
	    app.getContactHelper().deleteContact(index);
		
		
		// save new stage
	    SortedListOf<ContactData> newList = app.getContactHelper().getUIContacts();
	    
	    // compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	}

}
