package pages.com.automationpractice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderPage 
{
    WebDriver orderDriver;
	
	public OrderPage(WebDriver driver) 
	{
		this.orderDriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement ProceedToCheckButton;
	
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement ProceesAddressButton;
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement ProceesCarrierButton;
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement AgreeTermsCheckbox;
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement BankWireTab;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement ConfirmOrder;
	
	@FindBy(xpath="//p[@class='cheque-indent']")
	WebElement OrderCompleteStatus;
	
	public void clickProceedToCheckButton() 
	{
		ProceedToCheckButton.click();
	}
	
	public void clickProceesAddressButton() 
	{
		ProceesAddressButton.click();
	}
	
	public void clickProceesCarrierButton() 
	{
		ProceesCarrierButton.click();
	}
	
	public void clickAgreeTermsCheckbox() 
	{
		AgreeTermsCheckbox.click();
	}
	
	public void clickBankWireTab() 
	{
		BankWireTab.click();
	}

	public void clickConfirmOrder() 
	{
		ConfirmOrder.click();
	}
	
	public WebElement getOrderCompleteStatus()
	{
		return OrderCompleteStatus;
	}
	
	
	
	public String verifyTitle() 
	{
		return orderDriver.getTitle();
	}

}
