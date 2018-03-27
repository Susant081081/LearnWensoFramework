package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
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
import utility.Helper;

public class VerifyHomePageWithReport2
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
		
		Assert.assertTrue(Title.contains("Wenso CRM"));	
		
		logger.log(LogStatus.PASS, "HomePage is Loaded and is verified");
		
		login.loginToApplication(DataProviderFactory.getExcel().getData(0, 0,0),DataProviderFactory.getExcel().getData(0, 0, 1));
		
		login.clickSignIn();
		
		logger.log(LogStatus.INFO, "Logged into the Application");
		
		
		
		HomePageW home=	PageFactory.initElements(driver, HomePageW.class);
		
		home.verifyAccount();
		
		logger.log(LogStatus.PASS, "Account Link Appeared");
		
		home.clicklogout();
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureSceenshot(driver, "validation2")));
		
		logger.log(LogStatus.INFO, "Logged out from Application");
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==result.FAILURE)
		{
			String path=Helper.captureSceenshot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		
		report.flush();
	}
}
