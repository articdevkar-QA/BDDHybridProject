package org.hooks.qa;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testlistener.qa.TestListenerutils;
import org.utils.qa.Screenshotutils;
import org.utils.qa.applicationread;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks 
{
	public static WebDriver driver;

	@Before
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
	@After(order = 1)
	public void tearDown(Scenario scenario) 
	{
		
		if (scenario.isFailed()) {
			String screenshotPath = Screenshotutils.captureScreenshot( driver, scenario.getName());
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed_Step_Screenshot");
		}
		
		
		
	}
	@After(order = 0)
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; 
        }
    }
        
}
