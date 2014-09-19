package persistent.selMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest {
	
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	 public void setUp() {
	 System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
	driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
	 }
	
  @Test
  public void firstRun() {
	  
	  driver.get("http://wordpress.com/wp-login.php");
	  driver.findElement(By.cssSelector("input#user_login")).sendKeys("nidhi3112@gmail.com");
	  driver.findElement(By.cssSelector("input#user_pass")).sendKeys("na35#@1234");
	  driver.findElement(By.cssSelector("html body form#loginform p.forgetmenot label input#rememberme")).click();
	  driver.findElement(By.cssSelector("input#wp-submit")).submit();
	  driver.findElement(By.cssSelector("li#menu-settings a div.wp-menu-name")).click();
	  driver.findElement(By.cssSelector("input#blogname")).clear();
	  driver.findElement(By.cssSelector("input#blogname")).sendKeys("nidhi_test");
	  driver.findElement(By.cssSelector("input#submit")).submit();
	  String ActualText = driver.findElement(By.cssSelector("li#wp-admin-bar-blog a.ab-item")).getText();
	  System.out.println("Actual text is :" +ActualText);
	  String ExpectedText ="test_nidhi";
	  Assert(ActualText,ExpectedText,"the verification fails");
	  
  }
	  
	  private void Assert(String actualText, String expectedText, String string) {
			// TODO Auto-generated method stub
			if ((actualText.equals(expectedText)))
				System.out.println("the verification passed");
			else
				System.out.println(string);
		}

		@AfterTest
		public void afterTestMethod() {
		  System.out.println("After Test");
		  driver.close();
		  driver.quit();
	  }
	

	  
  }
