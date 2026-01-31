package org.pages.qa;

import org.base.qa.Basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DWBCommunitypollpage
{
	public DWBCommunitypollpage()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		Basetest.initialization();
	}
	@Test
	public void TC001()
	{
	WebElement pollbtn = Basetest.driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
	pollbtn.click();
	WebElement Votebtn = Basetest.driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
	Votebtn.click();
	
	
	boolean pollResultDisplayed =
			Basetest.driver.findElement(By.xpath("//div[contains(@class,'poll-results')]")).isDisplayed();

	    System.out.println("Poll voted successfully: " + pollResultDisplayed);
	}
	
	@AfterMethod
	public void tearDown() {
		Basetest.driver.quit();
	}
}

