package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtils 
{
	
	//Method to take screenshot.
	public static String getphoto(WebDriver driver,String folder,String filename) //Constructor method
	{
		try {
		String datetime=new Date().toString().replace(":", "_");
	    String path=folder+filename+datetime+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File destinationfile=new File(path);
		
			FileUtils.copyFile(sourcefile, destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		return filename;
		
	}
	//Method to take value from Property file
	/*public static String getproperty(String path, String key) {
		String v="";
		try {
			Properties p=new Properties();
		p.load(new FileInputStream(path));
		 v=p.getProperty(key);
		}
		catch(Exception e)
		{
			
		}
		return v;
	}*/
	
	public static String getproperty(String path, String key) 
	{ String v="";
		try
		{
		Properties p=new Properties();
		p.load(new FileInputStream(path));
		 v=p.getProperty(key);
		}
		catch(Exception e)
		{
			
		}
		
		
		return v;
		}
	
}
