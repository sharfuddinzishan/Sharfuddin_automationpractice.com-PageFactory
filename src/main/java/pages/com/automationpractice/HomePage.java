package pages.com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	WebDriver homeDriver;
	
	public HomePage(WebDriver driver) 
	{
		this.homeDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement HomeLogo;
	
	@FindBy(xpath="//a[contains(.,'Sign in')]")
	WebElement SignInLink;
	
	@FindBy(xpath="//form[@id='searchbox']")
	WebElement SearchForm;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement SearchTextField;
	
	@FindBy(xpath="//button[contains(.,'Search')]")
	WebElement SearchButton;
	
	@FindBy(xpath="//a[contains(@title,'Contact us')]")
	WebElement ContactUsLink;
	
	@FindBy(xpath="//a[contains(@title,'Specials')]")
	WebElement SpecialsLink;
	
	@FindBy(xpath="//h4[text()='Information']")
	WebElement HeadingInformation;
	
	@FindBy(xpath="//a[contains(.,'Our stores')]")
	WebElement OurStoreLink;
	
	@FindBy(xpath="//input[@id='newsletter-input']")
	WebElement NewsLetterTextField;
	
	@FindBy(xpath="//input[@id='newsletter-input']//following-sibling::button")
	WebElement NewsLetterButton;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement NewsLetterSuccessMessage;
	
	@FindBy(xpath="//p[@class='alert alert-danger']")
	WebElement NewsLetterEmailExistsMessage;
	
	@FindBy(xpath="//p[@class='alert alert-danger']")
	WebElement NewsLetterEmailInvalidMessage;
	
	
	/********##################       Set        ################******************/
	public void setNewsLetterTextField(String email)
	{
		NewsLetterTextField.clear();
		NewsLetterTextField.sendKeys(email);
	}
	
	public void typeSearchTextField(String searchText) 
	{
		SearchTextField.clear();
		SearchTextField.click();
		SearchTextField.sendKeys(searchText);
	}
	
	/********##################       Get        ################******************/
	
	public WebElement getNewsLetterTextField()
	{
		return NewsLetterTextField;
	}
	
	public WebElement getNewsLetterButton()
	{
		return NewsLetterButton;
	}
	
	public WebElement getNewsLetterSuccessMessage()
	{
		return NewsLetterSuccessMessage;
	}
	
	public WebElement getNewsLetterEmailExistsMessage()
	{
		return NewsLetterEmailExistsMessage;
	}
	
	public WebElement getNewsLetterEmailInvalidMessage() 
	{
		return NewsLetterEmailInvalidMessage;
	}
	
	
	/********##################     Web Element          ################******************/
	
	public WebElement getSearchForm() 
	{
		return SearchForm;
	}

	public WebElement getContactUsLink() 
	{
		return ContactUsLink;
	}

	public WebElement getSpecialsLink() 
	{
		return SpecialsLink;
	}

	public WebElement getOurStoreLink() 
	{
		return OurStoreLink;
	}

	public WebElement getHeadingInformation() 
	{
		return HeadingInformation;
	}

	public WebElement getSignInLink() 
	{
		return SignInLink;
	}
	
	/********##################        Click       ################******************/

	public void clicktNewsLetterButton()
	{
		NewsLetterButton.click();
	}

	public void clickSignInLink() 
	{
		SignInLink.click();
	}
	
	public void clickHomeLogo() 
	{
		HomeLogo.click();
	}

	public void clickSearchButton() 
	{
		SearchButton.click();
	}
	
	
	public String verifyTitle() 
	{
		return homeDriver.getTitle();
	}
}
