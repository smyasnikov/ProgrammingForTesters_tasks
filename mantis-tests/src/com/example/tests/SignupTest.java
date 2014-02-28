package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.fw.AccountHelper;
import com.example.fw.AdminHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;
import com.example.tests.TestBase;


public class SignupTest extends TestBase{
	
	private User user = new User().setLogin("testuser").setPassword("123").setEmail("testuser@localhost");
	private JamesHelper james;
	private AccountHelper accHelper;
	private AdminHelper admin;
	
	
	@BeforeClass
	public void createMailUser() {
		james = app.getJamesHelper();
		accHelper = app.getAccountHelper();
		admin = app.getAdminHelper();
		if (!james.doesUserExist(user.login)) {
			james.createUser(user.login, user.password);
		}
	}
	
	@Test
	public void newUserShouldSignUp() throws Exception
	{
		admin.deleteUserIfExists(user);
		accHelper.signup(user);
		accHelper.login(user);
		assertThat(accHelper.loggedUser(user), equalTo(user.login));
	}
	
	//@Test
	public void existingUserShouldNotSighUp()
	{
		/*if (!admin.userExists(user))
		{
			admin.createUser(user);
		}*/
		try {
		accHelper.signup(user);
		} catch (Exception e) {
			assertThat(e.getMessage(), containsString("That username is already being used"));
			return;
		}
		fail("User created successfully");
	}
	
	@AfterClass
	public void deleteMailUser() {
		if (james.doesUserExist(user.login)) {
			james.deleteUser(user.login);
		}
	}

}
