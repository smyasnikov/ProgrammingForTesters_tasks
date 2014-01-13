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
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			
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
		for (int i=0; i<1; i++) {
			ContactData contact = new ContactData()
			.withFirstName(generateRandomString())
			.withLastName(generateRandomString())
			.withAddress(generateRandomString())
			.withHomePhone(generateRandomNumber())
			.withMobilePhone(generateRandomNumber())
			.withWorkPhone(generateRandomNumber())
			.withEmail(generateRandomString())
			.withEmail2(generateRandomString())
			.withBDay(generateRandomDay())
			.withBMonth(generateRandomMonth())
			.withBYear(generateRandomYear())
			.withGroup(selectRandomGroup())
			.withaddress2(generateRandomString())
			.withPhone2(generateRandomNumber());
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
	
	public String selectRandomGroup()
	{
		Random rnd = new Random();
		int index=rnd.nextInt(35);
		app.navigateTo().mainPage();
		app.navigateTo().groupPage();
		return app.getGroupHelper().getGroups().get(index).getName();
			
	}
  
	
}
