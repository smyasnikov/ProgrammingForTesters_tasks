package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class CheckPhones extends TestBase{

@Test
public void testComparePhoneLists () {
	//navigate to mainPage
	app.navigateTo().mainPage();
	
	// save mainPage stage
	SortedListOf<ContactData> list1 = new SortedListOf<ContactData>(app.getContactHelper().getContactsForPrintPhone());
	System.out.println("Saved Parametres from main page");
	System.out.println(list1.size());
	for (int i = 0; i < 12; i++) {
		System.out.println(list1.get(i));
	}

	
	//navigate to printPhonesPage
	app.navigateTo().printPhonesPage();
	
	// save printPhonesPage stage
	SortedListOf<ContactData> list2 = app.getContactHelper().getContactDataFromPrintPhonesForm();
	System.out.println("Saved Parametres from print phones");
	System.out.println(list2.size());
	for (int i = 0; i < 12; i++) {
		System.out.println(list2.get(i));
	}
	
	// compare lists
    assertThat(list1, equalTo(list2));
	
	
}

}
