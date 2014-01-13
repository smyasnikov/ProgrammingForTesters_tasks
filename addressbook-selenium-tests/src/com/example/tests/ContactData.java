package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstName;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email;
	private String email2;
	private String bDay;
	private String bMonth;
	private String bYear;
	private String group;
	private String address2;
	private String phone2;

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

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", homePhone=" + homePhone + ", email=" + email /*+ ", email2="
				+ email2*/ + "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		/*result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((email2 == null) ? 0 : email2.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());*/
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		/*if (email2 == null) {
			if (other.email2 != null)
				return false;
		} else if (!email2.equals(other.email2))
			return false;*/
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
	}

	public ContactData withFirstName(String firstName) {
		
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;

		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
	
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
	
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
	
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
	
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
	
		return this;
	}

	public ContactData withBDay(String bDay) {
		this.bDay = bDay;
	
		return this;
	}

	public ContactData withBMonth(String bMonth) {
		this.bMonth = bMonth;
	
		return this;
	}

	public ContactData withBYear(String bYear) {
		this.bYear = bYear;
	
		return this;
	}

	public ContactData withGroup(String group) {
		this.group = group;
	
		return this;
	}

	public ContactData withaddress2(String address2) {
		this.address2 = address2;
	
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
	
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getbDay() {
		return bDay;
	}

	public String getbMonth() {
		return bMonth;
	}

	public String getbYear() {
		return bYear;
	}

	public String getGroup() {
		return group;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}
		
}