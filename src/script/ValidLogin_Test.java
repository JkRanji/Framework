package script;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel_Data;
import page.EnterPage;
import page.Loginpage;

public class ValidLogin_Test extends BaseTest
{
	@Test(priority=1,groups= {"login","smoke"})
	public void testValidLogin() throws InterruptedException
	{
		
		String un=Excel_Data.getValue(EXCEL_PATH, "Valid Login", 1, 0);
		String pw=Excel_Data.getValue(EXCEL_PATH, "Valid Login", 1, 1);
		String eTitle=Excel_Data.getValue(EXCEL_PATH, "Valid Login", 1, 2);
		Loginpage l=new Loginpage(driver);
		l.login(un, pw);
		/*l.setuserName(un);
		Thread.sleep(2000);
		l.setPassword(pw);
		Thread.sleep(2000);
		l.clickLogin();*/
		Thread.sleep(4000);
		EnterPage e=new EnterPage(driver);
		e.verifyHomePageDisplayed(driver, eTitle);
		Thread.sleep(2000);
		
	}
}
