package org.stepdef.qa;


import java.time.Duration;

import org.hooks.qa.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NewsLetterSubscriptionStepDef 
{

	@Given("User should be at newsletter page")
	public void user_should_be_at_newsletter_page() throws InterruptedException {
		System.out.println("just soving issue");
		Thread.sleep(2000);
	    
	}

	@When("User enters email for subscription and clicks on subscribe button")
	public void user_enters_email_for_subscription_and_clicks_on_subscribe_button() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));
		WebElement signupemail = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='newsletter-email']"))
		    );
		signupemail.sendKeys("abcvfsass@gmail.com");

		    WebElement subbtn = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Subscribe']"))
		    );
		    subbtn.click();
		
		
		
		
		
		
	    
	}

	@Then("subscription should be successsful")
	public void subscription_should_be_successsful() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));

		    WebElement resultBlock = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            By.id("newsletter-result-block")
		        )
		    );
Thread.sleep(2000);
		    String actualText = resultBlock.getText();
		    Thread.sleep(2000);
		    Assert.assertTrue(
		        actualText.contains("Thank you for signing up"),
		        "Newsletter subscription message not displayed. Actual text: " + actualText
		    );
	   
	}
}
