package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
	public WebDriver StartChromeDriver(String urlIn){
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:/Development/Selenium2/phptravels/WebDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(urlIn);
		return driver;}
}
