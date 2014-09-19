package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Dashboard {
	
	WebDriver driver;
	WebElement settings;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
	}

	
public Settings goToSettings() {
	settings=driver.findElement(By.cssSelector("li#menu-settings a div.wp-menu-name"));
	settings.click();
	
	return new Settings(driver);
		
}
}
