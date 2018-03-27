package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.LoginPage;


public class VerifyLoginPage 
{

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=BrowserFactory.getBrowser("Firefox");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
	}
	
	@Test
	public void testLoginPage()	
	{
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		
		login.loginToApplication("wenso@wenso.co.uk", "WensoPassword");
		
		login.clickSignIn();
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		
		BrowserFactory.closeBrowser(driver);
	}
	
}
