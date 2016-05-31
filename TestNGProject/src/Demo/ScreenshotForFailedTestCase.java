package Demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotForFailedTestCase {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	//Add a comment to see in Github

	@Test
	public void verifyTitle() throws IOException {
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mars");
		driver.findElement(By.name("login")).click();

		String pageTitle = driver.getTitle();

		if (pageTitle.equalsIgnoreCase("Sign-on: Mercury Tours")) {
			getScreenshot();
		}

		else {
			System.out.println("Correct credentials");
		}

	}

	private void getScreenshot() throws IOException {
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("C:\\Selenium9\\Screenshot.jpg"));
		
	}

}
