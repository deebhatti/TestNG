package Demo;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewtoursMultipleCheck {
	WebDriver driver;
	private String expectedTitle;
	private String actualTitle;

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser){
		if (browser.equals("Firefox")){
			driver = new FirefoxDriver();
		}
		
		else if (browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Webdrivers\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.newtours.demoaut.com");
				
	}

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

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
