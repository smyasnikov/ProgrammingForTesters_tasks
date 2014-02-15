package com.example.fw;

import java.util.List;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ApplicationModel {
	
	private SortedListOf<GroupData> groups;
	private SortedListOf<ContactData> contacts;
	
	public SortedListOf<GroupData> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupData> list){
		this.groups=new SortedListOf<GroupData>(list);
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);
		return this;
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;	
		}
	
	public SortedListOf<ContactData> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<ContactData> list){
		this.contacts=new SortedListOf<ContactData>(list);
	}

	public ApplicationModel removeContact(int index) {
		contacts.remove(index);
		return this;
	}

	public ApplicationModel addContact(ContactData contact) {
		contacts.add(contact);
		return this;
	}
}
