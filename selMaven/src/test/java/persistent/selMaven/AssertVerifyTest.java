package persistent.selMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.SeleneseTestBase;

public class AssertVerifyTest extends SeleneseTestBase {

	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
	}

	@Test
	public void f() {

		driver.get("http://wordpress.com/wp-login.php");
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
		String ActualText = driver.findElement(
				By.cssSelector("div#setting-error-settings_updated")).getText();
		String ExpectedText = "settings saved";
		try {
			assertEquals(ExpectedText, ActualText);
		} catch (Exception e) {
			System.out.println("Text Verification failed");
		}
	}

	@AfterTest
	// close all web driver instances
	public void cleanup() {
		driver.quit();

	}
}
