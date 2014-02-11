package com.example.fw;

import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
	
	private Properties properties;
	private ContactHelper contactHelper;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;
			
	//private static ApplicationManager singleton;
	
	/*public static ApplicationManager getInstance()
	{
		if (singleton==null){
			singleton = new ApplicationManager();
			singleton.start();
		}
	}*/
	
	public void start(String command) throws IOException {
		getProcessHelper().startAppUnderTest(command);
	}
	
	public void stop() {
		getProcessHelper().stopAppUnderTest();
	}
	public ApplicationManager(Properties properties) throws IOException {
		this.properties = properties;
		String command = properties.getProperty("app.path");
		start(command);
	}
	
	
	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
	
	public AutoItHelper getAutoItHelper() {
		if (autoItHelper == null) {
			autoItHelper = new AutoItHelper(this);
		}
		return autoItHelper;
	}
	
	public ProcessHelper getProcessHelper() {
		if (processHelper == null) {
			processHelper = new ProcessHelper(this);
		}
		return processHelper;
	}
	/*public String getProperty(String key) {
		return properties.getProperty(key);
	}*/
}
