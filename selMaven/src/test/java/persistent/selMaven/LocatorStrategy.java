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

public class LocatorStrategy {
	
	
	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	
	 public void setUp() {
	 
	 driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
	 }
	
	  @Test
     public void firstRun() {
	   
	  driver.get("http://wordpress.com/wp-login.php");
	  /* Locator strategy name, id, class
	  
	  driver.findElement(By.name("log")).sendKeys("nidhi3112@gmail.com");
	  driver.findElement(By.name("pwd")).sendKeys("na35#@1234");
	  driver.findElement(By.id("rememberme")).click();
	  driver.findElement(By.id("wp-submit")).submit();
	  
	  driver.findElement(By.className("wp-menu-name")).click();
	  driver.findElement(By.linkText("Posts")).click();
	  driver.findElement(By.className("add-new-h2")).click();
	  driver.findElement(By.name("post_title")).sendKeys("My first blog");
	  driver.switchTo().frame("content_ifr");
	  driver.findElement(By.id("tinymce")).sendKeys("Hi All!!");
	  driver.switchTo().defaultContent();
	  
	  
	  */
	  
	  //Use of css seelctor to identify element
	  driver.findElement(By.cssSelector("input#user_login")).sendKeys("nidhi3112@gmail.com");
	  driver.findElement(By.cssSelector("input#user_pass")).sendKeys("na35#@1234");
	  driver.findElement(By.cssSelector("html body form#loginform p.forgetmenot label input#rememberme")).click();
	  driver.findElement(By.cssSelector("input#wp-submit")).submit();
	  driver.findElement(By.cssSelector("li#menu-settings a div.wp-menu-name")).click();
	  driver.findElement(By.cssSelector("input#blogname")).clear();
	  driver.findElement(By.cssSelector("input#blogname")).sendKeys("nidhi_test");
	  WebElement dropDownId = driver.findElement(By.name("lang_id"));
	  Select dropDown = new Select(dropDownId);
	  try {
	  List<WebElement> list = dropDown.getOptions();
	  for (WebElement option : list) {
	  		String optionText=option.getText();
		  System.out.println(optionText);
		  }
	  System.out.println("List of objects printed");
	  }
	  catch (Exception e) {
		  System.out.println("Exception occured" +e);
	  }
	  
	  
	  dropDown.selectByValue("18");
	  dropDown.selectByVisibleText("de - Deutsch");
	  driver.findElement(By.cssSelector("input#submit")).submit();
	  //driver.close(); // This close method is for creating alert pop up in the application
	 // Alert alert = driver.switchTo().alert();
	//  alert.dismiss();
	 // driver.switchTo().defaultContent();
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
	 // driver.close();
	  	  driver.quit();
  }
}
