package tests.com.automationpractice;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PageFactoryTest_HomePage_UI_Element extends BaseClass
{
	
	@BeforeTest
	public void init()
	{
		initialization();
	}
	
	@Test(priority = 11)
	public void verify_UI_Element_of_Home_Page() 
	{
		/* Sign in link from topbar */
		assertTrue(homePage.getSignInLink().isDisplayed());
		
		/* Searchform */
		assertTrue(homePage.getSearchForm().isDisplayed());
		
		/*Information section from footer*/
		assertTrue(homePage.getHeadingInformation().isDisplayed());
		
		/*Contact Us link of Information section from footer */
		assertTrue(homePage.getContactUsLink().isDisplayed());
		
		/*Specials link of Information section from footer */
		assertTrue(homePage.getSpecialsLink().isDisplayed());
		
		/*Our Stores link of Information section from footer */
		assertTrue(homePage.getOurStoreLink().isDisplayed());
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
