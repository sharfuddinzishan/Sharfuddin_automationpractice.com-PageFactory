package pages.com.automationpractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;


public class CartPage 
{
	
	WebDriver cartDriver;
	
	public CartPage(WebDriver driver) 
	{
		this.cartDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement HomeLogo;
	
	@FindBy(xpath="(//ul[@id='homefeatured']//span[contains(.,'$16.51')])[2]//preceding::h5//a")
	WebElement FirstProductText;
	
	@FindBy(xpath="//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]")
	WebElement AddToCartLink;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")
	WebElement AddCartSuccessmessage;
	
	@FindBy(xpath="//a[@class='blockbestsellers']")
	WebElement BestSelletTab;
	
	
	public void hoverFirstProduct()
	{
        JavascriptExecutor js = (JavascriptExecutor) cartDriver;
        js.executeScript("arguments[0].scrollIntoView();", BestSelletTab);
        
		Actions builder = new Actions(cartDriver);
        Action mouseOverHome = builder
                .moveToElement(FirstProductText)
                .build();
        mouseOverHome.perform(); 
	}

	public void clickAddToCartLink() 
	{
		AddToCartLink.click();
	}
	
	public WebElement getAddCartSuccessmessage()
	{
		return Utils.waitToBeClickable(cartDriver, AddCartSuccessmessage, 30);
	}
	
	
	public String verifyTitle() 
	{
		return cartDriver.getTitle();
	}
}
