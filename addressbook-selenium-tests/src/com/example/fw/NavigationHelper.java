package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void openGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	public void openAddNewPage() {
		click(By.linkText("add new"));
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void returnToHomePage() {
		click(By.linkText("home"));
	}

	

}
