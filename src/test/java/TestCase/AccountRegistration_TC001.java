package TestCase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.BasePage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class AccountRegistration_TC001 extends BaseClass{

	@Test(groups= {"Regression", "Master"})
	public void accotRegistration()
	{
		logger.info("AccountRegistration Test Started.........");
		HomePage hp=new HomePage(driver);
		hp.clickOnMyAccount();
		logger.info("Clicked on My Account.........");
		hp.clickOnRegister();
		
		AccountRegistrationPage ac= new AccountRegistrationPage(driver);
		ac.setFirstName(setFirstNameLastName().toUpperCase());
		ac.setLastName(setFirstNameLastName().toUpperCase());
		ac.setEmail(setFirstNameLastName()+"@gmail.com");
		ac.setMobileNumber(setMobileNumber());
		String password=setpassword();
		ac.setPassword(password);
		ac.setconfirmPassword(password);
		logger.info("Registeration Detailes Filled.........");
		
		ac.checkBox();
		ac.clickOnAgree();

		ac.clickOnSubmit();	
		logger.info("clicked on Subit & Account created!!.........");
		
	    String confMessage =ac.getConfirmationMessage();
	    Assert.assertEquals(confMessage, "Your Account Has Been Created!");
		
	}

}
