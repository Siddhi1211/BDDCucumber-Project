package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
	glue = {"com.stepDefinations"},
	plugin = {"pretty", "html:target/cucumber-reports", "json:targer/cuucmber.json"},
	monochrome = true,
	publish = true //publish report on cloud 
	

	)

public class TestRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	public Object[][] scenario()
	{
		return super.scenarios();
	}
// AbstractTestNGCucumberTests helps me to run my code in parallel mode
}
