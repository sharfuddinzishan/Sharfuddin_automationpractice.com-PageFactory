package tests.com.automationpractice;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PageFactoryTest_Login extends BaseClass
{
	String password = RandomStringUtils.randomAlphanumeric(5,15);
	String invalidPassword = RandomStringUtils.randomAlphanumeric(1,4);
	String existsEmail = "pnt08@gmail.com";
	String existsEmailPassword = "12345";
	String unregisteredEmail = RandomStringUtils.randomAlphabetic(9,11)+"@yahoo.com";
	String invalidEmail = RandomStringUtils.randomAlphabetic(4,11)+"@gmail";

	
	@BeforeTest
	public void init()
	{
		initialization();
	}
	
	@Test(priority = 8)
	public void tc401_verify_ui_elements_of_login_form() 
	{
		homePage.clickSignInLink();
		
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
		
		Assert.assertTrue(authenticationPage.getLoginEmailField().isDisplayed());
		Assert.assertTrue(authenticationPage.getLoginPasswordField().isDisplayed());
		Assert.assertTrue(authenticationPage.getLoginButton().isEnabled());
	}

	@Test(priority = 9)
	public void tc402_verfy_signin_functionality_for_negetive()
	{
		homePage.clickSignInLink();
		
		authenticationPage.setLoginEmailField(invalidEmail);
		authenticationPage.setLoginPasswordField(password);
		authenticationPage.clickLoginButton();

		Assert.assertTrue(authenticationPage.getInvalidEmailError().isDisplayed());

		authenticationPage.setLoginEmailField(unregisteredEmail);
		authenticationPage.setLoginPasswordField(existsEmailPassword);
		authenticationPage.clickLoginButton();
	
		Assert.assertTrue(authenticationPage.getAuthenticationError().isDisplayed());
		

		authenticationPage.setLoginEmailField("");
		authenticationPage.setLoginPasswordField("");
		authenticationPage.clickLoginButton();

		Assert.assertTrue(authenticationPage.getEmailRequiredError().isDisplayed());

	}

	@Test(priority = 10)
	public void tc403_verfy_signin_functionality_for_positive() 
	{
		homePage.clickSignInLink();
		
		authenticationPage.setLoginEmailField(existsEmail);
		authenticationPage.setLoginPasswordField(existsEmailPassword);
		authenticationPage.clickLoginButton();

		Assert.assertEquals(myAccountPage.verifyTitle(), "My account - My Store");
		Assert.assertTrue(myAccountPage.getSignOutLink().isDisplayed());
		
		myAccountPage.clickSignOutLink();
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
