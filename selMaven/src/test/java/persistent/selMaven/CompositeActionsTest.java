package persistent.selMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompositeActionsTest {
	
	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	
	 public void setUp() {
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
	  try{
	  WebElement mouseHoverElement = driver.findElement(By.linkText("Posts"));
	  Actions action = new Actions(driver);
	 // WebElement title_txt=driver.findElement(By.linkText("Enter title here"));
      action.moveToElement(mouseHoverElement)
      //.click(driver.findElement(By.linkText("Add New")))
      //.click(driver.findElement(By.linkText("Add New")))
      .click(driver.findElement(By.tagName("a[@href='post-new.php']")))
      .sendKeys(driver.findElement(By.id("title")), "My new blog");
      
      
      action.build().perform();
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  
	  //Actions action = new Actions(driver);
	  //action.moveToElement(mouseHoverElement).build().perform();
	  //driver.findElement(By.linkText("Add New")).click();
	  
	  
	  //Composite actions
	  driver.quit();
	  }
}
	  
	  
	  