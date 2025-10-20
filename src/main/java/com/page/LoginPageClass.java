package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageClass {

	private WebDriver driver;
	
	//By locators
	private By emailInputLocator = By.id("input-email");
	private By passwordInputLocator = By.id("input-password");
	private By loginButtonLocator = By.xpath("//input[@type=\"submit\"]");
	private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
	private By LogoutLinkLocator = By.linkText("Logout");
	
	//constructor
	public LoginPageClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Actions
	public void enterPassword(String password)
	{
		WebElement passwordInput = driver.findElement(passwordInputLocator);
		passwordInput.sendKeys(password);
	}
	public void enterEmail(String email)
	{
		WebElement emailInput = driver.findElement(emailInputLocator);
		emailInput.sendKeys(email);
	}
	public void clickLoginButton()
	{
		WebElement loginButton = driver.findElement(loginButtonLocator);
		loginButton.click();
	}
	public void clickForgottenPasswordLink() {
		WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
		forgottenPasswordLink.click();
	}
	public boolean forgottenPasswordLink()
	{
		return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
	}
	public boolean logoutButtonLink()
	{
		return driver.findElement(LogoutLinkLocator).isDisplayed();
	}
	public void login(String email, String password)
	{
		enterEmail(email);
		enterPassword(password);
		clickLoginButton();
	}
	public String getForgotPasswordPageURL()
	{
		String forgotPswURL = driver.getCurrentUrl();
		return forgotPswURL;
	}
}
