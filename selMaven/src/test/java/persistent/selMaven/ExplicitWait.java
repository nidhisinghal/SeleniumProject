package persistent.selMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWait {

	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://wordpress.com/wp-login.php");
		driver.manage().window().maximize();
	}

	@Test
	public void firstRun() {

		driver.get("http://wordpress.com/wp-login.php");
		driver.findElement(By.name("log")).sendKeys("nidhi3112@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("na35#@1234");
		driver.findElement(By.id("rememberme")).click();
		driver.findElement(By.id("wp-submit")).submit();
		try {
			driver.findElement(By.linkText("Posts")).click();
			driver.findElement(By.className("add-new-h2")).click();
			driver.findElement(By.name("post_title")).sendKeys("My first blog");
			driver.switchTo().frame("content_ifr");
			driver.findElement(By.id("tinymce")).sendKeys("Hi All!!");
			driver.switchTo().defaultContent();

			// Explicit wait
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = wait.until(ExpectedConditions
					.presenceOfElementLocated(By
							.cssSelector("span#sample-permalink")));
			System.out.println("The message for permalink is "
					+ element.getText());
			driver.findElement(By.cssSelector("input#publish")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}