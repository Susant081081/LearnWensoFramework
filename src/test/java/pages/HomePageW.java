package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePageW
{

	WebDriver driver;
	
	public HomePageW(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	//@FindBy(xpath=("//a[@href='http://testing.wensohrsms.co.uk/crm/account']")) WebElement Account;
	
	@FindBy(xpath=("//a[@href='http://testing.wensohrsms.co.uk/crm/logout']")) WebElement Logout;
	
	By Account=By.xpath("//a[@href='http://testing.wensohrsms.co.uk/crm/account']");
	
	public void clicklogout()
	{
		Logout.click();
	}
	
	public void verifyAccount()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(Account));
		
		String txt=ele.getText();
		
		Assert.assertEquals(txt, "My Account");
		
		
		
	}
	
}
