package pages.com.automationpractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage 
{
    WebDriver searchDriver;
	
	public SearchPage(WebDriver driver) 
	{
		this.searchDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@id='center_column']//span[contains(.,'$16.51')])[2]//parent::div//preceding-sibling::h5//a")
	WebElement ProductItemLink;
	
	@FindBy(xpath="//a[@id='color_14']")
	WebElement BlueColor;
	
	@FindBy(xpath="//button[@name='Submit']")
	WebElement AddToCartButton;
	
	@FindBy(xpath="//span[@class='available-now']")
	WebElement InStock;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement ProceedToCheckButton;
	
	@FindBy(xpath="//span[contains(text(),'Quick view')]")
	WebElement QuickView;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement AddToCartButtonProduct;
	
	
	public void hoverTestProduct()
	{
        JavascriptExecutor js = (JavascriptExecutor) searchDriver;
        js.executeScript("arguments[0].scrollIntoView();", InStock);
        
		Actions builder = new Actions(searchDriver);
        Action mouseOverHome = builder
                .moveToElement(ProductItemLink).click()
                .build();
        mouseOverHome.perform(); 
	}

	public void clickAddToCartButtonProduct() 
	{
		AddToCartButtonProduct.click();
	}

	public void clickProceedToCheckButton() 
	{
		ProceedToCheckButton.click();
	}

	public void clickBlueColor() 
	{
//		Utils.waitToBeClickable(searchDriver, BlueColor, 30).click();
		BlueColor.click();
	}
	
	public String verifyTitle() 
	{
		return searchDriver.getTitle();
	}

}
