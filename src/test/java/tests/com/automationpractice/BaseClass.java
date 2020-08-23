
package tests.com.automationpractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.com.automationpractice.AuthenticationPage;
import pages.com.automationpractice.CartPage;
import pages.com.automationpractice.CreateAccountPage;
import pages.com.automationpractice.HomePage;
import pages.com.automationpractice.MyAccountPage;
import pages.com.automationpractice.OrderPage;
import pages.com.automationpractice.SearchPage;

public class BaseClass 
{
	public static WebDriver driver;
	
	public HomePage homePage;
	public AuthenticationPage authenticationPage;
	public CreateAccountPage createAccountPage;
	public MyAccountPage myAccountPage;
	public SearchPage searchPage;
	public CartPage cartPage;
	public OrderPage orderPage;
	
	public  void initialization()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		homePage     		=   new HomePage(driver);
		authenticationPage  	=   new AuthenticationPage(driver);
		createAccountPage   	=   new CreateAccountPage(driver);
		myAccountPage       	=   new MyAccountPage(driver);
		searchPage   		=   new SearchPage(driver);
		cartPage   		=   	new CartPage(driver);
		orderPage   		=   new OrderPage(driver);
		
		String baseUrl = "http://automationpractice.com/index.php";
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
