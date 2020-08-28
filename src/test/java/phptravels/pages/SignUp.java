package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	WebDriver driver;

	public SignUp(WebDriver driverIn) {
		driver = driverIn;
		PageFactory.initElements(driver, this);
	}

	// WebElement for the firstname text box
	// Name used as no id is pressent
	@FindBy(name = "firstname")
	public WebElement weFirstname;

	// WebElement for the lastname text box
	// Name used as no id is pressent
	@FindBy(name = "lastname")
	public WebElement weLastname;

	// WebElement for the Mobile Phone text box
	// Name used as no id is pressent
	@FindBy(name = "phone")
	public WebElement wePhone;

	// WebElement for the email text box
	// Name used as no id is pressent
	@FindBy(name = "email")
	public WebElement weEmail;

	// WebElement for the Password text box
	// Name used as no id is pressent
	@FindBy(name = "password")
	public WebElement wePassword;

	// WebElement for the confirm password text box
	// Name used as no id is pressent
	@FindBy(name = "confirmpassword")
	public WebElement weConfirmPassword;

	// WebElement for the submit button
	// xpath used as no other locator is pressent 
	@FindBy(xpath = "//*[@id='headersignupform']/div[8]/button")
	public WebElement weSignUp;
}
