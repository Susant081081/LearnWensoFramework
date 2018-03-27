package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePageW;
import pages.LoginPage;

public class VerifyHomePage
{
	WebDriver driver;
	
	
	

	@BeforeMethod
	public void setUp() 
	{
       
       
       
       //logger=new ExtentTest("Verify Login Page Test", "This Test will verify if you are able to Login into the application");
		
		driver=BrowserFactory.getBrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		
		
	}
	
	@Test
	public void testHomePage()
	{
		
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	
		
		String Title=login.getApplicationTitle();
		
		Assert.assertTrue(Title.contains("Wenso CRM"));	
		
	
		
		login.loginToApplication("wenso@wenso.co.uk", "WensoPassword");
		
		login.clickSignIn();

		
		
		
		HomePageW home=	PageFactory.initElements(driver, HomePageW.class);
		
		home.verifyAccount();
		
	
		
		home.clicklogout();
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		
		
	}
}
