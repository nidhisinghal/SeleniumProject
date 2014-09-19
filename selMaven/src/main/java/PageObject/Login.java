package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver  driver;
	
	@FindBy(id="user_login")
	@CacheLookup
	WebElement userId;
	
	@FindBy(id="user_pass")
	@CacheLookup
	WebElement userPass;
	
	@FindBy(id="wp-submit")
	@CacheLookup
	WebElement submit;
	
	@FindBy(css="input.button.button-primary.button-large")
	@CacheLookup
	WebElement GenNewPassBtn;
	
	@FindBy(linkText="Lost your password?")
	@CacheLookup
	WebElement forgetPassLink;
	
	//WebElement msg;
	
	
	public Login (WebDriver driver) {
		this.driver = driver;
	}
	
	public Dashboard login(String uname, String pass) {
		/*
		userId=driver.findElement(By.id("user_login"));
		userPass=driver.findElement(By.id("user_pass"));
		submit=driver.findElement(By.id("wp-submit"));
		*/
		
		userId.sendKeys(uname);
		userPass.sendKeys(pass);
		submit.click();
		return PageFactory.initElements(driver, Dashboard.class);
		
		// To be used when PageFactory is notused
		//return new Dashboard(driver);
		
	}

	public Login forgetPassword(String uname){
		
		//forgetPassLink=driver.findElement(By.linkText("Lost your password?"));
		forgetPassLink.click();
		//userId=driver.findElement(By.id("user_login"));
		userId.sendKeys(uname);
		//GenNewPassBtn=driver.findElement(By.cssSelector("input.button.button-primary.button-large"));
		GenNewPassBtn.click();
		return PageFactory.initElements(driver, Login.class);
		//return new Login(driver);
	}
	}

