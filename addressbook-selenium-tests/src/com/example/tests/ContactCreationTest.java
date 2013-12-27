package com.example.tests;


import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{
  @Test
  public void testContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().openAddNewPage();
	ContactData contact = new ContactData();
	contact.firstName = "FirstName1";
	contact.lastName = "LastName1";
	contact.address = "Address1";
	contact.homePhone = "+11111111111";
	contact.mobilePhone = "+22222222222";
	contact.workPhone = "+33333333333";
	contact.email = "LastName1@email1.book";
	contact.email2 = "LastName2@email1.book";
	contact.bDay = "1";
	contact.bMonth = "January";
	contact.bYear = "1977";
	contact.group = "group1";
	contact.address2 = "Address2";
	contact.phone2 = "home1";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContractCreation();
<<<<<<< HEAD
    app.getNavigationHelper().returnToHomePage();
=======
    app.getNavigationHelper().returnToHomePage(app);
>>>>>>> de820354d7e29a062b742a247611753c93689684
  }
}
