package tests.com.automationpractice;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PageFactoryTest_Registration extends BaseClass
{
	String existsEmail = "pnt08@gmail.com";
	String email1 = RandomStringUtils.randomAlphabetic(5,11)+"@dhakaabpeoplentech.com";
	String email2 = RandomStringUtils.randomAlphabetic(5,11)+"@chittagongzxpeoplentech.com";
	String email3 = RandomStringUtils.randomAlphabetic(5,11)+"@Fenidfpeoplentech.com";
	String email4 = RandomStringUtils.randomAlphabetic(5,11)+"@dhakahgpeoplente.com";
	String email5 = RandomStringUtils.randomAlphabetic(5,11)+"@chittagongklpeoplent.com";
	String email6 = RandomStringUtils.randomAlphabetic(5,11)+"@Feniwepeoplen.com";
	String invalidEmail = RandomStringUtils.randomAlphabetic(9,15)+"@gmail";
	
	String firstName = RandomStringUtils.randomAlphabetic(1,32);
	String lastName = RandomStringUtils.randomAlphabetic(1,32);
	String password = RandomStringUtils.randomAlphanumeric(5,15);
	String invalidPassword = RandomStringUtils.randomAlphanumeric(1,4);
	String company = RandomStringUtils.randomAlphabetic(4,32);
	String address = RandomStringUtils.randomAlphabetic(4,32);
	String address2 = RandomStringUtils.randomAlphabetic(6,32);
	String city = RandomStringUtils.randomAlphabetic(6,12);
	String postal = RandomStringUtils.randomNumeric(5);
	String invalidPostal = RandomStringUtils.randomAlphabetic(1,4);
	String information = RandomStringUtils.randomAlphabetic(6,32);
	String homephone = RandomStringUtils.randomNumeric(6,32);
	String mobilephone = "880" + RandomStringUtils.randomNumeric(10);
	String referenceEmail = RandomStringUtils.randomAlphabetic(4,11)+"@sharfuddinapex.com";

	
	@BeforeTest
	public void init()
	{
		initialization();
	}

	@Test(priority = 1)
	public void tc301_verify_create_account_form_for_negetive_cases() 
	{
		homePage.clickSignInLink();
		
		// Submit Registration without Email
		authenticationPage.clickCreateAccountButton();
		Assert.assertTrue(authenticationPage.getInvalidEmailError().isDisplayed());

		// Submit Registration with invalid Email
		authenticationPage.setCreateEmailField(invalidEmail);
		authenticationPage.clickCreateAccountButton();
		Assert.assertTrue(authenticationPage.getInvalidEmailError().isDisplayed());

		// Submit Registration with Registered email
		authenticationPage.setCreateEmailField(existsEmail);
		authenticationPage.clickCreateAccountButton();
		Assert.assertTrue(authenticationPage.getBeenRegisteredError().isDisplayed());
	}

	@Test(priority = 2)
	public void tc302_verify_account_creation_successfully()
	{
		homePage.clickSignInLink();
		
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
		Assert.assertTrue(authenticationPage.getCreateAccountButton().isDisplayed());
		Assert.assertTrue(authenticationPage.getLoginButton().isDisplayed());
		
		authenticationPage.setCreateEmailField(email1);
		authenticationPage.clickCreateAccountButton();
		
		Assert.assertTrue(createAccountPage.getPersonalInformationForm().isDisplayed());
		
		createAccountPage.setFirstNameField(firstName);
		createAccountPage.setLastNameField(lastName);
		createAccountPage.setPasswordField(password);
		createAccountPage.setBirthDate("30");
		createAccountPage.setBirthMonth("5");
		createAccountPage.setBirthYear("2020");
		createAccountPage.setCompanyField(company);
		createAccountPage.setAddressField(address);
		createAccountPage.setCityField(city);
		createAccountPage.setState("5");
		createAccountPage.setPostalCodeField(postal);
		createAccountPage.setHomePhoneField(homephone);
		createAccountPage.setMobilePhoneField(mobilephone);
		createAccountPage.setReferenceField(referenceEmail);
		createAccountPage.clickRegisterButton();

		Assert.assertEquals(myAccountPage.verifyTitle(), "My account - My Store");
		Assert.assertTrue(myAccountPage.getSignOutLink().isDisplayed());
		
		myAccountPage.clickSignOutLink();
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
	}

	@Test(priority = 3)
	public void tc303_verify__warnings_for_blank_submission() 
	{
		homePage.clickSignInLink();
		
		authenticationPage.setCreateEmailField(email2);
		authenticationPage.clickCreateAccountButton();
		
		Assert.assertTrue(createAccountPage.getPersonalInformationForm().isDisplayed());
		
		createAccountPage.clearReferenceField(referenceEmail);
		createAccountPage.clickRegisterButton();
		
		Assert.assertTrue(createAccountPage.getErrorAtLeastOnePhoneNumber().isDisplayed());
		Assert.assertTrue(createAccountPage.getErrorLastNameRequired().isDisplayed());
		Assert.assertTrue(createAccountPage.getErrorFirstNameRequired().isDisplayed());
		Assert.assertTrue(createAccountPage.getErrorPasswordRequired().isDisplayed());
		Assert.assertTrue(createAccountPage.getErrorAddressRequired().isDisplayed());
		Assert.assertTrue(createAccountPage.getErrorCityRequired().isDisplayed());
		Assert.assertTrue(createAccountPage.getInvalidPostal().isDisplayed());
		Assert.assertTrue(createAccountPage.getErrorStateRequired().isDisplayed());
		Assert.assertTrue(createAccountPage.getErrorAliasReferenceRequired().isDisplayed());
	}
	
	@Test(priority = 4)
	public void tc304_verify_create_account_without_filling_optional_field() 
	{
		homePage.clickSignInLink();
		
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
		Assert.assertTrue(authenticationPage.getCreateAccountButton().isDisplayed());
		Assert.assertTrue(authenticationPage.getLoginButton().isDisplayed());
		
		authenticationPage.setCreateEmailField(email3);
		authenticationPage.clickCreateAccountButton();
		
		Assert.assertTrue(createAccountPage.getPersonalInformationForm().isDisplayed());
		
		createAccountPage.setFirstNameField(firstName);
		createAccountPage.setLastNameField(lastName);
		createAccountPage.setPasswordField(password);
		createAccountPage.setAddressField(address);
		createAccountPage.setCityField(city);
		createAccountPage.setState("5");
		createAccountPage.setPostalCodeField(postal);
		createAccountPage.setMobilePhoneField(mobilephone);
		createAccountPage.setReferenceField(referenceEmail);
		createAccountPage.clickRegisterButton();

		Assert.assertEquals(myAccountPage.verifyTitle(), "My account - My Store");
		Assert.assertTrue(myAccountPage.getSignOutLink().isDisplayed());
		
		myAccountPage.clickSignOutLink();
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
	}
	
	@Test(priority = 5)
	public void tc305_verify_registration_for_invalid_password_and_postal_code()
	{
		homePage.clickSignInLink();
		
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
		Assert.assertTrue(authenticationPage.getCreateAccountButton().isDisplayed());
		Assert.assertTrue(authenticationPage.getLoginButton().isDisplayed());
		
		authenticationPage.setCreateEmailField(email4);
		authenticationPage.clickCreateAccountButton();
		
		Assert.assertTrue(createAccountPage.getPersonalInformationForm().isDisplayed());
		
		createAccountPage.setFirstNameField(firstName);
		createAccountPage.setLastNameField(lastName);
		createAccountPage.setPasswordField(invalidPassword);
		createAccountPage.setAddressField(address);
		createAccountPage.setCityField(city);
		createAccountPage.setState("5");
		createAccountPage.setPostalCodeField(invalidPostal);
		createAccountPage.setMobilePhoneField(mobilephone);
		createAccountPage.setReferenceField(referenceEmail);
		createAccountPage.clickRegisterButton();
		
		Assert.assertTrue(createAccountPage.getInvalidPassword().isDisplayed());
		Assert.assertTrue(createAccountPage.getInvalidPostal().isDisplayed());
	}
	
	@Test(priority = 6)
	public void tc306_verify_date_of_birth_should_not_exceed_current_date() throws Throwable 
	{
		homePage.clickSignInLink();
		
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
		Assert.assertTrue(authenticationPage.getCreateAccountButton().isDisplayed());
		Assert.assertTrue(authenticationPage.getLoginButton().isDisplayed());
		
		authenticationPage.setCreateEmailField(email5);
		authenticationPage.clickCreateAccountButton();
		
		Assert.assertTrue(createAccountPage.getPersonalInformationForm().isDisplayed());
		
		createAccountPage.setFirstNameField(firstName);
		createAccountPage.setLastNameField(lastName);
		createAccountPage.setPasswordField(password);
		createAccountPage.setBirthDate("30");
		createAccountPage.setBirthMonth("10");
		createAccountPage.setBirthYear("2020");
		createAccountPage.setCompanyField(company);
		createAccountPage.setAddressField(address);
		createAccountPage.setCityField(city);
		createAccountPage.setState("5");
		createAccountPage.setPostalCodeField(postal);
		createAccountPage.setHomePhoneField(homephone);
		createAccountPage.setMobilePhoneField(mobilephone);
		createAccountPage.setReferenceField(referenceEmail);
		createAccountPage.clickRegisterButton();
		
		Assert.assertTrue(createAccountPage.getInvalidDateOfBirth().isDisplayed());
	}
	
	@Test(priority = 7)
	public void tc307_verify_blank_spaces_submission_of_create_account_form_fields_except_postal_code_and_state_fields() 
	{
		homePage.clickSignInLink();
		
		Assert.assertEquals(authenticationPage.verifyTitle(), "Login - My Store");
		Assert.assertTrue(authenticationPage.getCreateAccountButton().isDisplayed());
		Assert.assertTrue(authenticationPage.getLoginButton().isDisplayed());
		
		authenticationPage.setCreateEmailField(email6);
		authenticationPage.clickCreateAccountButton();
		
		Assert.assertTrue(createAccountPage.getPersonalInformationForm().isDisplayed());
		
		createAccountPage.setFirstNameField("     ");
		createAccountPage.setLastNameField("     ");
		createAccountPage.setPasswordField("     ");
		createAccountPage.setAddressField("     ");
		createAccountPage.setCityField("     ");
		createAccountPage.setState("5");
		createAccountPage.setPostalCodeField(postal);
		createAccountPage.setMobilePhoneField("     ");
		createAccountPage.setReferenceField("     ");
		
		createAccountPage.clickRegisterButton();	
		
		String actualTitle = createAccountPage.getPageTitle();	
		if(actualTitle.contentEquals("My account - My Store"))
		{
			myAccountPage.clickSignOutLink();
			Assert.assertNotEquals(createAccountPage.verifyTitle(), "Login - My Store");
		}
		else
		{
			Assert.assertEquals(createAccountPage.verifyTitle(), "Login - My Store");
		}
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
