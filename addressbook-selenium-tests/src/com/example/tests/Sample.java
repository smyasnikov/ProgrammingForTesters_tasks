package com.example.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.example.fw.ApplicationManager;
//import com.example.fw.JdbcHelper;

public class Sample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		ApplicationManager app = new ApplicationManager(properties);
		System.out.println(app.getHibernateHelper().listGroups());
		//JdbcHelper jdbc = new JdbcHelper(/*app, */"jdbc:mysql://localhost/addressbook?user=root&password=");
		//System.out.println(jdbc.listGroups()); 
	}

}
