package SeleniumHub;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DesiredCap {
	
		
  @Test
  public void f() throws MalformedURLException {
	  DesiredCapabilities dc = new DesiredCapabilities();
	  dc.setBrowserName("firefox");
	  WebDriver driver = new RemoteWebDriver(new URL("http://10.44.204.215:4444/wd/hub"), dc);
	  driver.get("http://wordpress.com/wp-login.php");
	  
	  //Login code 
	 driver.findElement(By.id("user_login")).sendKeys("nidhi3112@gmail.com");
     driver.findElement(By.id("user_pass")).sendKeys("na35#@1234");
	 driver.findElement(By.id("wp-submit")).click();
	 
	 driver.quit();
	  
  }
  
  @AfterTest
	public void afterTestMethod() {
	  System.out.println("Test Completed");
	  
}
}
