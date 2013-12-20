package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase {
 
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    openGroupPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "group1";
    group.header = "header1";
    group.footer = "footer1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    openGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupPage();
  }

}

