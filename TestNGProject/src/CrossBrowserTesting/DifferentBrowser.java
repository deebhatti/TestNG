package CrossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class DifferentBrowser {
	
	@Test
	public void browser(){
//		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.ie.driver", "C:\\Webdrivers\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.facebook.com");
	}

}
