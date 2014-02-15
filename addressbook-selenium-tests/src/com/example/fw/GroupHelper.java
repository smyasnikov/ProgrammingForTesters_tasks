package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupPage();
		initGroupCreation();
	   	fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupPage();
	    //update model
	    manager.getModel().addGroup(group);
	    //rebuildCache();
	 return this;		
	}
	
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupPage();
		selectGroupByIndex(index);
		submitGroupDelition();
		returnToGroupPage();
		//update model
		manager.getModel().removeGroup(index);
		//rebuildCache();
		return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupPage();
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupPage();
		//update model
		manager.getModel().removeGroup(index).addGroup(group);
		//rebuildCache();
		return this;		
	}
	
	public SortedListOf<GroupData> getUIGroups() {
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		
		manager.navigateTo().groupPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title=checkbox.getAttribute("title");
			String name=title.substring("Select (".length(), title.length()-")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}
	
	/*private SortedListOf<GroupData> cachedGroups;
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups==null)
		{
			rebuildCache();
		}
		return cachedGroups;		
	}

	private void rebuildCache() {
	cachedGroups = new SortedListOf<GroupData>();
	
	manager.navigateTo().groupPage();
	List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
	for (WebElement checkbox : checkboxes) {
		String title=checkbox.getAttribute("title");
		String name=title.substring("Select (".length(), title.length()-")".length());
		cachedGroups.add(new GroupData().withName(name));
	}
		
	}
*/
	//--------------------------------------------------------------------------------------------
	public GroupHelper initGroupCreation() {
		
		click(By.name("new"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		//cachedGroups=null;
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
		//cachedGroups=null;
		return this;
		}
	

	public void submitGroupDelition() {
		click(By.name("delete"));
		//cachedGroups=null;
	}

}
