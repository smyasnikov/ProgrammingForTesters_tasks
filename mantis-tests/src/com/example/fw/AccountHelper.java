package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends WebDriverHelperBase{

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signup(User user) {
		openUrl("");
		click(By.linkText("Signup for a new account"));
		type("username", user.login);
		type("email", user.email);
		click(By.cssSelector("input.button"));
		
		//check if user exists
		WebElement eroorMessage = findElement(By.cssSelector("table.width50 tbody tr:nth-child(2) td p"));
		if (eroorMessage != null)
		{
			throw new RuntimeException(eroorMessage.getText());
		}
		
		pause(30000);
		Msg msg = manager.getMailHelper().getNewMail(user.login, user.password);
		String confirmationLink = msg.getConfirmationLink();
		openAbcoluteUrl(confirmationLink);
		
		type("password", "123");
		type("password_confirm", "123");
		click(By.cssSelector("input.button"));
	}
	public String loggedUser(User user) {
		WebElement element = driver.findElement(By.cssSelector("td.login-info-left span"));
		return element.getText();
	}

	public void login(User user) {
		openUrl("");
		type("username", user.login);
		type("password",user.password);
		click(By.cssSelector("input.button"));
	}

}
