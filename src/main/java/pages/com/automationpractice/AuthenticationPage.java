package pages.com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthenticationPage {
	
	WebDriver driverAuthentication;
	
	public AuthenticationPage(WebDriver driver) 
	{
		this.driverAuthentication = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement CreateEmailField;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement CreateAccountButton;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement LoginEmailField;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement LoginPasswordField;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement LoginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement ForgotPasswordLink;
	
	/*####################   Error Locators     ####################### */
	
	@FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
	WebElement InvalidEmailError;
	
	@FindBy(xpath="//li[contains(text(),'An account using this email address has already be')]")
	WebElement BeenRegisteredError;
	
	@FindBy(xpath="//li[contains(text(),'An email address required.')]")
	WebElement EmailRequiredError;
	
	@FindBy(xpath="//li[contains(text(),'Password is required.')]")
	WebElement PasswordRequiredError;
	
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")
	WebElement AuthenticationError;
	
	/*####################   Set Method    ####################### */
	
	
	public void setCreateEmailField(String mail) 
	{
		CreateEmailField.clear();
		CreateEmailField.sendKeys(mail);
	}
	
	public void setLoginEmailField(String Email) 
	{
		LoginEmailField.clear();
		LoginEmailField.sendKeys(Email);
	}
	
	public void setLoginPasswordField(String Password) 
	{
		LoginPasswordField.clear();
		LoginPasswordField.sendKeys(Password);
	}
	
	/*####################   Get Method     ####################### */
	
	public WebElement getLoginEmailField() 
	{
		return LoginEmailField;
	}

	public WebElement getLoginPasswordField() 
	{
		return LoginPasswordField;
	}
	
	public WebElement getCreateAccountButton() 
	{
		return CreateAccountButton;
	}
	
	public WebElement getLoginButton() 
	{
		return LoginButton;
	}
	
	public WebElement getInvalidEmailError() 
	{
		return InvalidEmailError;
	}

	public WebElement getBeenRegisteredError() 
	{
		return BeenRegisteredError;
	}
	
	public WebElement getPasswordRequiredError() 
	{
		return PasswordRequiredError;
	}
	
	public WebElement getEmailRequiredError() 
	{
		return EmailRequiredError;
	}

	public WebElement getAuthenticationError() 
	{
		return AuthenticationError;
	}
	
	/*####################   ClickMethod     ####################### */
	
	public void clickCreateAccountButton() 
	{
		CreateAccountButton.click();
	}

	public void clickLoginButton() 
	{
		LoginButton.click();
	}
	
	
	
	
	public String verifyTitle() 
	{
		return driverAuthentication.getTitle();
	}	
}
