package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupsGenerator")
	public void modifySomeGroup(GroupData group)
	{
			    
	 // save old stage
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    
		app.getGroupHelper().modifyGroup(index, group);
		
		// save new stage
		SortedListOf<GroupData> newList = app.getModel().getGroups();
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
		
		//custom check
	    
	    if ("yes".equals(app.getProperty("check.db")))
	    {
	    	if (readyToCheck()) {
	    	assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
	    	}
	    }
	    
	    if ("yes".equals(app.getProperty("check.ui")))
	    {
	    	if (readyToCheck()) {
	    		assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUIGroups()));
	    	}
	    }
	    
	}

}
