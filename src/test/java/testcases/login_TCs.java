package testcases;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsers.Chrome;
import net.bytebuddy.asm.Advice.Local;
import phptravels.pages.login;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
//import utils.ScreenShotOnFailure;


public class login_TCs {
	WebDriver driver;
	boolean testFail = true;
	String filename;
	//@Rule
	// public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);
	
	@Before 
	public void test() {		
	//Instantiating the chrome browser class and setting the local webdriver to the returned one 
	Chrome chrome = new Chrome();
	driver = chrome.StartChromeDriver("https://www.phptravels.net/login");
	}
	
	@Test
	public void emailValidationCheck() {
		filename = "emailValidationCheck";
		//Instantiating the login page class and using the web elements 
		login Login = new login(driver);
		Login.wePassword.sendKeys("sdfsdfs");
		Login.weLogin.click();
		//checking the correct validation message is displayed for the email/username feild
		assertEquals("Please fill in this field.",Login.weEmail.getAttribute("validationMessage"));	
		testFail = false;
	}
	
	@Test
	public void passwordValidationCheck() {
		filename = "passwordValidationCheckk";
		//Instantiating the login page class and using the web elements 
		login Login = new login(driver);
		Login.weEmail.sendKeys("sdfs@dfs");
		Login.weLogin.click();
		//checking the correct validation message is displayed for the password feild
		assertEquals("Please fill in this field.",Login.wePassword.getAttribute("validationMessage"));
		testFail = false;		
	}
	
	@Test
	public void loginHappyPath() {
		filename = "loginHappyPath";
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
		testFail = false;
	}
	
	@After
	public void afterTest() throws IOException {		
		if(testFail = true) {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("E:/"+filename+".jpg"));
		}
		driver.close();	
	}
}
