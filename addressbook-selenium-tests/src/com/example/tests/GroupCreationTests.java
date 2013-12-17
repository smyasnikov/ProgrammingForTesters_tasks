package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    openGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "group1";
    group.header = "header1";
    group.footer = "footer1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    openGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}

