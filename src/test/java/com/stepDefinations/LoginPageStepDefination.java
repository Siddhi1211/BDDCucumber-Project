package com.stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.page.LoginPageClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefination {
 
	private WebDriver driver;
	private LoginPageClass loginPage;
	
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown()
	{
		if(driver!=null) {
			driver.quit();
		}
	}

@Given("I am on the OpenCart login page")
public void i_am_on_the_open_cart_login_page() {
    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    loginPage = new LoginPageClass(driver);
}

@Given("I have entered a valid username and password")
public void i_have_entered_a_valid_username_and_password() {
	loginPage.enterEmail("siddhiraut1211@gmail.com");
	loginPage.enterPassword("Pass@123");
}

@When("I click on the login button")
public void i_click_on_the_login_button() {
	loginPage.clickLoginButton();
}

@Then("I should be logged in successfully")
public void i_should_be_logged_in_successfully() {
	Assert.assertEquals(loginPage.logoutButtonLink(), true);
}

@Given("I have entered invalid {string} and \"\"abc@{int}")
public void i_have_entered_invalid_and_abc(String string, Integer int1) {
   }

@Then("I should see an error message indicating {string}")
public void i_should_see_an_error_message_indicating(String errorMessage) {
 Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);  
}

@Given("I have entered invalid {string} and {string}")
public void i_have_entered_invalid_and(String string, String string2) {
	loginPage.enterEmail(string);
	loginPage.enterPassword(string2);
}

@When("I click on the {string} link")
public void i_click_on_the_link(String string) {
    loginPage.clickForgottenPasswordLink();
}

@Then("I should be redirected to the reset password page")
public void i_should_be_redirected_to_the_reset_password_page() {
	Assert.assertTrue(loginPage.getForgotPasswordPageURL().contains("account/forgotten"));
}

}
