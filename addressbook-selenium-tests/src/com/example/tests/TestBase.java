package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {
	
	protected static ApplicationManager app;
	
	@BeforeClass
	public void setUp() throws Exception {
		app = new ApplicationManager();
		}
		
	@AfterClass
	public void tearDown() throws Exception {
		app.stop();
	   
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupsGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}
	
	private List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactsGenerator() {
		return wrapContactsForDataProvider(generateRandomContacts(1)).iterator();
		}

	private List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}
}
