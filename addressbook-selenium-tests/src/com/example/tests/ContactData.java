package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String email2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String group;
	public String address2;
	public String phone2;

	public ContactData(String firstName, String lastName, String address,
			String homePhone, String mobilePhone, String workPhone,
			String email, String email2, String bDay, String bMonth,
			String bYear, String group, String address2, String phone2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email = email;
		this.email2 = email2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.group = group;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	
	public ContactData() {
		
	}
}