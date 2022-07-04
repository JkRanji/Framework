package generic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

 public class BaseTest implements IAutoConstants{
	public WebDriver driver;
	static  
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@BeforeMethod(alwaysRun=true)
	public void openapp() throws FileNotFoundException, IOException 
	{
		String appURL=AutoUtils.getproperty(CONFIG_PATH, "URL");
		String strITO=AutoUtils.getproperty(CONFIG_PATH, "ITO");
		//long ITO=Long.parseLong(strITO);
		int ITO=Integer.parseInt(strITO);
		driver= new ChromeDriver();
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ITO));
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult testResult) 
	{
	String testname=testResult.getName();
	int status =testResult.getStatus();
	if(status==1)
	{
		Reporter.log(testname+"is PASSED",true);
		
	}
	else
	{
		Reporter.log(testname+"is Failed",true);
		AutoUtils.getphoto(driver, IMAGE_PATH, testname);
	}
	driver.quit();
	}

}
