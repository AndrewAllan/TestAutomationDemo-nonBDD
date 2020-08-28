package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	WebDriver driver;

	public login(WebDriver driverIn) {
		driver = driverIn;
		PageFactory.initElements(driver, this);
	}

	// WebElement for the remember me checkbox
	// xpath used as no other identifier is pressent
	@FindBy(xpath = "//label[@for='remember-me'][contains(.,'Remember Me')]")
	public WebElement weRememberMe;

	// WebElement for the email text box
	// Name used as no id is pressent
	@FindBy(name = "username")
	public WebElement weEmail;

	// WebElement for the Password text box
	// Name used as no id is pressent
	@FindBy(name = "password")
	public WebElement wePassword;
	
	// WebElement for the login button
	// xpath used as no other identifier is pressent
	@FindBy(xpath = "//*[@id=\"loginfrm\"]/button")
	public WebElement weLogin;
	
	// WebElement for the sign up button
	// xpath used as no other identifier is pressent
	@FindBy(name = "//*[@id=\"loginfrm\"]/div[4]/div[1]/a")
	public WebElement weSignUp;
	
	// WebElement for the forget password button
	// xpath used as no other identifier is pressent
	@FindBy(name = "//*[@id=\"loginfrm\"]/div[4]/div[3]/a")
	public WebElement weForgetPassword;
}
