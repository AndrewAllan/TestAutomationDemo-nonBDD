package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsers.Chrome;
import phptravels.pages.login;


public class login_TCs {
	WebDriver driver;
	
	@Before 
	public void test() {		
	//Instantiating the chrome browser class and setting the local webdriver to the returned one 
	Chrome chrome = new Chrome();
	driver = chrome.StartChromeDriver("https://www.phptravels.net/login");
	}
	
	@Test
	public void emailValidationCheck() {
		//Instantiating the login page class and using the web elements 
		login Login = new login(driver);
		Login.wePassword.sendKeys("sdfsdfs");
		Login.weLogin.click();
		//checking the correct validation message is displayed for the email/username feild
		assertEquals("Please fill in this field.",Login.weEmail.getAttribute("validationMessage"));		
	}
	
	@Test
	public void passwordValidationCheck() {
		//Instantiating the login page class and using the web elements 
		login Login = new login(driver);
		Login.weEmail.sendKeys("sdfs@dfs");
		Login.weLogin.click();
		//checking the correct validation message is displayed for the password feild
		assertEquals("Please fill in this field.",Login.wePassword.getAttribute("validationMessage"));		
	}
	
	@Test
	public void loginHappyPath() {
		//Instantiating the login page class and using the web elements 
		login Login = new login(driver);
		Login.weEmail.sendKeys("user@phptravels.com");
		Login.wePassword.sendKeys("demouser");
		Login.weLogin.click();		
		//setting explicit wait 
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.urlContains("account"));
		//asserting that the user has navigated to the account page after successful login
		assertEquals("https://www.phptravels.net/account/",driver.getCurrentUrl());		
	}
	
	@After
	public void afterTest() {
		driver.close();	
	}
}
