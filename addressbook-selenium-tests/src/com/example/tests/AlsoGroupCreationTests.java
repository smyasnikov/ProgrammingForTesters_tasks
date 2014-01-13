package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase {
 
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    app.navigateTo().mainPage();
    app.navigateTo().groupPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData("group1","header1","footer1");
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    app.navigateTo().mainPage();
    app.navigateTo().groupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}

