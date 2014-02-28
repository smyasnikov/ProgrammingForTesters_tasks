package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	
	private WebDriver driver;
	public String baseUrl;
	
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	private FtpHelper ftpHelper;
	private AdminHelper adminHelper;
	
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
	}

	public void stop() {
		 driver.quit();
		 ftpHelper.restoreConfig();
		}
	
	public WebDriver getDriver() {
		if (driver==null) {
			String browser = properties.getProperty("browser");
			if ("firefox".equals(browser))
			{
				driver = new FirefoxDriver();
			}
			else if ("ie".equals(browser))
			{
				driver = new InternetExplorerDriver();
			}
			else 
			{
				throw new Error("Unsupported browser:" + browser);
			}

		}
		baseUrl = properties.getProperty("baseUrl");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		return driver;
	}

	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper==null) {
			hibernateHelper = new HibernateHelper(this);	
		}
		return hibernateHelper;	
	}
	
	public String getProperty(String key)
	{
		return properties.getProperty(key);
	}

	public AccountHelper getAccountHelper() {
		if (accountHelper==null) {
			accountHelper = new AccountHelper(this);	
		}
		return accountHelper;	
	}

	public MailHelper getMailHelper() {
		if (mailHelper==null) {
			mailHelper = new MailHelper(this);	
		}
		return mailHelper;
	}
	
	public JamesHelper getJamesHelper() {
		if (jamesHelper==null) {
			jamesHelper = new JamesHelper(this);	
		}
		return jamesHelper;
	}
	
	public FtpHelper getFtpHelper() {
		if (ftpHelper==null) {
			ftpHelper = new FtpHelper(this);	
		}
		return ftpHelper;
	}

	public AdminHelper getAdminHelper() {
		if (adminHelper==null) {
			adminHelper = new AdminHelper(this);	
		}
		return adminHelper;
	}

}
