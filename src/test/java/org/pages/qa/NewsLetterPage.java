package org.pages.qa;

import org.base.qa.Basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewsLetterPage 
{
	public NewsLetterPage()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		Basetest.initialization();
	}
	@Test
	public void newsletter()
	{
		WebElement signupemail = Basetest.driver.findElement(By.xpath("//input[@id='newsletter-email']"));
		signupemail.sendKeys("abcvfsass@gmail.com");
		WebElement subbtn = Basetest.driver.findElement(By.xpath("//input[@value='Subscribe']"));
		subbtn.click();
		

	}
	@Test(dependsOnMethods = "newsletter")
	public void newslettervalidation()
	{
	boolean successMsg = Basetest.driver.findElement(By.id("newsletter-result-block")).isDisplayed();
    System.out.println("Newsletter subscription successful: " + successMsg);
	}
	@AfterMethod
	public void tearDown() {
		Basetest.driver.quit();
	}
}
