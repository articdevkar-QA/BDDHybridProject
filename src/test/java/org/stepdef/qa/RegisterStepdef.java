package org.stepdef.qa;

import org.hooks.qa.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepdef 
{
	@Given("User should be on demo Web Shop")
	public void user_should_be_on_demo_web_shop() 
	{
	    
	    WebElement Registerbtnlink = Hooks.driver.findElement(By.xpath("//a[text()='Register']"));
		Registerbtnlink.click();
	}

	@When("User Enter all deatils required for registration and click on register button")
	public void user_enter_all_deatils_required_for_registration_and_click_on_register_button() 
	{
		WebElement Registerbtnlink = Hooks.driver.findElement(By.xpath("//a[text()='Register']"));
		Registerbtnlink.click();
		WebElement Gender=Hooks.driver.findElement(By.xpath("//input[@id='gender-female']"));
		Gender.click();
		WebElement FirstName =Hooks.driver.findElement(By.xpath("//input[@id='FirstName']"));
		FirstName.sendKeys("abc");
		WebElement LastName =Hooks.driver.findElement(By.xpath("//input[@id='LastName']"));
		LastName.sendKeys("xyz");
		WebElement email=Hooks.driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys("abc12@gmail.com");
		WebElement Password=Hooks.driver.findElement(By.xpath("//input[@id='Password']"));
		Password.sendKeys("Pass@123");
		WebElement ConfirmPassword=Hooks.driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		ConfirmPassword.sendKeys("Pass@123");
		WebElement Registerbtn=Hooks.driver.findElement(By.xpath("//input[@id='register-button']"));
		Registerbtn.click();
		
	}

	@Then("Registration should be successful")
	public void registration_should_be_successful() {
		WebElement titleElement = 	Hooks.driver.findElement(By.xpath("//h1[text()='Register']"));
		String actualValue = titleElement.getText();
		Assert.assertEquals(actualValue, "Register", "Value is not matching"); 
	
	  
	}

}
