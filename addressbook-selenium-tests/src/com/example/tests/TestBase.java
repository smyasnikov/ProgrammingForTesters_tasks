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
			return "";
		}
		else {
			return "test"+rnd.nextInt();
		}
		
	}
	
}
