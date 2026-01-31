package org.base.qa;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.utils.qa.applicationread;

public class Basetest 
{
	public static WebDriver driver;

	public static void initialization() 
	{
		
		Properties properties= applicationread.getConfig();
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

}
