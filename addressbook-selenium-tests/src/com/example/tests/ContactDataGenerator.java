package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.fw.ApplicationManager;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {
	
	static protected ApplicationManager app;

	public static void main(String[] args) throws IOException {
		if (args.length<3)
		{
		System.out.println("Please specify parameters: <amount of test data> <file> <format>");
		return;
		}
		
		int amount =Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists())
		{
		System.out.println("File exists, please remove it manualy:"+file);
		return;	
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format))
		{
			saveContactsToCsvFile(contacts, file);
		}
		else
		{
			if ("xml".equals(format))
			{
				saveContactsToXmlFile(contacts, file);
			}
			else
			{
				System.out.println("Unknown format"+format);
				return;
			}
		}
 	}

	public static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName()+ "," + contact.getLastName() + "," + contact.getAddress() + "," 
					+ contact.getHomePhone() + "," + contact.getMobilePhone() + "," + contact.getWorkPhone() + "," + contact.getEmail()
					 + "," + contact.getEmail2() + "," + contact.getbDay() + "," + contact.getbMonth() + "," + contact.getbYear() + "," + 
					contact.getGroup()+ "," +contact.getAddress2()+ "," +contact.getPhone2()+ ",!"
					+ "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader=new BufferedReader(reader);
		String line=bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName(part[0])
			.withLastName(part[1])
			.withAddress(part[2])
			.withHomePhone(part[3])
			.withMobilePhone(part[4])
			.withWorkPhone(part[5])
			.withEmail(part[6])
			.withEmail2(part[7])
			.withBDay(part[8])
			.withBMonth(part[9])
			.withBYear(part[10])
			.withGroup(part[11])
			.withaddress2(part[12])
			.withPhone2(part[13]);
			list.add(contact);
			line=bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i=0; i<amount; i++) {
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
			list.add(contact);
		}
		return list;
	}
	
		public static String generateRandomString() {
		Random rnd = new Random();	
		if (rnd.nextInt(3)==0) {
			return rnd.nextInt()/2+"AAA";
		}
		else {
			return "test"+rnd.nextInt();
			}	
		}
		
		public static String generateRandomNumber()
		{
			Random rnd = new Random();
			if (rnd.nextInt(3)==0) {
				return "000";
			}
			else {
				return ""+rnd.nextInt();
			}
			
		}
		
		public static String generateRandomDay()
		{
			return ""+(int)(Math.random() * 29);
				
		}
		
		public static String generateRandomYear()
		{
			return ""+(1950+(int)(Math.random() * 64));
				
		}
		
		public static String generateRandomMonth()
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
		
		public static String selectRandomGroup()
		{
			return "group1";
			
			// to do without app
		/*
			Random rnd = new Random();
			int index=rnd.nextInt(35);
			app.navigateTo().mainPage();
			app.navigateTo().groupPage();
			return app.getGroupHelper().getGroups().get(index).getName();
		*/
				
		}
}
