package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void groupPage() {
		if (! onGroupPage())
		{
			driver.findElement(By.linkText("groups")).click();			
		}
	}

	private boolean onGroupPage() {
		
		if (driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new")).size()>0)
		{
			return true;
		}
		else
		{
			return false;		
		}
	
	}

	public void addNewPage() {
		if (! onAddNewPage())
		{		
			click(By.linkText("add new"));	
		}
		
	}

	private boolean onAddNewPage() {
		String title="Edit / add address book entry";
		
		if (driver.getCurrentUrl().contains("//edit.php")
				&& driver.findElement(By.xpath("//div[@id='content']/h1")).getText().equals(title))
		{
			return true;
		}
		else
		{
			return false;		
		}
		
		
		
	
	}

	public void mainPage() {
		if (! onMainPage())
		{		
			click(By.linkText("home"));		
		}
		
	}

	private boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size()>0);
	}

	public void homePage() {
		click(By.linkText("home"));
	}

	

}
