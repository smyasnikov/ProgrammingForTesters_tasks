package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup()
	{
	    // save old stage
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
		 
		// save new stage
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare states
	    //assertEquals(newList.size(), oldList.size()+1);
	    
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
