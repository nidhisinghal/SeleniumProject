package persistent.selMaven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHoverTest {
	
	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	
	 public void setUp() {
	  driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
	 }
	
	  @Test
     public void firstRun() {
	   
	  driver.get("http://wordpress.com/wp-login.php");
	  // Locator strategy name, id, class
	  
	  driver.findElement(By.name("log")).sendKeys("nidhi3112@gmail.com");
	  driver.findElement(By.name("pwd")).sendKeys("na35#@1234");
	  driver.findElement(By.id("rememberme")).click();
	  driver.findElement(By.id("wp-submit")).submit();
	  
	  driver.findElement(By.className("wp-menu-name")).click();
	  //driver.findElement(By.linkText("Posts")).click();
	  
	  
	  //Mouse Hover action 
	  WebElement mouseHoverElement = driver.findElement(By.linkText("Posts"));
	  Actions action = new Actions(driver);
	  action.moveToElement(mouseHoverElement).build().perform();
	  driver.findElement(By.linkText("Add New")).click();
	  
	  
	  
	  driver.quit();
	  }
}
	  
	  
	  