package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Loginpage {
	@FindBy(id="username")
	private WebElement unTB;
	@FindBy(name="pwd")
	private WebElement pwTB;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errorMSG;

	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Methods
	
	public void login(String un, String pw) throws InterruptedException
	{
		unTB.sendKeys(un);
		pwTB.sendKeys(pw);
		loginBTN.click();
		Thread.sleep(4000);
	}
	
	/*
	public void setuserName(String un)
	{
		unTB.sendKeys(un);
	}
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	public void clickLogin()
	{
		loginBTN.click();
	}
	
	*/
	public void verifyErrorMSG(String expectedMSG)
	{
		//
		String actualMSG = errorMSG.getText();
		Assert.assertEquals(actualMSG, expectedMSG);
	}

}
