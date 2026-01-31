package org.pages.qa;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.base.qa.Basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.qa.Excelreader;

public class LoginDatadriven extends Basetest
{
	DWBLoginPage login;
	@BeforeMethod
	public void setup()
	{
		Basetest.initialization();
		login =new DWBLoginPage();
		WebElement loginbtnlink = Basetest.driver.findElement(By.xpath("//a[text()='Log in']"));
		loginbtnlink.click();
	}
	
	@Test(dataProvider = "getData")
	public void TC001_ValidLogin(String un, String pwd) {
		login.login(un, pwd);
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
