package org.pages.qa;

import org.base.qa.Basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registerpage extends Basetest
{
	public Registerpage()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		Basetest.initialization();
	}
	@Test
	
	public void register()
	{
		WebElement Registerbtnlink = Basetest.driver.findElement(By.xpath("//a[text()='Register']"));
		Registerbtnlink.click();
		WebElement Gender=Basetest.driver.findElement(By.xpath("//input[@id='gender-female']"));
		Gender.click();
		WebElement FirstName =Basetest.driver.findElement(By.xpath("//input[@id='FirstName']"));
		FirstName.sendKeys("abc");
		WebElement LastName =Basetest.driver.findElement(By.xpath("//input[@id='LastName']"));
		LastName.sendKeys("xyz");
		WebElement email=Basetest.driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys("abc1@gmail.com");
		WebElement Password=Basetest.driver.findElement(By.xpath("//input[@id='Password']"));
		Password.sendKeys("Pass@123");
		WebElement ConfirmPassword=Basetest.driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		ConfirmPassword.sendKeys("Pass@123");
		WebElement Registerbtn=Basetest.driver.findElement(By.xpath("//input[@id='register-button']"));
		Registerbtn.click();
		WebElement titleElement = 	Basetest.driver.findElement(By.xpath("//h1[text()='Register']"));
		String actualValue = titleElement.getText();
		Assert.assertEquals(actualValue, "Register", "Value is not matching"); 
		
	}
	
	@AfterMethod
	public void teardown()
	{
		Basetest.driver.close();

	}

}
