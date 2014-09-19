package persistent.selMaven;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogs {

	WebDriver driver = new FirefoxDriver();
	// Getting a logger object
	private static Logger log = Logger.getLogger(TestLogs.class);

	@BeforeTest
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		
		/*Configure appender
		Mention the path of log4j.xml. Default location is src. If log4j file is present there,
		no need to mention the root loc else mention the location where the file is present.
		*/
		DOMConfigurator.configure("log4j.xml");
		
		// go to AUT URL
		driver.get("http://wordpress.com/wp-login.php");
		
		// printing user specified log messages
		log.debug("debugging starts now");
		log.info("URL loaded successfully");
		
		// finding elements
		driver.findElement(By.cssSelector("input#user_login")).sendKeys(
		"nidhi3112@gmail.com");
		driver.findElement(By.cssSelector("input#user_pass")).sendKeys(
				"na35#@1234");
		driver.findElement(
				By.cssSelector("html body form#loginform p.forgetmenot label input#rememberme"))
				.click();
		driver.findElement(By.cssSelector("input#wp-submit")).submit();
		driver.findElement(
				By.cssSelector("li#menu-settings a div.wp-menu-name")).click();
		driver.findElement(By.cssSelector("input#blogname")).clear();
		driver.findElement(By.cssSelector("input#blogname")).sendKeys(
				"nidhi_test");
		driver.findElement(By.cssSelector("input#submit")).submit();
		log.info("Settings saved successfully");
	}
	@AfterTest
	// close all web driver instances
	public void cleanup() {
		driver.quit();

	}
}
