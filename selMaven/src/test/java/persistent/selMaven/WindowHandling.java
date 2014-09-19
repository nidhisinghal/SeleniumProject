package persistent.selMaven;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandling {

	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//	driver.get("http://wordpress.com/wp-login.php");
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
	}

	@Test
	public void firstRun() {
/*
		driver.findElement(By.name("log")).sendKeys("nidhi3112@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("na35#@1234");
		driver.findElement(By.id("rememberme")).click();
		driver.findElement(By.id("wp-submit")).submit();
		try {
			Actions action = new Actions(driver);
			action.click(driver.findElement(By.linkText("My Sites")))
			.click(driver.findElement(By.linkText("Dashboard")));
			action.build().perform();		
			
			Set<String> handles = driver.getWindowHandles();
			for (String s:handles) {
				System.out.println(s);
			}
			//driver.switchTo().window("f1-4");
	*/
		try{
		
		String windowHandleBefore=driver.getWindowHandle();
		driver.findElement(By.cssSelector("a.facebook_icn.inner.rmargin5")).click();
		Set<String> handles = driver.getWindowHandles();
		for (String s:handles) {
			System.out.println(s);
			// switch to another new window
			driver.switchTo().window(s);
			String newTitle=driver.getTitle();
			if (newTitle.contains("Facebook")){
			System.out.println("The title of new facebook page is:" +newTitle);
			driver.findElement(By.id("email")).sendKeys("nidhi"+Keys.NUMPAD3+Keys.NUMPAD1+Keys.NUMPAD1+Keys.NUMPAD2+"@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("na35#@123");
			//driver.findElement(By.id("u_0_0")).click();
			//driver.close();
			}
		}
		
		//Switch back to default parent window
		driver.switchTo().window(windowHandleBefore);
					
		} catch (Exception e) {
			e.printStackTrace();
		}

		//driver.quit();
	}
}