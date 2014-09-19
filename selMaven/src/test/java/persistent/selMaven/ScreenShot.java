package persistent.selMaven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot {
	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//	driver.get("http://wordpress.com/wp-login.php");
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
	}

	@Test
	//Taking Screenshot of current page 
	public void takeSnapShot() throws IOException{
		//typecast the driver to take screenshot
		File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("./screenshot/snap.png"));
  }
	
	@AfterTest
	// close all web driver instances
	public void cleanup() {
		driver.quit();
	}
	
	
}
