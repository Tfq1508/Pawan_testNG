package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import Utilities.DataProviders;


public class LoginDDT_TC003 extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass= DataProviders.class, groups="Datadriven")//data proder different class me hai is lie dataproders.class likhna hai
	public void Veryfy_LoginDDT(String email, String Paswd, String exp)
	{
		logger.info("Started TC003_DDT*****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnLogin();
		
		logger.info("Catching email & Password from xcel data*****");
		LoginPage lp= new LoginPage(driver);
		lp.insertEmaild(email);
		lp.insertPasword(Paswd);
		lp.clickOnLoginButton();
		
		logger.info("Login Successfully ***");
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean targetpage=mp.loginConfirmationMessage();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				mp.logout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				mp.logout();
				Assert.assertTrue(false);
				
			}
			else
			{
				
				Assert.assertTrue(true);
			}
			}
		}catch(Exception e)
		{
			
			Assert.fail();
			
		}
		
		logger.info("Finished TC003_DDT*****");
		
		
		
		
		
	}

}
