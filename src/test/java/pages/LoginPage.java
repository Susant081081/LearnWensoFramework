package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id="inputEmail") WebElement Emailaddress;
	
	@FindBy(id="inputPassword") WebElement Password;
	
	@FindBy(xpath=("//button[@class='btn btn-lg btn-primary btn-block']")) WebElement SignIn;
	
	@FindBy(xpath=("//checkbox[@name='remember']")) WebElement remember_me;
	
	public void EnterTextEmailaddress()
	{
		Emailaddress.sendKeys("wenso@wenso.co.uk");
		
	}
	public void EnterTextPassword()
	{
		Password.sendKeys("WensoPassword");
		
	}
	
	public void clickSignIn()
	{
		SignIn.click();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
		
	}
	public void loginToApplication(String user, String pass)
	{
		Emailaddress.sendKeys(user);
		
		Password.sendKeys(pass);
		
		
	
	}
}


