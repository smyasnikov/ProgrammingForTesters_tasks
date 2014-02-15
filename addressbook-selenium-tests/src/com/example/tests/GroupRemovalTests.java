package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup()
	{
	    // save old stage
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUIGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
		 
		// save new stage
		SortedListOf<GroupData> newList = app.getGroupHelper().getUIGroups();
	    
	    // compare states
	    
	    assertThat(newList, equalTo(oldList.without(index)));
	}

}
