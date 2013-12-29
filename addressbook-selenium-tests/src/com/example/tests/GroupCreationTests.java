package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupsGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().openGroupPage();
    
    // save old stage
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().initGroupCreation();
   	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    
    // save new stage
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare states
    //assertEquals(newList.size(), oldList.size()+1);
    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

}

