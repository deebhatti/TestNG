package CrossBrowserTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Demo.SuperTestNG;
import reporter.JyperionListener;

@Listeners(JyperionListener.class)
public class CBT extends SuperTestNG {
	WebDriver driver;
	private String expectedTitle;
	private String actualTitle;
	
	
	@BeforeMethod
	public void verifyHomePageTitle() {
		expectedTitle = "Welcome: Mercury Tours";
		actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority=1)
	public void verifyRegisterTitle() {
		driver.findElement(By.linkText("REGISTER")).click();
		expectedTitle = "Register: Mercury Tours";
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority=0)
	public void verifySupportTitle() {
		driver.findElement(By.linkText("SUPPORT")).click();
		expectedTitle = "Under Construction: Mercury Tours";
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod
	public void returnToHomePage() {
		driver.findElement(By.linkText("Home")).click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
