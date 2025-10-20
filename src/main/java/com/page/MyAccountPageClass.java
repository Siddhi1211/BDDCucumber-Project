package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPageClass {

	WebDriver driver ; 
	
	//By locator 
	By cameralocator = By.linkText("Cameras");
	By breadcrumblocator = By.xpath("//ul[@class=\"breadcrumb\"]//li//a[contains(text(),\"Cameras\")]");
	
	//constructor
	MyAccountPageClass(WebDriver driver)
	{
		driver = this.driver;
	}
	
	//public method
	public void verifyBreadcrumbTitle()
	{
		
	}
	
}
