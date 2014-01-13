package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupPage();
		initGroupCreation();
	   	fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupPage();
	    rebuildCache();
	 return this;		
	}
	
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupPage();
		selectGroupByIndex(index);
		submitGroupDelition();
		returnToGroupPage();
		rebuildCache();
		return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupPage();
		rebuildCache();
		return this;		
	}
	
	private List<GroupData> cachedGroups;
	
	public List<GroupData> getGroups() {
		if (cachedGroups==null)
		{
			rebuildCache();
		}
		return cachedGroups;		
	}

private void rebuildCache() {
	cachedGroups = new ArrayList<GroupData>();
	
	manager.navigateTo().groupPage();
	List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
	for (WebElement checkbox : checkboxes) {
		String title=checkbox.getAttribute("title");
		String name=title.substring("Select (".length(), title.length()-")".length());
		cachedGroups.add(new GroupData().withName(name));
	}
		
	}

	//--------------------------------------------------------------------------------------------
	public GroupHelper initGroupCreation() {
		
		click(By.name("new"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups=null;
		return this;
		}

	public GroupHelper returnToGroupPage() {
		click(By.linkText("group page"));
		return this;
		}

	public GroupHelper fillGroupForm(GroupData group) {
		type("group_name", group.getName());
		type("group_header", group.getHeader());
		type("group_footer", group.getFooter());
		
		return this;
		}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
		return this;
		}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		
		return this;
		}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups=null;
		return this;
		}
	

	public void submitGroupDelition() {
		click(By.name("delete"));
		cachedGroups=null;
	}

}
