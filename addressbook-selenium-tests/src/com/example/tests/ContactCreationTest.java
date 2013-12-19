package com.example.tests;


import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{
  @Test
  public void testContactCreation() throws Exception {
	openMainPage();
	openPage("add new");
	ContractData contract = new ContractData();
	contract.firstName = "FirstName1";
	contract.lastName = "LastName1";
	contract.address = "Address1";
	contract.homePhone = "+11111111111";
	contract.mobilePhone = "+22222222222";
	contract.workPhone = "+33333333333";
	contract.email = "LastName1@email1.book";
	contract.email2 = "LastName2@email1.book";
	contract.bDay = "1";
	contract.bMonth = "January";
	contract.bYear = "1977";
	contract.group = "group1";
	contract.address2 = "Address2";
	contract.phone2 = "home1";
	fillContractForm(contract);
    submitGroupCreation();
    returnToPage("home");
  }
}
