package tests.com.automationpractice;

import static org.testng.Assert.assertTrue;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PageFactoryTest_NewsLetter extends BaseClass
{

	String existsEmail = "pnt08@gmail.com";
	String unregisteredEmail = RandomStringUtils.randomAlphabetic(9,11)+"@yahoo.com";
	String invalidEmail = RandomStringUtils.randomAlphabetic(4,11)+"@gmail";

	
	@BeforeTest
	public void init()
	{
		initialization();
	}
	
	@Test(priority = 12)
	public void verify_newsletter_for_Unregistered_email() 
	{
		/* Click on logo */ 
		homePage.clickHomeLogo();
		
		/* Verify newsletter form */
		assertTrue(homePage.getNewsLetterTextField().isDisplayed());
		assertTrue(homePage.getNewsLetterButton().isDisplayed());
		
		/* Provide an unregistered email to subscribe */
		homePage.setNewsLetterTextField(unregisteredEmail);
		
		/* Click on newsletter arrow button */
		homePage.clicktNewsLetterButton();
		
		Assert.assertEquals(homePage.getNewsLetterSuccessMessage().getText(), "Newsletter : You have successfully subscribed to this newsletter.");
	}
	
//	@Test(priority = 13)
//	public void verifyregistered() 
//	{
//		Assert.assertEquals(homePage.verifyTitle(), "My Store");
//		assertTrue(homePage.getNewsLetterTextField().isDisplayed());
//		assertTrue(homePage.getNewsLetterButton().isDisplayed());
//		
//		homePage.setNewsLetterTextField(existsEmail);
//		homePage.clicktNewsLetterButton();
//		
//		assertTrue(homePage.getNewsLetterEmailExistsMessage().isDisplayed());
//	}
//	
//	@Test(priority = 14)
//	public void verifyInvalid() 
//	{
//		Assert.assertEquals(homePage.verifyTitle(), "My Store");
//		assertTrue(homePage.getNewsLetterTextField().isDisplayed());
//		assertTrue(homePage.getNewsLetterButton().isDisplayed());
//		
//		homePage.setNewsLetterTextField(invalidEmail);
//		homePage.clicktNewsLetterButton();
//		
//		assertTrue(homePage.getNewsLetterEmailInvalidMessage().isDisplayed());
//	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
