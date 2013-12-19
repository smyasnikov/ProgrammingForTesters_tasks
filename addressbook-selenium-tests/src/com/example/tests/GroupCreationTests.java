package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    openPage("groups");
    initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "group1";
    group.header = "header1";
    group.footer = "footer1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToPage("group page");
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    openPage("groups");
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToPage("group page");
  }

}

