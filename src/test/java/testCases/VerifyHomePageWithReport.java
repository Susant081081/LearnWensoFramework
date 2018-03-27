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

public class VerifyHomePageWithReport
{
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest logger;
	
	

	@BeforeMethod
	public void setUp() 
	{
       report =new ExtentReports(".\\Reports\\LoginPageReport.html",true);
       
       logger=report.startTest("Verify Login Page Test");
       
       //logger=new ExtentTest("Verify Login Page Test", "This Test will verify if you are able to Login into the application");
		
		driver=BrowserFactory.getBrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "The Application is up and Running");
		
	}
	
	@Test
	public void testHomePage()
	{
		
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	
		
		String Title=login.getApplicationTitle();
		
		Assert.assertTrue(Title.contains("Wenso "));	
		
		logger.log(LogStatus.PASS, "HomePage is Loaded and is verified");
		
		login.loginToApplication("wenso@wenso.co.uk", "WensoPassword");
		
		login.clickSignIn();
		
		logger.log(LogStatus.INFO, "Logged into the Application");
		
		
		
		HomePageW home=	PageFactory.initElements(driver, HomePageW.class);
		
		home.verifyAccount();
		
		logger.log(LogStatus.PASS, "Account Link Appeared");
		
		home.clicklogout();
		
		logger.log(LogStatus.INFO, "Logged out from Application");
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		
		report.flush();
	}
}
