package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Regression","Sanity", "Master"})
	@Parameters({"os", "browser"})
	public void setUp(String os, String br) throws InterruptedException, IOException
	{
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("Windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			
			else if(os.equalsIgnoreCase("Mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("Linux"))
					{
				     cap.setPlatform(Platform.LINUX);
					}
			
			else
			{
				System.out.println("No Matching os");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox": cap.setBrowserName("Firefox"); break;
			default : System.out.println("No matching browser"); return;
			}
			
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver= new ChromeDriver(); break;
			case "edge" : driver= new EdgeDriver(); break;
			case "firefox" : driver= new FirefoxDriver(); break;
			default : System.out.println("Invalid broser"); return;
			
			}
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("Appurl"));
		
			}
	
	@AfterClass(groups= {"Regression","Sanity", "Master"})
	public void terDown()
	{
		driver.close();
	}
	
	public String setFirstNameLastName()
	{
		String genratedString=RandomStringUtils.randomAlphabetic(4);
		return genratedString;
	}
	
	public String setMobileNumber()
	{
		String genratedMobile=RandomStringUtils.randomAlphanumeric(10);
		return genratedMobile;
	}
	
	public String setpassword()
	{
		String genratedString=RandomStringUtils.randomAlphabetic(4);
		String genratedMobile=RandomStringUtils.randomAlphanumeric(4);
		return (genratedMobile+"@"+genratedString);
	}
	
	//tname - Method name hai - jo result ke pass hai 
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}


}
