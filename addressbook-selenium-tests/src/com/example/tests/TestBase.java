package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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

}
