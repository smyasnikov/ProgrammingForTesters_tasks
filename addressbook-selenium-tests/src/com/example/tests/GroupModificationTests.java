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
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    // actions
	    
		app.getGroupHelper().modifyGroup(index, group);
		
		// save new stage
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	    
	}

}
