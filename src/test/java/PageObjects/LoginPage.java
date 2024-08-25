package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath= "//input[@id='input-email']")
	WebElement emailinput;
	
	
	@FindBy(xpath= "//input[@id='input-password']")
	WebElement paswdinput;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	
	public void insertEmaild(String email)
	{
		emailinput.sendKeys(email);	
	}
	
	public void insertPasword(String paswd)
	{
		paswdinput.sendKeys(paswd);
	}
	
	public void clickOnLoginButton()
	{
		loginbtn.click();
	}
	

}
