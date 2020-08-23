package tests.com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class PageFactoryTest_Add_To_Cart extends BaseClass
{

	@BeforeTest
	public void init()
	{
		initialization();
	}
	
	@Test(priority = 15)
	public void verify_add_any_product_to_cart_from_homepage()
	{
		/* Click on logo */ 
		homePage.clickHomeLogo();
		
		/* Hover mouse on first popular product from homepage */
		cartPage.hoverFirstProduct();
		
		/* Click Add To Car button to add the product to cart */
		cartPage.clickAddToCartLink();
		
		/* Verify the product is added to cart from success message */
		Assert.assertEquals(cartPage.getAddCartSuccessmessage().getText(), "Product successfully added to your shopping cart");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
