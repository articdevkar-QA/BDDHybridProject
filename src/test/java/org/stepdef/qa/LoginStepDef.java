package org.stepdef.qa;



import org.hooks.qa.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef 
{
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		
		WebElement loginbtnlink = Hooks.driver.findElement(By.xpath("//a[text()='Log in']"));
		loginbtnlink.click();
	}

	@When("the user enters {string} and {string}  the user clicks the login button")
	public void the_user_enters_and_the_user_clicks_the_login_button(String Username, String Password) {
		WebElement email = Hooks.driver.findElement(By.xpath("//input[@id='Email']"));
		WebElement password = Hooks.driver.findElement(By.xpath("//input[@id='Password']"));
		WebElement Loginbtn = Hooks.driver.findElement(By.xpath("//input[@value='Log in']"));
		email.sendKeys(Username);
		password.sendKeys(Password);
		Loginbtn.click();
		String expectedtitle="Demo Web Shop";
	   	 
		Assert.assertEquals(Hooks.driver.getTitle(), expectedtitle, "Value is not matching"); 
		
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
		
		
	}

}
