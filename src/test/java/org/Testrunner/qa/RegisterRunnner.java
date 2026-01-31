package org.Testrunner.qa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",  
	    glue = {"org.stepdef.qa","org.hooks.qa"},
	    tags="@Register",
	    plugin = {
	        "pretty", 
	        "html:target/cucumber-reports.html",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
	    },
	    
	    monochrome = true
	)
public class RegisterRunnner extends AbstractTestNGCucumberTests{

}
