package pages.com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage 
{
	
	WebDriver driverMyAccount;
	
	public MyAccountPage(WebDriver driver) 
	{
		this.driverMyAccount = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement SignOutLink;
	
	public void clickSignOutLink() 
	{
		SignOutLink.click();
	}
	
	public WebElement getSignOutLink() 
	{
		return SignOutLink;
	}
	
	public String verifyTitle() 
	{
		return driverMyAccount.getTitle();
	}
}
