package org.stepdef.qa;


import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.hooks.qa.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.qa.Logutils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommunityStepDef 
{
	Logger log = Logutils.getLogger(CommunityStepDef.class);
	
	@Given("Customer at home page and should login")
	public void customer_at_home_page_and_should_login() 
	{
		System.out.println("just solving hen update");
		
		log.info("user wants to login");
	}

	@When("customer should select ratings as per wish and click on vote")
	public void customer_should_select_ratings_as_per_wish_and_click_on_vote() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

		WebElement pollbtn = wait.until(
		        ExpectedConditions.elementToBeClickable(By.id("pollanswers-1"))
		    );
		    pollbtn.click();

		    WebElement voteBtn = wait.until(
		        ExpectedConditions.elementToBeClickable(By.id("vote-poll-1"))
		    );
		    voteBtn.click();
		    log.info("successful");
				
	    
	}

	@Then("vote get displayed")
	public void vote_get_displayed() {
		
	
			System.out.println("just solve then upadate");
			

	    
	}


}
