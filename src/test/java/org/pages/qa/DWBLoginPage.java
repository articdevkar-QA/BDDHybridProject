package org.pages.qa;




import org.base.qa.Basetest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

public class DWBLoginPage extends Basetest
{
	public DWBLoginPage()
	{
		 super();
		 PageFactory.initElements(Basetest.driver, this);
	}
	
	
	@FindBy(id = "Email")
	static private WebElement Email;

	@FindBy(id = "Password")
	static private WebElement Password;

    @FindBy(css = "input.button-1.login-button")
    static private WebElement Loginbtn;

	
	@Test
	public void login(String un, String pwd) 
	{
		
		Email.sendKeys(un);
		Password.sendKeys(pwd);
		Loginbtn.click();
	}
	@AfterMethod
	public void tearDown() {
		Basetest.driver.quit();
	}
}
