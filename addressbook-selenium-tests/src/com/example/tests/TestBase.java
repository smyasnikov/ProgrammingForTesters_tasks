package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;
	
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
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<5; i++) {
			GroupData group = new GroupData();
			group.name=generateRandomString();
			group.header=generateRandomString();
			group.footer=generateRandomString();
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();	
		if (rnd.nextInt(3)==0) {
			return rnd.nextInt()/2+"AAA";
		}
		else {
			return "test"+rnd.nextInt();
		}		
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactsGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<3; i++) {
			ContactData contact = new ContactData();
			contact.firstName = generateRandomString();
			contact.lastName = generateRandomString();
			contact.address = generateRandomString();
			contact.homePhone = generateRandomNumber();
			contact.mobilePhone = generateRandomNumber();
			contact.workPhone = generateRandomNumber();
			contact.email = generateRandomString();
			contact.email2 = generateRandomString();
			contact.bDay = generateRandomDay();
			contact.bMonth = generateRandomMonth();
			contact.bYear = generateRandomYear();
			contact.group = "group1";
			contact.address2 = generateRandomString();
			contact.phone2 = generateRandomNumber();
					
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomNumber()
	{
		Random rnd = new Random();
		if (rnd.nextInt(3)==0) {
			return "000";
		}
		else {
			return ""+rnd.nextInt();
		}
		
	}
	
	public String generateRandomDay()
	{
		return ""+(int)(Math.random() * 29);
			
	}
	
	public String generateRandomYear()
	{
		return ""+(1950+(int)(Math.random() * 64));
			
	}
	
	public String generateRandomMonth()
	{
		Random rnd = new Random();
		if (rnd.nextInt(3)==0) 
		{
			return "January";
		}
		else 
		{
			if (rnd.nextInt(3)==1)
			{
				return "February";
			}
			else 
			{
				return "June";
			}
		}
			
	}
  
	
}
