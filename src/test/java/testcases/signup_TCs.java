package testcases;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import browsers.Chrome;
import phptravels.pages.SignUp;


public class signup_TCs {
	//setting up global variables to be used in multiple methods    
	WebDriver driver;
	
	//used for adding a random char to the email address feild as this has to be unique
	Random r = new Random();
	char c = (char)(r.nextInt(26) + 'a');
	
	@Before 
	public void test() {		
	System.out.println("fdsfsdf");
	Chrome chrome = new Chrome();
	driver = chrome.StartChromeDriver("https://www.phptravels.net/register");
	
	}
	
	@Test
	//to test the validation on the forename feild
	public void forenameValidationCheck() throws InterruptedException {
		SignUp signup = new SignUp(driver);
		signup.weLastname.sendKeys("aaa");
		signup.wePhone.sendKeys("07717212547");
		signup.weEmail.sendKeys("asd@asd"+c+".com");
		signup.wePassword.sendKeys("Aa.123");
		signup.weConfirmPassword.sendKeys("Aa.123");
		signup.weSignUp.click();	
		Thread.sleep(200);
		System.out.println(signup.weLastname.getAttribute("validationMessage"));
		assertEquals("Please fill in this field.",signup.weFirstname.getAttribute("validationMessage"));
	}
	
	@Test
	//to test the validation on the lastname feild
	public void lastnameValidationCheck() throws InterruptedException {
		SignUp signup = new SignUp(driver);
		signup.weFirstname.sendKeys("aaa");
		signup.wePhone.sendKeys("07717212547");
		signup.weEmail.sendKeys("asd@asd"+c+".com");
		signup.wePassword.sendKeys("Aa.123");
		signup.weConfirmPassword.sendKeys("Aa.123");
		signup.weSignUp.click();	
		Thread.sleep(200);
		System.out.println(signup.weLastname.getAttribute("validationMessage"));
		assertEquals("Please fill in this field.",signup.weLastname.getAttribute("validationMessage"));
	}
	
	@Test
	//to test the validation on the mobile number field
	public void mobileNumberValidationCheck() throws InterruptedException {
		SignUp signup = new SignUp(driver);
		signup.weFirstname.sendKeys("aaa");
		signup.weLastname.sendKeys("07717212547");
		signup.weEmail.sendKeys("asd@asd"+c+".com");
		signup.wePassword.sendKeys("Aa.123");
		signup.weConfirmPassword.sendKeys("Aa.123");
		signup.weSignUp.click();	
		Thread.sleep(200);
		System.out.println(signup.wePhone.getAttribute("validationMessage"));
		assertEquals("Please fill in this field.",signup.wePhone.getAttribute("validationMessage"));
	}
	
	@Test
	//to test the validation on the email feild
	public void emailValidationCheck() throws InterruptedException {
		SignUp signup = new SignUp(driver);
		signup.weFirstname.sendKeys("aaa");
		signup.wePhone.sendKeys("07717212547");
		signup.weLastname.sendKeys("asd@asd"+c+".com");
		signup.wePassword.sendKeys("Aa.123");
		signup.weConfirmPassword.sendKeys("Aa.123");
		signup.weSignUp.click();	
		Thread.sleep(200);
		System.out.println(signup.weEmail.getAttribute("validationMessage"));
		assertEquals("Please fill in this field.",signup.weEmail.getAttribute("validationMessage"));
	}
	
	@Test
	//to test the validation on the password feild
	public void passwordValidationCheck() throws InterruptedException {
		SignUp signup = new SignUp(driver);
		signup.weFirstname.sendKeys("aaa");
		signup.wePhone.sendKeys("07717212547");
		signup.weEmail.sendKeys("asd@asd"+c+".com");
		signup.weLastname.sendKeys("Aa.123");
		signup.weConfirmPassword.sendKeys("Aa.123");
		signup.weSignUp.click();	
		Thread.sleep(200);
		System.out.println(signup.wePassword.getAttribute("validationMessage"));
		assertEquals("Please fill in this field.",signup.wePassword.getAttribute("validationMessage"));
	}
	
	@Test
	//to test the validation on the confirm password feild
	public void confirmPasswordValidationCheck() throws InterruptedException {
		SignUp signup = new SignUp(driver);
		signup.weFirstname.sendKeys("aaa");
		signup.wePhone.sendKeys("07717212547");
		signup.weEmail.sendKeys("asd@asd"+c+".com");
		signup.wePassword.sendKeys("Aa.123");
		signup.weLastname.sendKeys("Aa.123");
		signup.weSignUp.click();	
		Thread.sleep(200);
		System.out.println(signup.weConfirmPassword.getAttribute("validationMessage"));
		assertEquals("Please fill in this field.",signup.weConfirmPassword.getAttribute("validationMessage"));
	}

	@Test
	//to test that a new user can sign up
	public void SignupHappyPath() throws InterruptedException {
		SignUp signup = new SignUp(driver);
		signup.weFirstname.sendKeys("aaa");
		signup.weLastname.sendKeys("Aa.123");
		signup.wePhone.sendKeys("07717212547");
		signup.weEmail.sendKeys("asd@asd"+c+".com");
		signup.wePassword.sendKeys("Aa.123");
		signup.weConfirmPassword.sendKeys("Aa.123");
		signup.weSignUp.click();	
		Thread.sleep(2000);
		assertEquals(driver.getCurrentUrl(),"https://www.phptravels.net/account/");
	}
	
	@After
	public void afterTest() {
		driver.close();	
	}
}
