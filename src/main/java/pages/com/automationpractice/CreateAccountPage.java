package pages.com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class CreateAccountPage {
	
	WebDriver driverCreateAccount;
	
	public CreateAccountPage(WebDriver driver) 
	{
		this.driverCreateAccount = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Your personal information')]")
	WebElement PersonalInformationForm;

	@FindBy(xpath="//div[@id='uniform-id_gender1']")
	WebElement TitleMr;
	
	@FindBy(xpath="//div[@id='uniform-id_gender2']")
	WebElement TitleMrs;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement FirstNameField;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement LastNameField;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailField;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement PasswordField;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement BirthDate;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement BirthMonth;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement BirthYear;
	
	@FindBy(xpath="//div[@id='uniform-newsletter']")
	WebElement NewsLetter;
	
	@FindBy(xpath="//div[@id='uniform-optin']")
	WebElement Offer;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement AutoFirstNameField;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement AutoLastNameField;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement CompanyField;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement AddressField;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement AddressLineField;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement City;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement State;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement PostalCodeField;
	
	@FindBy(xpath="")
	WebElement AdditionalInformationField;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement HomePhoneField;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement MobilePhoneField;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement ReferenceField;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement RegisterButton;
	
	/***************** All Error Locators **********************/
	
	@FindBy(xpath="//li[contains(text(),'You must register at least one phone number.')]")
	WebElement ErrorAtLeastOnePhoneNumber;
	
	@FindBy(xpath="//b[contains(text(),'lastname')]")
	WebElement ErrorLastNameRequired;
	
	@FindBy(xpath="//b[contains(text(),'firstname')]")
	WebElement ErrorFirstNameRequired;
	
	@FindBy(xpath="//b[contains(text(),'passwd')]")
	WebElement ErrorPasswordRequired;
	
	@FindBy(xpath="//b[contains(text(),'alias')]")
	WebElement ErrorAliasReferenceRequired;
	
	@FindBy(xpath="//b[contains(text(),'address1')]")
	WebElement ErrorAddressRequired;
	
	@FindBy(xpath="//b[contains(text(),'city')]")
	WebElement ErrorCityRequired;
	
	@FindBy(xpath="//li[contains(text(),\"The Zip/Postal code you've entered is invalid. It\")]")
	WebElement InvalidPostal;
	
	@FindBy(xpath="//b[contains(text(),'passwd')]")
	WebElement InvalidPassword;
	
	@FindBy(xpath="//li[contains(text(),\"The Zip/Postal code you've entered is invalid. It\")]")
	WebElement ErrorStateRequired;
	
	@FindBy(xpath="//li[contains(text(),'Invalid date of birth')]")
	WebElement InvalidDateOfBirth;
	
	/*###########################   Set      ##########################*/
	public void setTitleMr() 
	{
		TitleMr.click();
	}
	
	public void setTitleMrs() 
	{
		TitleMrs.click();
	}
	
	public void setFirstNameField(String firstName) 
	{
		FirstNameField.sendKeys(firstName);
	}
	
	public void setLastNameField(String lastName) 
	{
		LastNameField.sendKeys(lastName);
	}
	
	public void setEmailField(String email) 
	{
		EmailField.sendKeys(email);
	}
	
	public void setPasswordField(String password) 
	{
		PasswordField.sendKeys(password);
	}
	
	public void setBirthDate(String day) 
	{
		Select selectBirthDate = new Select(BirthDate);
		selectBirthDate.selectByValue(day);
	}
	
	public void setBirthMonth(String month) 
	{
		Select selectBirthMonth = new Select(BirthMonth);
		selectBirthMonth.selectByValue(month);
	}
	
	public void setBirthYear(String year) 
	{
		Select selectBirthYear = new Select(BirthYear);
		selectBirthYear.selectByValue(year);
	}
	
	public void setCompanyField(String company) 
	{
		CompanyField.sendKeys(company);
	}
	
	public void setAddressField(String address) 
	{
		AddressField.sendKeys(address);
	}
	
	public void setAddressLineField(String addresTwo) 
	{
		AddressLineField.sendKeys(addresTwo);
	}
	
	public void setCityField(String city) 
	{
		City.sendKeys(city);
	}
	
	public void setState(String state) 
	{
		Select selectState = new Select(State);
		selectState.selectByValue(state);
	}
	
	public void setPostalCodeField(String zip) 
	{
		PostalCodeField.sendKeys(zip);
	}
	
	public void setAdditionalInformationField(String info) 
	{
		AdditionalInformationField.sendKeys(info);
	}
	
	public void setHomePhoneField(String phone) 
	{
		HomePhoneField.sendKeys(phone);
	}
	
	public void setMobilePhoneField(String phone) 
	{
		MobilePhoneField.sendKeys(phone);
	}
	
	public void setReferenceField(String reference) 
	{
		ReferenceField.clear();
		ReferenceField.sendKeys(reference);
	}

	/*###########################   Get      ##########################*/
	public WebElement getPersonalInformationForm() 
	{
		return PersonalInformationForm;
	}

	public WebElement getErrorAliasReferenceRequired() 
	{
		return ReferenceField;
	}
	
	/*###########################   Get  Error   ##########################*/
	
	public WebElement getErrorAtLeastOnePhoneNumber()
	{
		return ErrorAtLeastOnePhoneNumber;
	}
	
	public WebElement getErrorLastNameRequired()
	{
		return ErrorLastNameRequired;
	}
	
	public WebElement getErrorFirstNameRequired()
	{
		return ErrorFirstNameRequired;
	}
	
	public WebElement getErrorPasswordRequired()
	{
		return ErrorPasswordRequired;
	}
	
	public WebElement getErrorAddressRequired()
	{
		return ErrorAddressRequired;
	}
	
	public WebElement getErrorCityRequired()
	{
		return ErrorCityRequired;
	}
	
	public WebElement getInvalidPostal()
	{
		return InvalidPostal;
	}
	
	public WebElement getErrorStateRequired()
	{
		return ErrorStateRequired;
	}
	
	public WebElement getInvalidDateOfBirth()
	{
		return InvalidDateOfBirth;
	}
	
	public WebElement getInvalidPassword()
	{
		return InvalidPassword;
	}
	
	
	/*###########################     Click    ##########################*/
	
	public void clickRegisterButton()
	{
		RegisterButton.click();
	}
	

	/*###########################     ------    ##########################*/

	public void clearReferenceField(String referenceEmail) 
	{
		ReferenceField.clear();	
	}
	
	public String getPageTitle() 
	{
		return driverCreateAccount.getTitle();
	}
	
	public String verifyPersonalInformationForm() 
	{
		return PersonalInformationForm.getText();
	}
	
	
	public String verifyTitle() 
	{
		return driverCreateAccount.getTitle();
	}
	
}
