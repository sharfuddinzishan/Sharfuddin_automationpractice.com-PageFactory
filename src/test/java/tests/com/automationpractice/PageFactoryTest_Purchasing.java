package tests.com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class PageFactoryTest_Purchasing extends BaseClass
{
	String existsEmail = "pnt08@gmail.com";
	String existsEmailPassword = "12345";

	@BeforeTest
	public void init()
	{
		initialization();
	}
	
	@Test(priority = 16)
	public void verify_add_any_product_to_cart_from_homepage() throws Throwable
	{
		/* Click on logo */ 
		homePage.clickHomeLogo();
		
		/* Search for T Shirt */
		homePage.typeSearchTextField("T shirt");
		
		/*Click Search Button  */
		homePage.clickSearchButton();
		
		/* Verify After click on search button from homepage, page redirects to Search page */
		Assert.assertEquals(searchPage.verifyTitle(), "Search - My Store");
		
		/* Hover mouse on test ($16.51) product from homepage */
		searchPage.hoverTestProduct();
		
		Thread.sleep(3000);
		/* Click on Blue Color */
		searchPage.clickBlueColor();
		
		/* Click Add To Cart button from below */
		searchPage.clickAddToCartButtonProduct();
		
		/* Verify the product is added to cart from success message */
		Assert.assertEquals(cartPage.getAddCartSuccessmessage().getText(), "Product successfully added to your shopping cart");
		
		/* Click Button "Proceed To Checkout" to go to order page */
		searchPage.clickProceedToCheckButton();
		
		/* Verify that order page comes after clicking on "Proceed To Checkout" button */
		Assert.assertEquals(orderPage.verifyTitle(), "Order - My Store");
		
		/* Again click on "Proceed To Checkout" button */
		orderPage.clickProceedToCheckButton();
		Thread.sleep(3000);
		
		/* Login To The System with valid credentials */
		authenticationPage.setLoginEmailField(existsEmail);
		authenticationPage.setLoginPasswordField(existsEmailPassword);
		authenticationPage.clickLoginButton();
		
		/* Again click on "Proceed To Checkout" button */
		orderPage.clickProceesAddressButton();
		
		/* Click to agree to the terms of service */
		orderPage.clickAgreeTermsCheckbox();
		
		/* Again click on "Proceed To Checkout" button */
		orderPage.clickProceesCarrierButton();
		
		Thread.sleep(3000);
		
		/* Select Pay by bank wire */
		orderPage.clickBankWireTab();
		
		/* Click to Confirm Order */
		orderPage.clickConfirmOrder();
		
		/* Verify Order Confirmation  */
		Assert.assertEquals(orderPage.verifyTitle(), "Order confirmation - My Store");
		System.out.println(orderPage.getOrderCompleteStatus().getText());
		Assert.assertEquals(orderPage.getOrderCompleteStatus().getText(), "Your order on My Store is complete.");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
