package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtmobileNumber;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement checkyes;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement aggree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationMesage;
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setMobileNumber(String mobile)
	{
		txtmobileNumber.sendKeys(mobile);
	}
	
	public void setPassword(String paswrd)
	{
		txtpassword.sendKeys(paswrd);
	}
	
	public void setconfirmPassword(String paswrd)
	{
		confirmPassword.sendKeys(paswrd);
	}
	
	public void checkBox()
	{
		checkyes.click();
	}
	
	public void clickOnAgree()
	{
		aggree.click();
	}
	
	public void clickOnSubmit()
	{
		btnSubmit.click();
	}



	public String getConfirmationMessage()
	{
		try {
		return (confirmationMesage.getText());
		}catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
}
	
	
