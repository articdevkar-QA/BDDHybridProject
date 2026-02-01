package org.pages.qa;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.base.qa.Basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.qa.Excelreader;

public class LoginDatadriven extends Basetest
{
	
	@BeforeMethod
	public void setup()
	{
		Basetest.initialization();
		
		WebElement loginbtnlink = Basetest.driver.findElement(By.xpath("//a[text()='Log in']"));
		loginbtnlink.click();
		PageFactory.initElements(Basetest.driver, this);
	}
	@FindBy(id = "Email")
	static private WebElement Email;

	@FindBy(id = "Password")
	static private WebElement Password;

    @FindBy(css = "input.button-1.login-button")
    static private WebElement Loginbtn;
	
	@Test(dataProvider = "getData")
	public void TC001_ValidLogin(String un, String pwd) {
		Email.sendKeys(un);
		Password.sendKeys(pwd);
		Loginbtn.click();
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {

		Object[][] obj = Excelreader.getExcelData("Sheet1");

		return obj;

	}
	@AfterMethod
	public void tearDown() {
		Basetest.driver.quit();
	}

}
