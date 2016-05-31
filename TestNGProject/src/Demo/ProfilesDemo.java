package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProfilesDemo {
	WebDriver driver;
	
	@BeforeTest
	public void setUpDriver(){
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "fr");
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		
		
	}
	
	
	@Test
	public void start(){
		System.out.println(driver.getTitle());
	}
	
	

}
