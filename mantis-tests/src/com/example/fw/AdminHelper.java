package com.example.fw;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Logger;

import com.gargoylesoftware.htmlunit.WaitingRefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class AdminHelper extends HelperBase{
	
	Logger log = Logger.getLogger("AdminHelper");

	private WebClient web;
	private String url;

	public AdminHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		web = new WebClient();
		web.setRefreshHandler(new WaitingRefreshHandler());
		url = manager.getProperty("baseUrl");
	}

	public boolean userExists(User user) throws Exception {
		HtmlPage userPage = openUserPage(user);
		HtmlForm deleteForm = findUserRemovalForm(userPage);
		
		return deleteForm != null;
	}

	private HtmlPage openUserPage(User user) throws IOException,
			MalformedURLException {
		loginAdminIfRequired();
		String userId = manager.getHibernateHelper().getUserId(user.login);
		log.info("userId = " + userId);
		HtmlPage userPage = (HtmlPage) web.getPage(url + "manage_user_edit_page.php?user_id=" + userId);
		return userPage;
	}

	private void loginAdminIfRequired() throws IOException, MalformedURLException {
		String adminLogin = manager.getProperty("admin.login");
		String adminPass = manager.getProperty("admin.pass");
		log.info("logging with " + adminLogin + "/" + adminPass);
		
		HtmlPage mainPage = (HtmlPage) web.getPage(url);
		log.info("mainPage opened");
		HtmlForm loginForm = mainPage.getFormByName("login_form");
		log.info("loginForm = " + loginForm);
		if (loginForm != null)
		{
			loginForm.getInputByName("username").setValueAttribute(adminLogin);
			loginForm.getInputByName("password").setValueAttribute(adminPass);
			loginForm.getInputByValue("Login").click();
			log.info("loginForm submitted");
		}
	}

	private HtmlForm findUserRemovalForm(HtmlPage userPage) {
		List<HtmlForm> forms = userPage.getForms();
		for (HtmlForm form : forms) {
			if (form.getActionAttribute().endsWith("manage_user_delete.php"))
			{
				return form;
			}
		}
		return null;
	}

	public void deleteUserIfExists(User user) throws Exception {
		log.info("Deleting user " + user.login);
		HtmlPage userPage = openUserPage(user);
		log.info("userPage opened");
		HtmlForm deleteForm = findUserRemovalForm(userPage);
		log.info("deleteForm = " + deleteForm);
		if (deleteForm != null)
		{
			HtmlPage commitPage = (HtmlPage) deleteForm.getInputByValue("Delete User").click();
			log.info("commitPage opened");
			HtmlForm commitForm = findUserRemovalForm(commitPage);
			log.info("commitForm = " + commitForm);
			commitForm.getInputByValue("Delete Account").click();
			log.info("commitForm submitted");
		}
	}

}
