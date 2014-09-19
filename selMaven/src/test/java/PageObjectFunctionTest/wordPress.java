package PageObjectFunctionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Dashboard;
import PageObject.Login;
import PageObject.Settings;

public class wordPress {
	
	WebDriver driver;
	Login l;
	Dashboard d;
	Settings s;
	
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://wordpress.com/wp-login.php");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
  @Test
  public void updateSettings() throws Exception {
	  l=new Login(driver);
	  try {
	  d=l.login("nidhi3112@gmail.com", "na35#@1234");
	  } catch (Exception e) {
		  forgetPass();
	  }
	  s=d.goToSettings();
	  s.updateBlogTitle("NidhiSinghal");
	  
	  	  
  }
  
  @Test
  public void forgetPass() {
	  l=new Login(driver);
	  l.forgetPassword("nidhi3112@gmail.com");
  }
  
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
  
}
