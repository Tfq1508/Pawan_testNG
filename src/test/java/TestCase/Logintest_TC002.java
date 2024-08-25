package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class Logintest_TC002 extends BaseClass {
	
	@Test(groups= {"Sanity", "Master"})
	public void loginTest()
	{
		
		logger.info("Login Test Started*********");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnLogin();
		
		logger.info("Putting Email & Pasword for login*****");
		LoginPage lp= new LoginPage(driver);
		lp.insertEmaild(p.getProperty("Email"));
		lp.insertPasword(p.getProperty("Password"));
		lp.clickOnLoginButton();
		
		logger.info("Login Successfully ***");
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetpage=mp.loginConfirmationMessage();
		
		Assert.assertTrue(targetpage);
		}
		
		catch (Exception e)
		{
			Assert.fail();
		}
	
		logger.info("Login Test_002 ---- Complete*****");
		
	}

}
